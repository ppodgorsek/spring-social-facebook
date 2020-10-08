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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.social.facebook.api.GraphApi;
import org.springframework.social.facebook.api.ImageType;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Permission;
import org.springframework.social.facebook.api.PlaceTag;
import org.springframework.social.facebook.api.Reference;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.UserIdForApp;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.social.facebook.field.UserProfile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

class UserTemplate implements UserOperations {

	private final GraphApi graphApi;

	private final RestTemplate restTemplate;

	public UserTemplate(final GraphApi graphApi, final RestTemplate restTemplate) {
		this.graphApi = graphApi;
		this.restTemplate = restTemplate;
	}

	@Override
	public User getUserCoreProfile() {
		return getUserCoreProfile(UserProfile.CURRENT_USER);
	}

	@Override
	public User getUserCoreProfile(final String facebookId) {
		return getUserProfile(facebookId, UserProfile.CORE_PROFILE_FIELDS);
	}

	@Override
	public User getUserProfile(final String... profileFields) {

		if (profileFields == null || profileFields.length == 0) {
			return getUserCoreProfile();
		}

		return getUserProfile(UserProfile.CURRENT_USER, profileFields);
	}

	@Override
	public User getUserProfile(final String facebookId, final String... profileFields) {

		if (profileFields == null || profileFields.length == 0) {
			return getUserCoreProfile(facebookId);
		}

		return graphApi.fetchObject(facebookId, User.class, profileFields);
	}

	@Override
	public byte[] getUserProfileImage() {
		return getUserProfileImage(UserProfile.CURRENT_USER, ImageType.NORMAL);
	}

	@Override
	public byte[] getUserProfileImage(final String userId) {
		return getUserProfileImage(userId, ImageType.NORMAL);
	}

	@Override
	public byte[] getUserProfileImage(final ImageType imageType) {
		return getUserProfileImage(UserProfile.CURRENT_USER, imageType);
	}

	@Override
	public byte[] getUserProfileImage(final String userId, final ImageType imageType) {
		return graphApi.fetchImage(userId, "picture", imageType);
	}

	@Override
	public byte[] getUserProfileImage(final Integer width, final Integer height) {
		return getUserProfileImage(UserProfile.CURRENT_USER, width, height);
	}

	@Override
	public byte[] getUserProfileImage(final String userId, final Integer width,
			final Integer height) {
		return graphApi.fetchImage(userId, "picture", width, height);
	}

	@Override
	public List<Permission> getUserPermissions() {
		JsonNode responseNode = restTemplate.getForObject(
				graphApi.getBaseGraphApiUrl() + UserProfile.CURRENT_USER + "/permissions",
				JsonNode.class);
		return deserializePermissionsNodeToList(responseNode);
	}

	@Override
	public List<UserIdForApp> getIdsForBusiness() {
		return graphApi.fetchConnections(UserProfile.CURRENT_USER, "ids_for_business",
				UserIdForApp.class);
	}

	@Override
	public List<PlaceTag> getTaggedPlaces() {
		return graphApi.fetchConnections(UserProfile.CURRENT_USER, "tagged_places", PlaceTag.class);
	}

	@Override
	public PagedList<Reference> search(final String query) {
		MultiValueMap<String, String> queryMap = new LinkedMultiValueMap<>();
		queryMap.add("q", query);
		queryMap.add("type", "user");
		return graphApi.fetchConnections("search", null, Reference.class, queryMap);
	}

	private List<Permission> deserializePermissionsNodeToList(final JsonNode jsonNode) {
		JsonNode dataNode = jsonNode.get("data");
		List<Permission> permissions = new ArrayList<>();
		for (Iterator<JsonNode> elementIt = dataNode.elements(); elementIt.hasNext();) {
			JsonNode permissionsElement = elementIt.next();
			String name = permissionsElement.get("permission").asText();
			String status = permissionsElement.get("status").asText();
			permissions.add(new Permission(name, status));
		}
		return permissions;
	}

}
