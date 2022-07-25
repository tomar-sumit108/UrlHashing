package com.example.UrlHashing.service;


import com.example.UrlHashing.dto.GetUrlRequest;
import com.example.UrlHashing.dto.GetUrlResponse;
import com.example.UrlHashing.dto.SaveUrlRequest;
import com.example.UrlHashing.dto.SaveUrlResponse;

public interface UrlService {
	
	public SaveUrlResponse saveUrl(SaveUrlRequest saveUrlRequest);

	public GetUrlResponse getLargeUrl(GetUrlRequest request);
}
