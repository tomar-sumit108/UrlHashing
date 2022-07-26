package com.example.UrlHashing.service;

import java.net.URL;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UrlHashing.dto.GetUrlRequest;
import com.example.UrlHashing.dto.GetUrlResponse;
import com.example.UrlHashing.dto.SaveUrlRequest;
import com.example.UrlHashing.dto.SaveUrlResponse;
import com.example.UrlHashing.model.UrlModel;
import com.example.UrlHashing.repository.UrlRepository;
import com.example.UrlHashing.utils.UrlUtils;

@Service
public class UrlServiceImpl implements UrlService{
	

	@Autowired
	private UrlRepository urlRepository;
	
	@Override
	public SaveUrlResponse saveUrl(SaveUrlRequest saveUrlRequest) throws Exception {
		validateUrl(saveUrlRequest.getUrl());
		UrlModel urlModel = new UrlModel();
		urlModel.setLargeUrl(saveUrlRequest.getUrl());
		urlModel = urlRepository.save(urlModel);
		return new SaveUrlResponse(UrlUtils.encode(urlModel.getId()));
	}

	@Override
	public GetUrlResponse getLargeUrl(GetUrlRequest request) throws NoSuchElementException {
		int id = UrlUtils.decode(request.getUrl());
		String largeUrl = urlRepository.findById(id).get().getLargeUrl();
		return new GetUrlResponse(largeUrl);
	}
	
	private void validateUrl(String url) throws Exception {
		try {
			new URL(url);
		} catch(Exception e) {
			throw new Exception();
		}
	}

}
