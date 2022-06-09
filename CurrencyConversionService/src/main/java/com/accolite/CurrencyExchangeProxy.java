package com.accolite;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//application name of currency exchange along with port number-- port number dynamically set in run as confuguration-arguments using-- -Dserver.port=8001
@FeignClient(name = "currency-exchange"/* ,url="localhost:8001" */)// dynamically changing port number(load balancing) when multiple ports are running in exchange service when url is removed
public interface CurrencyExchangeProxy {
	
	//copy 12,13 from currency exchange- copy signature alone
	@GetMapping("/currency-exchange-HC/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValueHC(@PathVariable String from , @PathVariable String to);
	

}
