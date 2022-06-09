package com.accolite;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository cxrepo;
	
	@Autowired
	private Environment env; //org.springframework.core.env

	@GetMapping("/currency-exchange-HC/from/{fromcur}/to/{tocur}")
	public CurrencyExchange retrieveExchangeValueHC(@PathVariable String fromcur , @PathVariable String tocur) {
		
		String port=env.getProperty("local.server.port");
		
		CurrencyExchange currencyExchange=cxrepo.findByFromCurrencyAndToCurrency(fromcur, tocur);
		currencyExchange.setEnvironment(port);
		return currencyExchange;
		//return new CurrencyExchange(1l, fromcur, tocur, BigDecimal.valueOf(85),port);
	}
}
