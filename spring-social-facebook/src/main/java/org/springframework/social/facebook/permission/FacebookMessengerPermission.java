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
 * Permissions for the Messenger Platform.
 *
 * @author Paul Podgorsek
 * @see <a href="https://developers.facebook.com/docs/facebook-login/permissions">Facebook Developers: Login permissions</a>
 */
public enum FacebookMessengerPermission implements FacebookPermission {

	/**
	 * <p>
	 * Grants an app permission to manage and access Page conversations in Messenger.
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
	 * <li>Creating user-initiated interactive experiences</li>
	 * <li>Confirming bookings, purchases, orders, etc.</li>
	 * <li>Sending customer support messages</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Up-selling or cross-selling products or services</li>
	 * <li>Sending brand advertising, newsletters, announcements or spam</li>
	 * <li>Messaging people without their consent</li>
	 * </ul>
	 */
	PAGES_MESSAGING("pages_messaging");

	private String name;

	/**
	 * Default private constructor used to assign the official Facebook name to each permission.
	 *
	 * @param permissionName
	 *            Facebook's official name for the permission.
	 */
	private FacebookMessengerPermission(final String permissionName) {
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
