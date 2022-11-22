package com.uisrael.mineria.mineriadatos.adapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

	@Override
	public LocalDateTime unmarshal(String dateString) throws Exception {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		return LocalDateTime.parse(dateString, dateFormat);
	}

	@Override
	public String marshal(LocalDateTime localDate) throws Exception {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		return localDate.format(dateFormat);
	}

}