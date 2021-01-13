package com.techleads.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.techleads.app.model.StockPrice;
@FeignClient(name = "STOCK-PRICE-API")
public interface StockPriceClient {

	@GetMapping(value = {"/stocks/name/{name}"})
	public ResponseEntity<String> stockPriceByName(@PathVariable("name") String name);
	
	@GetMapping(value = {"/stocks/nme/{name}"})
	public ResponseEntity<StockPrice> findStockPriceByName(@PathVariable("name") String name);
}
