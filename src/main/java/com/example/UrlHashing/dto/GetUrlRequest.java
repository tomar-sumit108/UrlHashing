package com.example.UrlHashing.dto;

public class GetUrlRequest {
	private String url;
	
	public GetUrlRequest() {
		
	}
	
	public GetUrlRequest(String url){
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
}
