package com.example.UrlHashing.dto;

public class SaveUrlRequest {
	
	private String url;
	
	public SaveUrlRequest(){
		
	}
	
	public SaveUrlRequest(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
}
