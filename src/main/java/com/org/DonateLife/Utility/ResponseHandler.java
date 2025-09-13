package com.org.DonateLife.Utility;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	public static ResponseEntity<?> withMessageAndData(String message, Object data, HttpStatusCode status) {

		GenericResponse gn = new GenericResponse();
		gn.setMessage(message);
		gn.setData(data);
		gn.setStatus(status.value());
		return gn.create();
	}

	public static ResponseEntity<?> withMessage(String message, HttpStatusCode status) {

		GenericResponse gn = new GenericResponse();
		gn.setMessage(message);
		gn.setStatus(status.value());
		return gn.onlyMessage();
	}
}
