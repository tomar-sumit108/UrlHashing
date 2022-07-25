package com.example.UrlHashing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "shorturls")
@Data
public class UrlModel {
	
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "largeUrl");
	private String largeUrl;
	
	@Column(name = "shortUrl")
	private String shortUrl;
	
	
	
}
