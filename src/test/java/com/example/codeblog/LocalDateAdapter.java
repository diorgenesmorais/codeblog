package com.example.codeblog;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Este adapter auxiliar na configuração na serialização da data.
 * 
 * @author Diorgenes Morais
 *
 */
public class LocalDateAdapter implements JsonSerializer<LocalDate> {

	@Override
	public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
	}

}
