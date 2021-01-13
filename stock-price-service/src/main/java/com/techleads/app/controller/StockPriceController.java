package com.techleads.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.StockPrice;
import com.techleads.app.service.StockPriceService;

@RestController
public class StockPriceController {
	@Value("${server.port}")
	private int port;
	
	private StockPriceService priceRepoService;
	
	
	public StockPriceController(StockPriceService priceRepoService) {
		this.priceRepoService = priceRepoService;
	}



	@GetMapping(value = {"/stocks/name/{name}"})
	public ResponseEntity<String> stockPriceByName(@PathVariable("name") String name){
		String findByName = priceRepoService.findByName(name);
		return new ResponseEntity<>(findByName, HttpStatus.OK);
	}
	
	
	
	

	@GetMapping(value = {"/stocks/nme/{name}"})
	public ResponseEntity<StockPrice> findStockPriceByName(@PathVariable("name") String name){
		StockPrice findStockPriceByName = priceRepoService.findStockPriceByName(name);
		findStockPriceByName.setPortNum("PortNum{}-> "+port);
		return new ResponseEntity<>(findStockPriceByName, HttpStatus.OK);
	}
	
	@PostMapping(value = {"/stocks"})
	public ResponseEntity<StockPrice> saveStockPrice(@RequestBody StockPrice stockPrice){
		StockPrice saveStockPrice = priceRepoService.saveStockPrice(stockPrice);
		saveStockPrice.setPortNum("PortNum{}-> "+port);
		return new ResponseEntity<>(saveStockPrice, HttpStatus.CREATED);
	}
	
	@GetMapping(value = {"/stocks/{id}"})
	public ResponseEntity<StockPrice> stockPriceByName(@PathVariable("id") Integer id){
		StockPrice stockPrice = priceRepoService.findStockPriceById(id);
		stockPrice.setPortNum("PortNum{}-> "+port);
		return new ResponseEntity<>(stockPrice, HttpStatus.OK);
	}
	
	@GetMapping(value = {"/stocks"})
	public ResponseEntity<List<StockPrice>> findAllStockPrice(){
		List<StockPrice> findAllStockPrices = priceRepoService.findAllStockPrices();
		findAllStockPrices.forEach(stock->{stock.setPortNum("PortNum{}-> "+port);});
		return new ResponseEntity<>(findAllStockPrices, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = {"/stocks/{id}"})
	public ResponseEntity<List<StockPrice>> deleteStockPriceById(@PathVariable("id") Integer id){
		List<StockPrice> findAllStockPrices = priceRepoService.deleteStockPriceById(id);
		findAllStockPrices.forEach(stock->{stock.setPortNum("PortNum{}-> "+port);});
		return new ResponseEntity<>(findAllStockPrices, HttpStatus.OK);
	}

}
