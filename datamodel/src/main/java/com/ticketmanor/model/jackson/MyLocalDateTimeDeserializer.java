package com.ticketmanor.model.jackson;

import java.io.IOException;
import java.time.LocalDateTime;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class MyLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime>{

	@Override
	public LocalDateTime deserialize(JsonParser parser,
			DeserializationContext ctx) 
					throws IOException, JsonProcessingException {
		JsonToken currentToken;
		currentToken = parser.getCurrentToken();
		if (currentToken == JsonToken.VALUE_STRING) {
			String dateTimeAsString = parser.getText().trim();
			return LocalDateTime.from(
				MyLocalDateTimeSerializer.DATE_FORMATTER.parse(dateTimeAsString));
		}
		else {
			throw ctx.mappingException("Could not deserialize this mess: " + currentToken);
		}
	}
}
