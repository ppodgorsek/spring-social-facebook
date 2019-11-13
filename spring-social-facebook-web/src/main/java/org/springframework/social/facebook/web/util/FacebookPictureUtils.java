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
package org.springframework.social.facebook.web.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Utility class to ease the display of user pictures.
 *
 * @author Paul Podgorsek
 */
public class FacebookPictureUtils {

	private final static Log LOGGER = LogFactory.getLog(FacebookPictureUtils.class);

	private static final String BASE_64_URL_PREFIX="data:image/jpeg;base64,";
	
	/**
	 * Default private constructor to avoid instantiating this class.
	 */
	private FacebookPictureUtils() {
		super();
	}

	/**
	 * Generates a base-64 URL for an image.
	 *
	 * @param url
	 *            The image's URL.
	 * @return The base-64 URL for the image's contents.
	 */
	public static String getBase64UrlForImage(final String url) {

		try {
			URL imageUrl = new URL(url);
			URLConnection urlConnection = imageUrl.openConnection();
			BufferedInputStream inputStream = new BufferedInputStream(
					urlConnection.getInputStream());
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int read = 0;

			while ((read = inputStream.read(buffer, 0, buffer.length)) != -1) {
				outputStream.write(buffer, 0, read);
			}

			outputStream.flush();

			return BASE_64_URL_PREFIX + Base64.getEncoder().encodeToString(outputStream.toByteArray());
		}
		catch (IOException e) {
			LOGGER.error("Impossible to convert the Facebook image to a Base64 URL", e);
		}

		return "#";
	}

}
