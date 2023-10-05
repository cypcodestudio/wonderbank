package com.lekodevs.wonderbank.entity.param;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EntityResponse {
	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("TimeStamp", new Date());
		map.put("Message", message);
		map.put("Status", status.value());
		map.put("Data", responseObj);

		return new ResponseEntity<Object>(map, status);
	}

}
