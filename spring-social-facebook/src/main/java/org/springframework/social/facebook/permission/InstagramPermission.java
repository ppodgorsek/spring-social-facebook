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
 * Permissions for the Instagram Platform.
 *
 * @author Paul Podgorsek
 * @see <a href="https://developers.facebook.com/docs/facebook-login/permissions">Facebook Developers: Login permissions</a>
 */
public enum InstagramPermission implements FacebookPermission {

	/**
	 * <p>
	 * Grants your app permission to read Instagram Accounts users of your app manage.
	 * </p>
	 *
	 * <p>
	 * Requires App Review.
	 * </p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Get basic metadata of an Instagram Business Account.</li>
	 * </ul>
	 */
	INSTAGRAM_BASIC("instagram_basic"),
	
	/**
	 * <p>
	 * Grants the ability to create organic feed photo and video posts on behalf of a business user. This permission is used with the Content Publishing API and is in closed beta with Facebook Marketing Partners and Instagram Partners only. We are not accepting new applicants at this time.
	 * </p>
	 *
	 * <p>
	 * Requires App Review.
	 * </p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Managing organic content creation process for Instagram (i.e. post photos, videos to main feed) on behalf of a business</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Using the API for promotional purposes</li>
	 * <li>Any actions that do not comply with Instagram's community standards</li>
	 * <li>Using the API to publish static, animated, or looping images</li>
	 * </ul>
	 */
	INSTAGRAM_CONTENT_PUBLISH("instagram_content_publish"),

	/**
	 * <p>
	 * Grants your app permission to read Instagram Accounts users of your app manage.
	 * </p>
	 *
	 * <p>
	 * Requires App Review.
	 * </p>
	 *
	 * <p>
	 * Common Usage:
	 * </p>
	 * <ul>
	 * <li>Read, update, and delete comments of Instagram Business Accounts.</li>
	 * <li>Read media objects, such as stories, of Instagram Business Accounts.</li>
	 * </ul>
	 */
	INSTAGRAM_MANAGE_COMMENTS("instagram_manage_comments"),

	/**
	 * <p>
	 * Grants your app permission to read insights of Instagram Accounts users of your app manage.
	 * </p>
	 *
	 * <p>
	 * Requires App Review.
	 * </p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Get metadata of an Instagram Business Account.</li>
	 * <li>Get data insights of an Instagram Business Account.</li>
	 * <li>Get story insights of an Instagram Business Account.</li>
	 * </ul>
	 */
	INSTAGRAM_MANAGE_INSIGHTS("instagram_manage_insights");

	private String name;

	/**
	 * Default private constructor used to assign the official Facebook name to each permission.
	 *
	 * @param permissionName
	 *            Facebook's official name for the permission.
	 */
	private InstagramPermission(final String permissionName) {
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
