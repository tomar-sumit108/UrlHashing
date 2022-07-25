package com.example.UrlHashing.dto;

public class GetUrlResponse {
	private String url;
	
	public GetUrlResponse(){
		
	}
	
	public GetUrlResponse(String url){
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
}
