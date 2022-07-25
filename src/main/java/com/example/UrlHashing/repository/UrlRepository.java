package com.example.UrlHashing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UrlHashing.model.UrlModel;

@Repository
public interface UrlRepository extends JpaRepository<UrlModel, Integer> {
	
}
