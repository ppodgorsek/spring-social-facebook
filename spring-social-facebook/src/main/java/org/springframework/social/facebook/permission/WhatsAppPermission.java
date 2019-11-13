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
 * Permissions for the WhatsApp Platform.
 *
 * @author Paul Podgorsek
 * @see <a href="https://developers.facebook.com/docs/facebook-login/permissions">Facebook Developers: Login permissions</a>
 */
public enum WhatsAppPermission implements FacebookPermission {

	/**
	 * <p>
	 * Provides the ability to read and/or manage WhatsApp business assets you own or have been granted access to by other businesses through this permission.
	 * These business assets include WhatsApp business accounts, phone numbers, and message templates.
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
	 * <li>Display WhatsApp Business Account analytics in your customer portal.</li>
	 * <li>Manage message templates for WhatsApp Business Accounts.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Share data between businesses that you manage.</li>
	 * <li>Sell data.</li>
	 * <li>Transfer customer insights or data to third-parties other than the business owner.</li>
	 * </ul>
	 */
	WHATSAPP_BUSINESS_MANAGEMENT("whatsapp_business_management");

	private String name;

	/**
	 * Default private constructor used to assign the official Facebook name to each permission.
	 *
	 * @param permissionName
	 *            Facebook's official name for the permission.
	 */
	private WhatsAppPermission(final String permissionName) {
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
