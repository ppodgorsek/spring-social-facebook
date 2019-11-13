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
 * <p>
 * Permissions for Facebook User Data.
 * </p>
 *
 * <p>
 * The Default Public Profile Fields do not require App Review and grant your app access to the default fields of the User object that are a subset of a person's public profile:
 * </p>
 * <ul>
 * <li>id</li>
 * <li>first_name</li>
 * <li>last_name</li>
 * <li>middle_name</li>
 * <li>name</li>
 * <li>name_format</li>
 * <li>picture</li>
 * <li>short_name</li>
 * </ul>
 *
 * @author Paul Podgorsek
 * @see <a href="https://developers.facebook.com/docs/facebook-login/permissions">Facebook Developers: Login permissions</a>
 */
public enum FacebookUserPermission implements FacebookPermission {

	/**
	 * <p>
	 * Grants your app permission to access a person's primary email address.
	 * <p>
	 *
	 * <p>Does not require App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Allow a person to use their Facebook email address to login to your app.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Spamming users. Your use of email must comply with both Facebook policies and the CAN-SPAM Act.</li>
	 * </ul>
	 */
	EMAIL("email"),

	/**
	 * <p>
	 * Grants an app permission to publicly available group member information.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Allow apps to get content posted in their group with user details</li>
	 * <li>Help admins get aggregated insights about activity happening in their group</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Behavioral retargeting</li>
	 * <li>Building or augmenting user profiles</li>
	 * <li>Mapping user engagement across Groups</li>
	 * <li>Sharing data between multiple businesses that you manage</li>
	 * <li>Transfering or selling data obtained through third parties</li>
	 * </ul>
	 */
	GROUPS_ACCESS_MEMBER_INFO("groups_access_member_info"),

	/**
	 * <p>
	 * Grants an app permission to post content into a group on behalf of a User who has granted the app this permission.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Allow people to publish content from your app to their Facebook group.</li>
	 * <li>Help people manage the content published to their group.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Automatically publish content without the person being aware or having control over said content.</li>
	 * </ul>
	 */
	PUBLISH_TO_GROUPS("publish_to_groups"),

	/**
	 * <p>
	 * Grants an app permission to access a person's age range.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Your app includes content that is legally required to be age-gated, for example, gambling, gaming, or alcohol.</li>
	 * <li>Your app includes content that is not suitable for the general Facebook audience, such as dating, mature, graphic, or violent content.</li>
	 * <li>Your application includes content that is directed at kids or teens.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>No visible impact to the User experience based on a person's age range.</li>
	 * </ul>
	 */
	USER_AGE_RANGE("user_age_range"),

	/**
	 * <p>
	 * Grants an app permission to access a person's birthday.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Provide age relevant content to people based on their date of birth.</li>
	 * <li>Provide age relevant content for anything where the age range is not sufficient.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Determine whether a person says they are under 18, over 18, or over 21. Please use the age_range instead.</li>
	 * </ul>
	 */
	USER_BIRTHDAY("user_birthday"),

	/**
	 * <p>
	 * Grants an app permissions to read-only access to the Events a person is a host of or has RSVPed to.
	 * This permission is restricted to a limited set of partners and usage requires prior approval by Facebook.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Reduce friction in the visibility of calendar and event information, e.g., device apps, planner apps, concert apps, etc.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Create events.</li>
	 * <li>RSVP to events using your app.</li>
	 * </ul>
	 */
	USER_EVENTS("user_events"),

	/**
	 * <p>
	 * Grants an app permission to access a list of friends that also use said app.
	 * This permission is restricted to a limited set of partners and usage requires prior approval by Facebook.
	 * <p>
	 *
	 * <p>
	 * In order for a person to show up in another's friend list, both people must have shared their list of friends with the app and not disabled this permission during login.
	 * </p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Use the list of friends to create a social experience in an app.</li>
	 * </ul>
	 */
	USER_FRIENDS("user_friends"),

	/**
	 * <p>
	 * Grants an app permission to access a person's gender.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Correctly render pronouns in certain languages, for example, when a bot messages a person.</li>
	 * <li>Display a person's gender to other people, for example, for dating.</li>
	 * <li>Personalized a User's experience based on gender, for example, in shopping or fashion.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>No visible impact to the user experience based on gender.</li>
	 * <li>Fill out a registration form or User profile without using the information to enhance the User experience.</li>
	 * </ul>
	 */
	USER_GENDER("user_gender"),

	/**
	 * <p>
	 * Grants an app permission to access a person's hometown location set in their User Profile.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Common Usage:
	 * </p>
	 * <ul>
	 * <li>Help people connect to others from their hometown.</li>
	 * <li>Personalize a person's experience based on where they lived or grew up.</li>
	 * </ul>
	 */
	USER_HOMETOWN("user_hometown"),

	/**
	 * <p>
	 * Grants an app permission to access the list of all Facebook Pages that a person has liked.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Create a personalized experience by correlating and surfacing content related to a person's interests.</li>
	 * <li>Enable connections with other users based on mutual interests. The user must be informed why the other users are suggested.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Gate access to your app, or some content within your app, based on whether or not someone has liked a page.</li>
	 * </ul>
	 */
	USER_LIKES("user_likes"),

	/**
	 * <p>
	 * Grants your app permission to access the Facebook Profile URL of User of your app.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Provide a way for someone who uses your app to visit the Facebook Profile of someone in their friends list who also uses your app, for example, for local listings.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Attempt to programmatically determine someone's Facebook username or canonical User ID.</li>
	 * </ul>
	 */
	USER_LINK("user_link"),

	/**
	 * <p>
	 * Provides access to a person's current city through the location field on the User object. The current city is set by a person on their Profile.
	 * <p>
	 *
	 * <p>
	 * The current city is not necessarily the same as a person's hometown.
	 * </p>
	 *
	 * <p>If your app requests this permission Facebook will have to review how your app uses it.</p>
	 *
	 * <p>
	 * Common Usage:
	 * </p>
	 * <ul>
	 * <li>Personalize a person's experience based on their current city.</li>
	 * <li>Surface content relevant to their city.</li>
	 * <li>Help people connect to others from their city.</li>
	 * </ul>
	 */
	USER_LOCATION("user_location"),

	/**
	 * <p>
	 * Grants an app permission to access the photos a person has uploaded.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Display a person's pictures in a digital photo frame.</li>
	 * <li>Edit photos or create new content based on existing photos (e.g. slideshows and face-in-hole apps).</li>
	 * <li>Help people export their photos for printing. Only offer this service for a person's personal and non-commercial use.</li>
	 * </ul>
	 */
	USER_PHOTOS("user_photos"),

	/**
	 * <p>
	 * Grants an app permission to access the posts a person makes on their timeline.
	 * <p>
	 *
	 * <p>Requires App Review.</p>
	 *
	 * <p>
	 * Allowed Usage:
	 * </p>
	 * <ul>
	 * <li>Provide creative content derived from a user's existing content in timeline posts.</li>
	 * <li>Provide value to the user by visibly analyzing the content of the posts on their Timeline.</li>
	 * </ul>
	 *
	 * <p>
	 * Disallowed Usage:
	 * </p>
	 * <ul>
	 * <li>Non-visible use of this data such as sentiment analysis.</li>
	 * </ul>
	 */
	USER_POSTS("user_posts"),

	/**
	 * <p>
	 * Provides access to the Places a person has been tagged at in photos, videos, statuses and links.
	 * This permission is restricted to a limited set of partners and usage requires prior approval by Facebook.
	 * <p>
	 *
	 * <p>Requesting this permission requires you to submit your app for Login Review.</p>
	 *
	 * <p>
	 * Common Usage:
	 * </p>
	 * <ul>
	 * <li>Provide tailored content based on the places a person has been.</li>
	 * <li>Recommend places to visit based on the places a person has previously been tagged at.</li>
	 * <li>Show someone their checkin history on a map.</li>
	 * </ul>
	 */
	USER_TAGGED_PLACES("user_tagged_places"),

	/**
	 * <p>
	 * Provides access to the videos a person has uploaded or been tagged in.
	 * This permission is restricted to a limited set of partners and usage requires prior approval by Facebook.
	 * <p>
	 *
	 * <p>Requesting this permission requires you to submit your app for Login Review.</p>
	 *
	 * <p>
	 * Common Usage:
	 * </p>
	 * <ul>
	 * <li>Access videos for use videos in a way that visibly enhances the in-app experience: (e.g. editing, collage, portfolio, slideshow apps.)</li>
	 * <li>Display a person's videos on a TV via a set top box, or display their videos on a digital photo frame.</li>
	 * </ul>
	 */
	USER_VIDEOS("user_videos");

	private String name;

	/**
	 * Default private constructor used to assign the official Facebook name to each permission.
	 *
	 * @param permissionName
	 *            Facebook's official name for the permission.
	 */
	private FacebookUserPermission(final String permissionName) {
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
