package com.accolite;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {
	@Id
	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal conversionRate;
	private String environment;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	public BigDecimal getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public CurrencyExchange(Long id,String fromCurrency, String toCurrency, BigDecimal conversionRate, String environment) {
		super();
		this.id=id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.conversionRate = conversionRate;
		this.environment = environment;
	}
	public CurrencyExchange() {
		super();
	}
	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", fromCurrency=" + fromCurrency + ", toCurrency=" + toCurrency
				+ ", conversionRate=" + conversionRate + ", environment=" + environment + "]";
	}
	
	

}
