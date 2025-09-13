package com.org.DonateLife.Utility;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class GenericResponse {

	private String message;
	private Object data;
	private int status;

	public ResponseEntity<?> create() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("message", message);
		map.put("data", data);
		map.put("status", status);
		return new ResponseEntity(map, HttpStatus.valueOf(status));
	}

	public ResponseEntity<?> onlyMessage() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("message", message);
		map.put("status", status);
		return new ResponseEntity(map, HttpStatus.valueOf(status));
	}
}
