package com.techleads.com.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techleads.com.model.StockPrice;

public interface StockPriceRespository extends JpaRepository<StockPrice, Serializable> {
	
	public Optional<StockPrice> findByName(String name);

}
