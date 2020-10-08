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
 * Utility class listing all possible fields related to a User fetched from the Facebook Graph API,
 * according to <a href="https://developers.facebook.com/docs/graph-api/reference/user">the official
 * documentation</a>.
 *
 * @author Paul Podgorsek
 */
public enum UserField implements FacebookField {

	/**
	 * The ID of this person's user account. This ID is unique to each app and cannot be used across
	 * different apps. Our upgrade guide provides more information about app-specific IDs.
	 */
	ID("id"),

	/**
	 * The User's address.
	 */
	ADDRESS("address"),

	/**
	 * Notes added by viewing page on this User.
	 */
	ADMIN_NOTES("admin_notes"),

	/**
	 * The age segment for this person expressed as a minimum and maximum age. For example, more
	 * than 18, less than 21.
	 */
	AGE_RANGE("age_range"),

	/**
	 * The authentication method a Workplace User has configured for their account. It can be either
	 * "password" or "sso".
	 */
	AUTH_METHOD("auth_method"),

	/**
	 * The person's birthday. This is a fixed format string, like MM/DD/YYYY. However, people can
	 * control who can see the year they were born separately from the month and day so this string
	 * can be only the year (YYYY) or the month + day (MM/DD)
	 */
	BIRTHDAY("birthday"),

	/**
	 * Can the person review brand polls.
	 */
	CAN_REVIEW_MEASUREMENT_REQUEST("can_review_measurement_request"),

	/**
	 * The User's primary email address listed on their profile. This field will not be returned if
	 * no valid email address is available.
	 */
	EMAIL("email"),

	/**
	 * Athletes the User likes.
	 */
	FAVORITE_ATHLETES("favorite_athletes"),

	/**
	 * Sports teams the User likes.
	 */
	FAVORITE_TEAMS("favorite_teams"),

	/**
	 * The person's first name.
	 */
	FIRST_NAME("first_name"),

	/**
	 * The gender selected by this person, male or female. If the gender is set to a custom value,
	 * this value will be based off of the preferred pronoun; it will be omitted if the preferred
	 * pronoun is neutral.
	 */
	GENDER("gender"),

	/**
	 * The person's hometown
	 */
	HOMETOWN("hometown"),

	/**
	 * The person's inspirational people.
	 */
	INSPIRATIONAL_PEOPLE("inspirational_people"),

	/**
	 * Install type.
	 */
	INSTALL_TYPE("install_type"),

	/**
	 * Is the app making the request installed.
	 */
	INSTALLED("installed"),

	/**
	 * If the user has used FAME deeplinking.
	 */
	IS_FAME_DEEPLINKING_USER("is_famedeeplinkinguser"),

	/**
	 * If the current user is a guest user. Should always return false.
	 */
	IS_GUEST_USER("is_guest_user"),

	/**
	 * Is this a shared login (e.g. a gray user).
	 */
	IS_SHARED_LOGIN("is_shared_login"),

	/**
	 * Facebook Pages representing the languages this person knows.
	 */
	LANGUAGES("languages"),

	/**
	 * The person's last name.
	 */
	LAST_NAME("last_name"),

	/**
	 * A link to the person's Timeline. The link will only resolve if the person clicking the link
	 * is logged into Facebook and is a friend of the person whose profile is being viewed.
	 */
	LINK("link"),

	/**
	 * The person's current location as entered by them on their profile. This field requires the
	 * user_location permission.
	 */
	LOCATION("location"),

	/**
	 * What the person is interested in meeting for.
	 */
	MEETING_FOR("meeting_for"),

	/**
	 * The person's middle name.
	 */
	MIDDLE_NAME("middle_name"),

	/**
	 * The person's full name.
	 */
	NAME("name"),

	/**
	 * The person's name formatted to correctly handle Chinese, Japanese, or Korean ordering.
	 */
	NAME_FORMAT("name_format"),

	/**
	 * The person's payment pricepoints.
	 */
	PAYMENT_PRICEPOINTS("payment_pricepoints"),

	/**
	 * The profile picture URL of the Messenger user. The URL will expire.
	 */
	PROFILE_PIC("profile_pic"),

	/**
	 * The person's PGP public key.
	 */
	PUBLIC_KEY("public_key"),

	/**
	 * The person's favorite quotes.
	 */
	QUOTES("quotes"),

	/**
	 * Security settings.
	 */
	SECURITY_SETTINGS("security_settings"),

	/**
	 * The time that the shared login needs to be upgraded to Business Manager by.
	 */
	SHARED_LOGIN_UPGRADE_REQUIRED_BY("shared_login_upgrade_required_by"),

	/**
	 * Shortened, locale-aware name for the person.
	 */
	SHORT_NAME("short_name"),

	/**
	 * The person's significant other.
	 */
	SIGNIFICANT_OTHER("significant_other"),

	/**
	 * Sports played by the person.
	 */
	SPORTS("sports"),

	/**
	 * Whether the user can add a Donate Button to their Live Videos.
	 */
	SUPPORTS_DONATE_BUTTON_IN_LIVE_VIDEO("supports_donate_button_in_live_video"),

	/**
	 * Platform test group.
	 */
	TEST_GROUP("test_group"),

	/**
	 * A token that is the same across a business's apps. Access to this token requires that the
	 * person be logged into your app or have a role on your app. This token will change if the
	 * business owning the app changes.
	 */
	TOKEN_FOR_BUSINESS("token_for_business"),

	/**
	 * Video upload limits.
	 */
	VIDEO_UPLOAD_LIMITS("video_upload_limits"),

	/**
	 * Can the viewer send a gift to this person?
	 */
	VIEWER_CAN_SEND_GIFT("viewer_can_send_gift");

	private String name;

	/**
	 * Default private constructor used to assign the official Facebook name to each field.
	 *
	 * @param fieldName
	 *            Facebook's official name for the field.
	 */
	private UserField(final String fieldName) {
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
