package com.techleads.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.StockPrice;
import com.techleads.app.service.StockPriceClient;

@RestController
public class StockCalcController {
	@Autowired
	private StockPriceClient stockPriceClient;
	
//	@GetMapping(value = {"/stocks/{name}/{qty}"})
//	public ResponseEntity<String> findStockPrice(@PathVariable("name") String name, 
//			@PathVariable("qty") Double quantity) {
//		ResponseEntity<String> stockPriceByName = stockPriceClient.stockPriceByName(name);
//		String price = stockPriceByName.getBody();
//		Double totalStockPrice=0D;
//		if(!price.contains("NOT FOUND")) {
//			totalStockPrice=Double.valueOf(price)*quantity;
//			return new ResponseEntity<>(String.valueOf(totalStockPrice), HttpStatus.OK);
//		}
//		return new ResponseEntity<>(price, HttpStatus.OK);
//	}
	
	
//	@GetMapping(value = {"/stocks/{name}/{qty}"})
//	public ResponseEntity<StockPrice> findStockPrice(@PathVariable("name") String name, 
//			@PathVariable("qty") Double quantity) {
//		ResponseEntity<String> stockPriceByName = stockPriceClient.stockPriceByName(name);
//		
//		StockPrice stockCalc=new StockPrice();
//		stockCalc.setName(name);
//		stockCalc.setQuantity(quantity);
//		String price = stockPriceByName.getBody();
//		Double totalStockPrice=0D;
//		if(!price.contains("NOT FOUND")) {
//			totalStockPrice=Double.valueOf(price)*quantity;
//			stockCalc.setTotal(totalStockPrice);
//			stockCalc.setStatus("OK");
//			return new ResponseEntity<>(stockCalc, HttpStatus.OK);
//		}
//		stockCalc.setStatus("NOT FOUND");
//		return new ResponseEntity<>(stockCalc, HttpStatus.OK);
//	}
	
	@GetMapping(value = {"/stocks/{name}/{qty}"})
	public ResponseEntity<StockPrice> findStockPrice(@PathVariable("name") String name, 
			@PathVariable("qty") Double quantity) {
		ResponseEntity<StockPrice> findStockPriceByName = stockPriceClient.findStockPriceByName(name);
		StockPrice body = findStockPriceByName.getBody();
		
		if(body.getId()!=null) {
			Double price = body.getPrice();
			body.setTotal(price*quantity);
			body.setQuantity(quantity);
			body.setStatus("OK");
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
		body.setStatus("Not Found");
		body.setName(name);
		body.setQuantity(quantity);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

}
