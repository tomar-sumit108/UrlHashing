package com.example.UrlHashing.dto;

public class SaveUrlResponse {
	private String url;
	
	public SaveUrlResponse(){
		
	}
	
	public SaveUrlResponse(String url){
		this.url = url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	
	
}
