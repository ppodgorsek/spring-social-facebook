/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.facebook.api.impl;

import static org.springframework.social.facebook.api.impl.PagedListUtils.getPagedListParameters;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.UncategorizedApiException;
import org.springframework.social.facebook.api.AchievementOperations;
import org.springframework.social.facebook.api.CommentOperations;
import org.springframework.social.facebook.api.EventOperations;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FeedOperations;
import org.springframework.social.facebook.api.FriendOperations;
import org.springframework.social.facebook.api.GroupOperations;
import org.springframework.social.facebook.api.ImageType;
import org.springframework.social.facebook.api.LikeOperations;
import org.springframework.social.facebook.api.MediaOperations;
import org.springframework.social.facebook.api.OpenGraphOperations;
import org.springframework.social.facebook.api.PageOperations;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.SocialContextOperations;
import org.springframework.social.facebook.api.TestUserOperations;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.social.facebook.api.impl.json.FacebookModule;
import org.springframework.social.facebook.security.FacebookAppSecretProofInterceptor;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * This is the central class for interacting with Facebook.
 * </p>
 * <p>
 * There are some operations, such as searching, that do not require OAuth authentication. In those
 * cases, you may use a {@link FacebookTemplate} that is created through the default constructor and
 * without any OAuth details. Attempts to perform secured operations through such an instance,
 * however, will result in {@link NotAuthorizedException} being thrown.
 * </p>
 *
 * @author Craig Walls
 */
@Slf4j
public class FacebookTemplate extends AbstractOAuth2ApiBinding implements Facebook {

	private final String appId;

	private final String appSecret;

	private final String accessToken;

	private AchievementOperations achievementOperations;

	private UserOperations userOperations;

	private FriendOperations friendOperations;

	private FeedOperations feedOperations;

	private GroupOperations groupOperations;

	private CommentOperations commentOperations;

	private LikeOperations likeOperations;

	private EventOperations eventOperations;

	private MediaOperations mediaOperations;

	private PageOperations pageOperations;

	private OpenGraphOperations openGraphOperations;

	private SocialContextOperations socialContextOperations;

	private TestUserOperations testUserOperations;

	private ObjectMapper objectMapper;

	private final String applicationNamespace;

	private String apiVersion = DEFAULT_API_VERSION;

	/**
	 * Create a new instance of FacebookTemplate. This constructor creates the FacebookTemplate
	 * using a given access token.
	 *
	 * @param accessToken
	 *            An access token given by Facebook after a successful OAuth 2 authentication (or
	 *            through Facebook's JS library).
	 */
	public FacebookTemplate(final String accessToken) {
		this(accessToken, null);
	}

	public FacebookTemplate(final String accessToken, final String applicationNamespace) {
		this(accessToken, applicationNamespace, null);
	}

	public FacebookTemplate(final String accessToken, final String applicationNamespace,
			final String appId) {
		this(accessToken, applicationNamespace, appId, null);
	}

	public FacebookTemplate(final String accessToken, final String applicationNamespace,
			final String appId, final String appSecret) {
		super(accessToken);
		this.appSecret = appSecret;
		this.accessToken = accessToken;
		this.applicationNamespace = applicationNamespace;
		this.appId = appId;
		initialize();

		if (appSecret != null) {
			setAppSecretInterceptor(getRestTemplate());
		}
	}

	@Override
	public void setRequestFactory(final ClientHttpRequestFactory requestFactory) {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so that the error
		// handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(requestFactory));
	}

	/**
	 * Set the Graph API version (e.g., "7.0"). If set to null, the version will be left out of the
	 * request URLs to the Graph API.
	 *
	 * @param apiVersion
	 *            the API version.
	 */
	public void setApiVersion(final String apiVersion) {
		this.apiVersion = apiVersion;
	}

	@Override
	public AchievementOperations achievementOperations() {
		return achievementOperations;
	}

	@Override
	public UserOperations userOperations() {
		return userOperations;
	}

	@Override
	public LikeOperations likeOperations() {
		return likeOperations;
	}

	@Override
	public FriendOperations friendOperations() {
		return friendOperations;
	}

	@Override
	public FeedOperations feedOperations() {
		return feedOperations;
	}

	@Override
	public GroupOperations groupOperations() {
		return groupOperations;
	}

	@Override
	public CommentOperations commentOperations() {
		return commentOperations;
	}

	@Override
	public EventOperations eventOperations() {
		return eventOperations;
	}

	@Override
	public MediaOperations mediaOperations() {
		return mediaOperations;
	}

	@Override
	public PageOperations pageOperations() {
		return pageOperations;
	}

	@Override
	public RestOperations restOperations() {
		return getRestTemplate();
	}

	@Override
	public OpenGraphOperations openGraphOperations() {
		return openGraphOperations;
	}

	@Override
	public SocialContextOperations socialContextOperations() {
		return socialContextOperations;
	}

	@Override
	public String getApplicationNamespace() {
		return applicationNamespace;
	}

	@Override
	public TestUserOperations testUserOperations() {
		return testUserOperations;
	}

	// low-level Graph API operations
	@Override
	public <T> T fetchObject(final String objectId, final Class<T> type) {

		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId).build();

		log.debug("Fetching {} '{}' from URI {}", type.getSimpleName(), objectId, uri);

		return getRestTemplate().getForObject(uri, type);
	}

	@Override
	public <T> T fetchObject(final String objectId, final Class<T> type, final String... fields) {

		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<>();

		if (fields.length > 0) {
			String joinedFields = join(fields);
			queryParameters.set("fields", joinedFields);
		}

		return fetchObject(objectId, type, queryParameters);
	}

	@Override
	public <T> T fetchObject(final String objectId, final Class<T> type,
			final MultiValueMap<String, String> queryParameters) {

		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId).queryParams(queryParameters)
				.build();

		log.debug("Fetching {} '{}' from URI {}", type.getSimpleName(), objectId, uri);

		return getRestTemplate().getForObject(uri, type);
	}

	@Override
	public <T> PagedList<T> fetchConnections(final String objectId, final String connectionType,
			final Class<T> type, final String... fields) {

		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<>();

		if (fields.length > 0) {
			String joinedFields = join(fields);
			queryParameters.set("fields", joinedFields);
		}

		return fetchConnections(objectId, connectionType, type, queryParameters);
	}

	@Override
	public <T> PagedList<T> fetchConnections(final String objectId, final String connectionType,
			final Class<T> type, final MultiValueMap<String, String> queryParameters) {

		log.debug("Fetching {} connections for {} '{}' with the following query parameters: {}",
				connectionType, type.getSimpleName(), objectId, queryParameters);

		String connectionPath = connectionType != null && connectionType.length() > 0
				? "/" + connectionType
				: "";
		URIBuilder uriBuilder = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId + connectionPath)
				.queryParams(queryParameters);
		JsonNode jsonNode = getRestTemplate().getForObject(uriBuilder.build(), JsonNode.class);

		return pagify(type, jsonNode);
	}

	public <T> PagedList<T> fetchPagedConnections(final String objectId,
			final String connectionType, final Class<T> type,
			final MultiValueMap<String, String> queryParameters) {

		log.debug(
				"Fetching paged {} connections for {} '{}' with the following query parameters: {}",
				connectionType, type.getSimpleName(), objectId, queryParameters);

		String connectionPath = connectionType != null && connectionType.length() > 0
				? "/" + connectionType
				: "";
		URIBuilder uriBuilder = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId + connectionPath)
				.queryParams(queryParameters);
		JsonNode jsonNode = getRestTemplate().getForObject(uriBuilder.build(), JsonNode.class);

		return pagify(type, jsonNode);
	}

	@Override
	public <T> PagedList<T> fetchConnections(final String objectId, final String connectionType,
			final Class<T> type, final MultiValueMap<String, String> queryParameters,
			final String... fields) {
		if (fields.length > 0) {
			String joinedFields = join(fields);
			queryParameters.set("fields", joinedFields);
		}
		return fetchPagedConnections(objectId, connectionType, type, queryParameters);
	}

	/**
	 * Fetches the next {@link org.springframework.social.facebook.api.PagedList PagedList} of the
	 * current one.
	 *
	 * @param page
	 *            source {@link org.springframework.social.facebook.api.PagedList PagedList} to
	 *            fetch the next one.
	 * @param type
	 *            type of the source {@link org.springframework.social.facebook.api.PagedList
	 *            PagedList} and the next one.
	 * @param <T>
	 *            the type of the source
	 * @return the next {@link org.springframework.social.facebook.api.PagedList PagedList} of the
	 *         given one. It returns <code>null</code> if the next
	 *         {@link org.springframework.social.facebook.api.PagedList PagedList} doesn't exist.
	 */
	public <T> PagedList<T> fetchNextPagedConnections(final PagedList<T> page,
			final Class<T> type) {
		if (null != page && null != page.getNextPage()
				&& !"".equals(page.getNextPage().getFullUrl().trim())) {
			URIBuilder uriBuilder = URIBuilder.fromUri(page.getNextPage().getFullUrl());
			JsonNode jsonNode = getRestTemplate().getForObject(uriBuilder.build(), JsonNode.class);
			return pagify(type, jsonNode);
		}
		return null;
	}

	/**
	 * Fetchs the previous {@link org.springframework.social.facebook.api.PagedList PagedList} of
	 * the current one.
	 *
	 * @param page
	 *            source {@link org.springframework.social.facebook.api.PagedList PagedList} to
	 *            fetch the previous one.
	 * @param type
	 *            type of the source {@link org.springframework.social.facebook.api.PagedList
	 *            PagedList} and the previous one.
	 * @return the previous {@link org.springframework.social.facebook.api.PagedList PagedList} of
	 *         the given one.
	 * @param <T>
	 *            the type of the source It returns <code>null</code> if the previous
	 *            {@link org.springframework.social.facebook.api.PagedList PagedList} doesn't exist.
	 */
	public <T> PagedList<T> fetchPreviousPagedConnections(final PagedList<T> page,
			final Class<T> type) {
		if (null != page && null != page.getPreviousPage()
				&& !"".equals(page.getPreviousPage().getFullUrl().trim())) {
			URIBuilder uriBuilder = URIBuilder.fromUri(page.getPreviousPage().getFullUrl());
			JsonNode jsonNode = getRestTemplate().getForObject(uriBuilder.build(), JsonNode.class);
			return pagify(type, jsonNode);
		}
		return null;
	}

	private <T> PagedList<T> pagify(final Class<T> type, final JsonNode jsonNode) {
		List<T> data = deserializeDataList(jsonNode.get("data"), type);
		if (!jsonNode.has("paging")) {
			return new PagedList<>(data, null, null);
		}

		JsonNode pagingNode = jsonNode.get("paging");
		PagingParameters previousPage = getPagedListParameters(pagingNode, "previous");
		PagingParameters nextPage = getPagedListParameters(pagingNode, "next");

		Integer totalCount = null;
		if (jsonNode.has("summary")) {
			JsonNode summaryNode = jsonNode.get("summary");
			if (summaryNode.has("total_count")) {
				totalCount = summaryNode.get("total_count").intValue();
			}
		}

		return new PagedList<>(data, previousPage, nextPage, totalCount);
	}

	@Override
	public String getBaseGraphApiUrl() {
		if (apiVersion != null) {
			return "https://graph.facebook.com/v" + apiVersion + "/";
		}
		return "https://graph.facebook.com/";
	}

	@Override
	public byte[] fetchImage(final String objectId, final String connectionType,
			final ImageType type) {
		return fetchImage(objectId, connectionType, type, null, null);
	}

	@Override
	public byte[] fetchImage(final String objectId, final String connectionType,
			final Integer width, final Integer height) {
		return fetchImage(objectId, connectionType, null, width, height);
	}

	private byte[] fetchImage(final String objectId, final String connectionType,
			final ImageType type, final Integer width, final Integer height) {
		URIBuilder uriBuilder = URIBuilder
				.fromUri(getBaseGraphApiUrl() + objectId + "/" + connectionType);
		if (type != null) {
			uriBuilder.queryParam("type", type.toString().toLowerCase());
		}
		if (width != null) {
			uriBuilder.queryParam("width", width.toString());
		}
		if (height != null) {
			uriBuilder.queryParam("height", height.toString());
		}
		URI uri = uriBuilder.build();
		ResponseEntity<byte[]> response = getRestTemplate().getForEntity(uri, byte[].class);
		if (response.getStatusCode() == HttpStatus.FOUND) {
			throw new UnsupportedOperationException(
					"Attempt to fetch image resulted in a redirect which could not be followed. Add Apache HttpComponents HttpClient to the classpath "
							+ "to be able to follow redirects.");
		}
		return response.getBody();
	}

	@Override
	@SuppressWarnings("unchecked")
	public String publish(final String objectId, final String connectionType,
			final MultiValueMap<String, Object> data) {
		MultiValueMap<String, Object> requestData = new LinkedMultiValueMap<>(data);
		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId + "/" + connectionType)
				.build();
		Map<String, Object> response = getRestTemplate().postForObject(uri, requestData, Map.class);
		return (String) response.get("id");
	}

	@Override
	public void post(final String objectId, final MultiValueMap<String, Object> data) {
		post(objectId, null, data);
	}

	@Override
	public void post(final String objectId, final String connectionType,
			final MultiValueMap<String, Object> data) {
		String connectionPath = connectionType != null ? "/" + connectionType : "";
		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId + connectionPath).build();
		getRestTemplate().postForObject(uri, new LinkedMultiValueMap<>(data), String.class);
	}

	@Override
	public void delete(final String objectId) {
		LinkedMultiValueMap<String, String> deleteRequest = new LinkedMultiValueMap<>();
		deleteRequest.set("method", "delete");
		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId).build();
		getRestTemplate().postForObject(uri, deleteRequest, String.class);
	}

	@Override
	public void delete(final String objectId, final String connectionType) {
		LinkedMultiValueMap<String, String> deleteRequest = new LinkedMultiValueMap<>();
		deleteRequest.set("method", "delete");
		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId + "/" + connectionType)
				.build();
		getRestTemplate().postForObject(uri, deleteRequest, String.class);
	}

	@Override
	public void delete(final String objectId, final String connectionType,
			final MultiValueMap<String, String> data) {
		data.set("method", "delete");
		URI uri = URIBuilder.fromUri(getBaseGraphApiUrl() + objectId + "/" + connectionType)
				.build();
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(data,
				new HttpHeaders());
		getRestTemplate().exchange(uri, HttpMethod.POST, entity, String.class);
	}

	// AbstractOAuth2ApiBinding hooks
	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.DRAFT_10;
	}

	@Override
	protected void configureRestTemplate(final RestTemplate restTemplate) {
		restTemplate.setErrorHandler(new FacebookErrorHandler());
	}

	private void setAppSecretInterceptor(final RestTemplate restTemplate) {
		List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
		interceptors.add(new FacebookAppSecretProofInterceptor(accessToken, appSecret));
		restTemplate.setInterceptors(interceptors);
	}

	@Override
	protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
		MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
		objectMapper = new ObjectMapper();
		objectMapper.registerModule(new FacebookModule());
		converter.setObjectMapper(objectMapper);
		return converter;
	}

	// private helpers
	private void initialize() {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so that the error
		// handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector
				.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis();
	}

	private void initSubApis() {
		achievementOperations = new AchievementTemplate(this);
		openGraphOperations = new OpenGraphTemplate(this);
		userOperations = new UserTemplate(this, getRestTemplate());
		friendOperations = new FriendTemplate(this, getRestTemplate());
		feedOperations = new FeedTemplate(this, getRestTemplate(), objectMapper);
		commentOperations = new CommentTemplate(this);
		likeOperations = new LikeTemplate(this);
		eventOperations = new EventTemplate(this);
		mediaOperations = new MediaTemplate(this, getRestTemplate());
		groupOperations = new GroupTemplate(this);
		pageOperations = new PageTemplate(this);
		testUserOperations = new TestUserTemplate(this, getRestTemplate(), appId);
		socialContextOperations = new SocialContextTemplate(this, getRestTemplate());
	}

	@SuppressWarnings("unchecked")
	private <T> List<T> deserializeDataList(final JsonNode jsonNode, final Class<T> elementType) {
		try {
			CollectionType listType = TypeFactory.defaultInstance()
					.constructCollectionType(List.class, elementType);
			return (List<T>) objectMapper.readerFor(listType).readValue(jsonNode.toString()); // TODO:
																								// EXTREMELY
																								// HACKY--TEMPORARY
																								// UNTIL
																								// I
																								// FIGURE
																								// OUT
																								// HOW
																								// JACKSON
																								// 2
																								// DOES
																								// THIS
		}
		catch (IOException e) {
			log.error("Error deserializing data from Facebook: {}", e.getMessage());

			throw new UncategorizedApiException("facebook",
					"Error deserializing data from Facebook: " + e.getMessage(), e);
		}
	}

	private String join(final String[] strings) {
		StringBuilder builder = new StringBuilder();
		if (strings.length > 0) {
			builder.append(strings[0]);
			for (int i = 1; i < strings.length; i++) {
				builder.append("," + strings[i]);
			}
		}
		return builder.toString();
	}

}
