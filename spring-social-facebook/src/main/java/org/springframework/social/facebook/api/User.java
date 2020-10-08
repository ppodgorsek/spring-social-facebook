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
package org.springframework.social.facebook.api;

import java.io.Serializable;
import java.util.List;

/**
 * Model class containing a Facebook user's profile information.
 *
 * @author Craig Walls
 */
public class User extends FacebookObject implements Serializable {

	private static final long serialVersionUID = 1068752585809858733L;

	private String id;

	private Location address;

	private final AgeRange ageRange = AgeRange.UNKNOWN;

	private String birthday;

	private CoverPhoto cover;

	private String email;

	private List<Reference> favoriteAthletes;

	private List<Reference> favoriteTeams;

	private String firstName;

	private String gender;

	private Reference hometown;

	private List<Reference> inspirationalPeople;

	private boolean installed;

	private String installType;

	private List<Reference> languages;

	private String lastName;

	private String link;

	private Reference location;

	private String middleName;

	private List<String> meetingFor;

	private String name;

	private String nameFormat;

	private PaymentPricePoints paymentPricePoints;

	private String quotes;

	private Reference significantOther;

	private List<Experience> sports;

	private int testGroup;

	private boolean viewerCanSendGift;

	private VideoUploadLimits videoUploadLimits;

	User() {
	}

	public User(final String id, final String name, final String firstName, final String lastName,
			final String gender) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	/**
	 * The user's Facebook ID
	 *
	 * @return The user's Facebook ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * The user's address
	 *
	 * @return the user's address.
	 * @deprecated Facebook no longer supports the address field in user profiles. Will return null
	 *             for newer versions of the Graph API.
	 */
	@Deprecated
	public Location getAddress() {
		return address;
	}

	/**
	 * The user's full name
	 *
	 * @return The user's full name
	 */
	public String getName() {
		return name;
	}

	/**
	 * The user's first name
	 *
	 * @return The user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	public List<String> getMeetingFor() {
		return meetingFor;
	}

	/**
	 * The user's middle name
	 *
	 * @return The user's middle name
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * The user's last name
	 *
	 * @return The user's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the name format used to correctly handle Chinese, Japanese, Korean ordering
	 */
	public String getNameFormat() {
		return nameFormat;
	}

	/**
	 * The user's gender
	 *
	 * @return the user's gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * The user's email address. Available only with "email" permission.
	 *
	 * @return The user's email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * A link to the user's profile on Facebook. Available only if requested by an authenticated
	 * user.
	 *
	 * @return the user's profile link or null if requested anonymously
	 */
	public String getLink() {
		return link;
	}

	/**
	 * The user's birthday. Available only with "user_birthday" permission for the authentication
	 * user permission for the user's friends.
	 *
	 * @return the user's birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * The user's location. Available only with "user_location" permission.
	 *
	 * @return a {@link Reference} to the user's location, if available
	 */
	public Reference getLocation() {
		return location;
	}

	/**
	 * The user's hometown. Available only with "user_hometown" permission.
	 *
	 * @return a {@link Reference} to the user's hometown, if available
	 */
	public Reference getHometown() {
		return hometown;
	}

	/**
	 * A list of references to people the user is inspired by.
	 *
	 * @return a list of {@link Reference} to people the user is inspired by, if available.
	 */
	public List<Reference> getInspirationalPeople() {
		return inspirationalPeople;
	}

	/**
	 * A list of references to languages the user claims to know.
	 *
	 * @return a list of {@link Reference} to languages the user knows, if available.
	 */
	public List<Reference> getLanguages() {
		return languages;
	}

	/**
	 * A list of references to the user's favorite sports teams.
	 *
	 * @return a list of {@link Reference}s to sports teams the user is a fan of, if available.
	 */
	public List<Reference> getFavoriteTeams() {
		return favoriteTeams;
	}

	/**
	 * A list of references to the user's favorite athletes.
	 *
	 * @return a list of {@link Reference}s to athletes the user is a fan of, if available.
	 */
	public List<Reference> getFavoriteAtheletes() {
		return favoriteAthletes;
	}

	/**
	 * @return a {@link PaymentPricePoints} object
	 */
	public PaymentPricePoints getPaymentPricePoints() {
		return paymentPricePoints;
	}

	/**
	 * The user's quotations. Available only with "user_about_me" permission.
	 *
	 * @return the user's quotations, if available.
	 */
	public String getQuotes() {
		return quotes;
	}

	/**
	 * The user's significant other. Available only for certain relationship statuses and with
	 * "user_relationship_details" permission.
	 *
	 * @return a {@link Reference} to the user's significant other, if available.
	 */
	public Reference getSignificantOther() {
		return significantOther;
	}

	public int getTestGroup() {
		return testGroup;
	}

	public boolean viewerCanSendGift() {
		return viewerCanSendGift;
	}

	/**
	 * The user's age range.
	 *
	 * @return an {@link AgeRange} for the user. Will be {@link AgeRange#UNKNOWN} if the age_range
	 *         isn't available or if the range given does match the known ranges.
	 */
	public AgeRange getAgeRange() {
		return ageRange;
	}

	/**
	 * @return true if the user has the calling application installed
	 */
	public boolean isInstalled() {
		return installed;
	}

	public String getInstallType() {
		return installType;
	}

	/**
	 * @return the user's cover photo
	 */
	public CoverPhoto getCover() {
		return cover;
	}

	/**
	 * @return limits on the size and time length of videos the user can upload.
	 */
	public VideoUploadLimits getVideoUploadLimits() {
		return videoUploadLimits;
	}

	/**
	 * @return list of sports experiences the user has participated in.
	 */
	public List<Experience> getSports() {
		return sports;
	}

}
