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
package org.springframework.social.facebook.api.impl.json;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.social.facebook.api.AchievementType.Image;
import org.springframework.social.facebook.api.ApplicationReference;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class AchievementTypeMixin extends FacebookObjectMixin {

	@JsonCreator
	AchievementTypeMixin(@JsonProperty("id") final String id,
			@JsonProperty("type") final String type, @JsonProperty("title") final String title,
			@JsonProperty("url") final String url,
			@JsonProperty("description") final String description,
			@JsonProperty("image") final List<Image> image,
			@JsonProperty("data") @JsonDeserialize(using = AchievementPointsDeserializer.class) final int points,
			@JsonProperty("created_time") final Date createdTime,
			@JsonProperty("updated_time") final Date updatedTime,
			@JsonProperty("application") final ApplicationReference application,
			@JsonProperty("is_scraped") final boolean isScraped) {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static abstract class ImageMixin extends FacebookObjectMixin {

		@JsonCreator
		ImageMixin(@JsonProperty("url") final String url, @JsonProperty("width") final int width,
				@JsonProperty("height") final int height) {
		}
	}

	private static class AchievementPointsDeserializer extends JsonDeserializer<Integer> {

		@SuppressWarnings("unchecked")
		@Override
		public Integer deserialize(final JsonParser jp, final DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			Map<String, Object> map = jp.readValueAs(Map.class);
			return map.containsKey("points") ? Integer.valueOf(String.valueOf(map.get("points")))
					: 0;
		}

		@Override
		public Integer getNullValue(final DeserializationContext ctxt) throws JsonMappingException {
			return 0;
		}
	}

}
