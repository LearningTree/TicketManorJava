package com.ticketmanor.model.jackson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


public class MyLocalDateTimeSerializer extends JsonSerializer<LocalDateTime>{

	protected static final DateTimeFormatter DATE_FORMATTER = 
	       DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");

	@Override
	public void serialize(LocalDateTime data, JsonGenerator gen,
			SerializerProvider provider) 
		throws IOException, JsonProcessingException {
		
		gen.writeString(DATE_FORMATTER.format(data));
	}
}
