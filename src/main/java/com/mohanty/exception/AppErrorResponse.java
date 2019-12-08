package com.mohanty.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AppErrorResponse {
	
	private int status;
	private String message;
	private String timestamp;

}
