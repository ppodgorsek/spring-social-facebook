/*
 * Copyright 2019 the original author or authors.
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
package org.springframework.social.facebook.permission;

/**
 * Permissions for Facebook Pages and Business Assets.
 *
 * @author Paul Podgorsek
 * @see <a href="https://developers.facebook.com/docs/facebook-login/permissions">Facebook Developers: Login permissions</a>
 */
public enum FacebookPagePermission implements FacebookPermission {

	/**
	 * <p>
	 * Grants your app the ability to both read and manage the ads for ad accounts you own or have been granted access to by the owner or owners of the ad accounts through this permission.
	 * By default, your app may only access ad accounts that are owned by admins of the app when in developer mode.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Programmatically create campaigns, manage ads, and fetch metrics.</li>
	 * <li>Build ad management tools that provide innovative solutions and differentiated value for advertisers.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Businesses must not try to reverse engineer how Facebook's delivery engine works.</li>
	 * <li>Businesses must not try to duplicate too many of the same ads to increase chance that ads are delivered.</li>
	 * </ul>
	 */
	ADS_MANAGEMENT("ads_management"),

	/**
	 * <p>
	 * Grants your app access to the Ads Insights API to pull ads report information for ad accounts you own or have been granted access to by the owner or owners of other ad accounts through this permission.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Provide API access to your ad performance data for use in custom dashboards and data analytics.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Businesses must not try to identify an individual and target them with specific ads.</li>
	 * <li>Businesses must not share audiences across products owned by different businesses.</li>
	 * <li>Businesses must not share insights across products owned by different businesses.</li>
	 * </ul>
	 */
	ADS_READ("ads_read"),

	/**
	 * <p>
	 * Grants your app access to the Attribution API to pull attribution report data for lines of business you own or have been granted access to by the owner or owners of other lines of business.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Provides the ability for your app to access ad performance data from Attribution for use in custom dashboards and data analytics.</li>
	 * </ul>
	 */
	ATTRIBUTION_READ("attribution_read"),

	/**
	 * <p>
	 * Grants your app permission to read and write with the Business Manager API.
	 * <p>
	 *
	 * <p>
	 * Requires App Review.
	 * </p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Manage business assets such as an ad account. Claiming ad accounts.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Performing general page management and administration only.</li>
	 * </ul>
	 */
	BUSINESS_MANAGEMENT("business_management"),

	/**
	 * <p>
	 * Grants your app permission to retrieve all information captured by a lead.
	 * Also requires the manage_pages permission.
	 * <p>
	 *
	 * <p>
	 * Requires App Review.
	 * </p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Leads are generally submitted by users in response to specific kinds of CTA (Sign ups, Get Quotes, etc.) shown on the ad. The information within the lead is used to reach out to the users to follow up on those CTA. For example, a dealer reaches out to a potential customer (lead) with quotes for a car.</li>
	 * <li>By advertiser authorized CRM platforms to pull the lead data on behalf of the advertisers. The advertisers then use the lead information to reach out to the user.</li>
	 * </ul>
	 */
	LEADS_RETRIEVAL("leads_retrieval"),

	/**
	 * <p>
	 * Grants an app permission to retrieve Page Access Tokens for the Pages and Apps that the app user administers.
	 * Apps that allow users to publish as a Page must also have the publish_pages permission.
	 * <p>
	 *
	 * <p>
	 * Requires App Review.
	 * </p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Publish content to Pages owned by the people who use your app. Publishing also requires the publish_pages permission.</li>
	 * <li>Help people manage the posts, comments and likes published to their Pages.</li>
	 * </ul>
	 */
	MANAGE_PAGES("manage_pages"),

	/**
	 * <p>
	 * Allows app to perform POST and DELETE operations on endpoints used for managing a Page's Call To Action buttons.
	 * <p>
	 *
	 * <p>
	 * Requires App Review.
	 * </p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Provides API access to manage call to actions on Pages that you manage</li>
	 * </ul>
	 */
	PAGES_MANAGE_CTA("pages_manage_cta"),

	/**
	 * <p>
	 * Grants an app permission to manage Instant Articles on behalf of Facebook Pages administered by people using your app.
	 * <p>
	 *
	 * <p>
	 * Requires App Review.
	 * </p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Create and update Instant Articles for Pages owned by the people who use your app.</li>
	 * </ul>
	 */
	PAGES_MANAGE_INSTANT_ARTICLES("pages_manage_instant_articles"),

	/**
	 * <p>
	 * Grants your app access to show the list of the Pages that a person manages.
	 * <p>
	 *
	 * <p>
	 * Does not require App Review.
	 * </p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Provides API access to accounts for showing the list of the Pages that a person manages.</li>
	 * </ul>
	 */
	PAGES_SHOW_LIST("pages_show_list"),

	/**
	 * <p>
	 * Grants your app permission to publish posts, comments, and like Pages managed by the app user.
	 * Also requires the manage_pages permission.
	 * <p>
	 *
	 * <p>
	 * Requires App Review.
	 * </p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Allow app users to explicitly publish content from your app to any of the Facebook Pages they manage from within a custom composer.</li>
	 * <li>Seamlessly like and comment from your app on behalf of the Pages app users manage.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Automatically publish stories without app users being aware or having control.</li>
	 * <li>Pre-filling the messages of Posts with content the app user or business didn't create.</li>
	 * </ul>
	 */
	PUBLISH_PAGES("publish_pages"),

	/**
	 * <p>
	 * Grants an app permissions to read-only access of the Insights data for Pages, Apps, and web domains the person owns.
	 * <p>
	 *
	 * <p>
	 * Requires App Review.
	 * </p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Integrate Facebook's app, page or domain insights into your own analytics tools.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Transfer or sell insights data to third parties.</li>
	 * <li>Provide any non-visible use of insights.</li>
	 * </ul>
	 */
	READ_INSIGHTS("read_insights");

	private String name;

	/**
	 * Default private constructor used to assign the official Facebook name to each permission.
	 *
	 * @param permissionName
	 *            Facebook's official name for the permission.
	 */
	private FacebookPagePermission(final String permissionName) {
		name = permissionName;
	}

	/**
	 * @return The official name for the permission.
	 */
	@Override
	public String getName() {
		return name;
	}

}
