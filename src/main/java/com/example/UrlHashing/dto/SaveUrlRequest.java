package com.example.UrlHashing.dto;

public class SaveUrlRequest {
	
	private String largeUrl;
	
	public SaveUrlRequest(){
		
	}
	
	public SaveUrlRequest(String largeUrl){
		this.largeUrl = largeUrl;
	}
	
	public String getLargeUrl() {
		return largeUrl;
	}
	
	public void putLargeUrl(String largeUrl) {
		this.largeUrl = largeUrl;
	}

}
