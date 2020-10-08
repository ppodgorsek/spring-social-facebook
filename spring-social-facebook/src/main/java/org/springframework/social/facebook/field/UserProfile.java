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

import lombok.experimental.UtilityClass;

/**
 * Utility class containing constants related to user profiles.
 *
 * @author Paul Podgorsek
 */
@UtilityClass
public class UserProfile {

	public static final String[] CORE_PROFILE_FIELDS = { UserField.ID.getName(),
			UserField.EMAIL.getName(), UserField.FIRST_NAME.getName(),
			UserField.LAST_NAME.getName(), UserField.MIDDLE_NAME.getName(),
			UserField.NAME.getName(), UserField.NAME_FORMAT.getName(),
			UserField.SHORT_NAME.getName() };

	/**
	 * The ID used to fetch the profile of the current user, i.e. the user who granted the access.
	 */
	public static final String CURRENT_USER = "me";

}
