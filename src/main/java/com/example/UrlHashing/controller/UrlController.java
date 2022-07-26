package com.example.UrlHashing.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UrlHashing.dto.GetUrlRequest;
import com.example.UrlHashing.dto.GetUrlResponse;
import com.example.UrlHashing.dto.SaveUrlRequest;
import com.example.UrlHashing.dto.SaveUrlResponse;
import com.example.UrlHashing.service.UrlService;

@RestController
@RequestMapping(UrlController.API_ENDPOINT)
public class UrlController {
	public static final String API_ENDPOINT = "/v1";
	public static final String SAVE_URL_API = "/save";
	public static final String GET_URL_API = "/{shortUrl}";
	
	@Autowired
	private UrlService urlService;
	
	@PostMapping(SAVE_URL_API)
	public ResponseEntity<Map<String, String>> saveUrl(@RequestBody SaveUrlRequest saveUrlRequest){
		Map<String, String> response = new HashMap<>();
		
		try {
			SaveUrlResponse saveUrlResponse = urlService.saveUrl(saveUrlRequest);
			response.put("message", saveUrlResponse.getUrl());
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
	}
	
	@GetMapping(GET_URL_API)
	public ResponseEntity getLargeUrl(@PathVariable String shortUrl) {
		GetUrlRequest request = new GetUrlRequest(shortUrl);
		
		try {
			GetUrlResponse getUrlResponse = urlService.getLargeUrl(request);
			return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).location(new URL(getUrlResponse.getUrl()).toURI()).build();
			
		} catch(NoSuchElementException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
			
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
		
		
	}
}
