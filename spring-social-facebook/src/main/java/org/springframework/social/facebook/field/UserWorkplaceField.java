/*
 * Copyright 2020 the original author or authors.
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
package org.springframework.social.facebook.field;

/**
 * Utility class listing all possible Workplace fields related to a User fetched from the Facebook
 * Graph API, according to
 * <a href="https://developers.facebook.com/docs/graph-api/reference/user">the official
 * documentation</a>.
 *
 * @author Paul Podgorsek
 */
public enum UserWorkplaceField implements FacebookField {

	/**
	 * The access code for a Workplace email-less account.
	 */
	ACCESS_CODE("access_code"),

	/**
	 * The timestamp when the Workplace account was claimed.
	 */
	ACCOUNT_CLAIM_TIME("account_claim_time"),

	/**
	 * The timestamp when the Workplace account was invited.
	 */
	ACCOUNT_INVITE_TIME("account_invite_time"),

	/**
	 * Whether this Workplace account is currently active.
	 */
	ACTIVE("active"),

	/**
	 * Whether this Workplace user account can be deleted.
	 */
	CAN_DELETE("can_delete"),

	/**
	 * Url for claiming the workplace user account.
	 */
	CLAIM_LINK("claim_link"),

	/**
	 * The Workplace community this user belongs to.
	 */
	COMMUNITY("community"),

	/**
	 * Cost center name of a Workplace user.
	 */
	COST_CENTER("cost_center"),

	/**
	 * Department name of a Workplace user.
	 */
	DEPARTMENT("department"),

	/**
	 * Division name of a Workplace user.
	 */
	DIVISION("division"),

	/**
	 * The User's employee number, as set by the company via SCIM API.
	 */
	EMPLOYEE_NUMBER("employee_number"),

	/**
	 * A company specified unique identifier of employee users within a company.
	 */
	EXTERNAL_ID("external_id"),

	/**
	 * Information about the frontline functionality related to this user.
	 */
	FRONTLINE("frontline"),

	/**
	 * The access token you can use to act as the person.
	 */
	IMPERSONATE_TOKEN("impersonate_token"),

	/**
	 * Organization that the Workplace user belongs to.
	 */
	ORGANIZATION("organization"),

	/**
	 * The primary address of a Workplace user.
	 */
	PRIMARY_ADDRESS("primary_address"),

	/**
	 * The primary phone number of a Workplace user.
	 */
	PRIMARY_PHONE("primary_phone"),

	/**
	 * The date this Workplace user was terminated.
	 */
	TERM_DATE("term_date"),

	/**
	 * Job title of a Workplace user.
	 */
	TITLE("title"),

	/**
	 * Locale of a Workplace user.
	 */
	WORK_LOCALE("work_locale");

	private String name;

	/**
	 * Default private constructor used to assign the official Facebook name to each field.
	 *
	 * @param fieldName
	 *            Facebook's official name for the field.
	 */
	private UserWorkplaceField(final String fieldName) {
		name = fieldName;
	}

	/**
	 * @return The official name for the permission.
	 */
	@Override
	public String getName() {
		return name;
	}

}
