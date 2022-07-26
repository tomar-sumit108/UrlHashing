package com.example.UrlHashing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shorturls")
public class UrlModel {
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "largeUrl", nullable = false)
	private String largeUrl;
	
	public UrlModel() {
		
	}
	
	public UrlModel(String largeUrl) {
		this.largeUrl = largeUrl;
	}
	
	public int getId() {
		return id;
	}
	
	public void setLargeUrl(String url) {
		this.largeUrl = url;
	}
	
	public String getLargeUrl() {
		return largeUrl;
	}
	
	
}
