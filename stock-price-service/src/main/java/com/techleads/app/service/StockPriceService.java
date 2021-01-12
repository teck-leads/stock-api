package com.techleads.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techleads.app.model.StockPrice;
import com.techleads.app.repository.StockPriceRespository;

@Service
public class StockPriceService {

	private StockPriceRespository priceRepo;

	public StockPriceService(StockPriceRespository priceRepo) {
		this.priceRepo = priceRepo;
	}

	public String findByName(String name) {
		Optional<StockPrice> findByName = priceRepo.findByName(name);
		if (findByName.isPresent()) {
			Double price = findByName.get().getPrice();
			return String.valueOf(price);
		}
		return "NOT FOUND";
	}

	public StockPrice saveStockPrice(StockPrice stock) {
		StockPrice save = priceRepo.save(stock);
		return save;
	}

	public StockPrice findStockPriceById(Integer id) {
		Optional<StockPrice> findById = priceRepo.findById(id);

		if (findById.isPresent()) {
			return findById.get();
		}
		return new StockPrice();
	}

	public List<StockPrice> findAllStockPrices() {

		List<StockPrice> findAll = priceRepo.findAll();
		return findAll;
	}
	
	
	public List<StockPrice> deleteStockPriceById(Integer id) {
		Optional<StockPrice> findById = priceRepo.findById(id);
		if(findById.isPresent()) {
			priceRepo.deleteById(id);
		}
		List<StockPrice> findAll = priceRepo.findAll();
		return findAll;
	}

}
