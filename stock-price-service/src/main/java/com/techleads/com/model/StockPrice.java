package com.techleads.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STOCK_TAB")
@SequenceGenerator(name = "stock_seq", initialValue = 2001, allocationSize = 1)
public class StockPrice {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq")
	@Id
	private Integer id;
	private String name;
	private Double price;
	
	
	

}
