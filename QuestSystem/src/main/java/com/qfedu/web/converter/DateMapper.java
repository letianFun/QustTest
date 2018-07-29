package com.qfedu.web.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

public class DateMapper extends ObjectMapper{

	public DateMapper() {
		setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"));
	}
}
