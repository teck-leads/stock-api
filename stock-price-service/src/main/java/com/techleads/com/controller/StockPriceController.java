package com.techleads.com.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.com.model.StockPrice;
import com.techleads.com.service.StockPriceService;

@RestController
public class StockPriceController {
	
	private StockPriceService priceRepoService;
	
	
	public StockPriceController(StockPriceService priceRepoService) {
		this.priceRepoService = priceRepoService;
	}



	@GetMapping(value = {"/stocks/name/{name}"})
	public ResponseEntity<String> stockPriceByName(@PathVariable("name") String name){
		String findByName = priceRepoService.findByName(name);
		return new ResponseEntity<>(findByName, HttpStatus.OK);
	}
	
	
	@PostMapping(value = {"/stocks"})
	public ResponseEntity<StockPrice> saveStockPrice(@RequestBody StockPrice stockPrice){
		StockPrice saveStockPrice = priceRepoService.saveStockPrice(stockPrice);
		return new ResponseEntity<>(saveStockPrice, HttpStatus.CREATED);
	}
	
	@GetMapping(value = {"/stocks/{id}"})
	public ResponseEntity<StockPrice> stockPriceByName(@PathVariable("id") Integer id){
		StockPrice stockPrice = priceRepoService.findStockPriceById(id);
		return new ResponseEntity<>(stockPrice, HttpStatus.OK);
	}
	
	@GetMapping(value = {"/stocks"})
	public ResponseEntity<List<StockPrice>> findAllStockPrice(){
		List<StockPrice> findAllStockPrices = priceRepoService.findAllStockPrices();
		
		return new ResponseEntity<>(findAllStockPrices, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = {"/stocks/{id}"})
	public ResponseEntity<List<StockPrice>> deleteStockPriceById(@PathVariable("id") Integer id){
		List<StockPrice> findAllStockPrices = priceRepoService.deleteStockPriceById(id);
		return new ResponseEntity<>(findAllStockPrices, HttpStatus.OK);
	}

}
