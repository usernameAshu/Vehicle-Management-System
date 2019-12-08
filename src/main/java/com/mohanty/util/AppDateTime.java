package com.mohanty.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class AppDateTime {

	public String getCurrentDate() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-YYYY HH:mm:ss");
		String pattern = sdf.format(new Date());
		return pattern;

	}
}
