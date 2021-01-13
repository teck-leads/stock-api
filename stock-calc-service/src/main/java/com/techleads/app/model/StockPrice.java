package com.techleads.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockPrice {
	
	private Integer id;
	private String name;
	private Double price;
	private Double quantity;
	private Double total;
	private String portNum;
	private String status;
	

}
