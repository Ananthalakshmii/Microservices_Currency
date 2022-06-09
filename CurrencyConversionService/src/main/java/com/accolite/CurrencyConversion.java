package com.accolite;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversion {
	
	//fields should match with currency exchange - for autobinding-- field type and field name should match-else should do binding manually 
	
	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal quantity;
	private BigDecimal conversionRate;
	private BigDecimal totalCalcAmount;
	private String environment;

}
