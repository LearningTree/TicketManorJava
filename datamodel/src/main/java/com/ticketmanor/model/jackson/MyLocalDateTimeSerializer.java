package com.ticketmanor.model.jackson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class MyLocalDateTimeSerializer extends JsonSerializer<LocalDateTime>{

	protected static final DateTimeFormatter DATE_FORMATTER = 
	       DateTimeFormatter.ofPattern("dd-MM-yyyyThh:mm");

	@Override
	public void serialize(LocalDateTime data, JsonGenerator gen,
			SerializerProvider provider) 
		throws IOException, JsonProcessingException {
		
		gen.writeString(DATE_FORMATTER.format(data));
	}
}
