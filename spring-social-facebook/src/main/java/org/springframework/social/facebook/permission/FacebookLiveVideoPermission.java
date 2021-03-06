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
 * Permissions for the Live Video API.
 *
 * @author Paul Podgorsek
 * @see <a href="https://developers.facebook.com/docs/facebook-login/permissions">Facebook Developers: Login permissions</a>
 */
public enum FacebookLiveVideoPermission implements FacebookPermission {

	/**
	 * <p>
	 * Grants an app permission to publish live videos to the app User's timeline.
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
	 * <li>Live video streaming to a User's timeline.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Streaming of advertisements, or any content which does not meet Facebook's content policies.</li>
	 * </ul>
	 */
	PUBLISH_VIDEO("publish_video");

	private String name;

	/**
	 * Default private constructor used to assign the official Facebook name to each permission.
	 *
	 * @param permissionName
	 *            Facebook's official name for the permission.
	 */
	private FacebookLiveVideoPermission(final String permissionName) {
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
