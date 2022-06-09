package com.accolite;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouting(RouteLocatorBuilder builder) {//custom routing - 1. adding headers 2. shortening url 3. adding multiple uris
		
		
		return builder.routes()
				.route(p->p.path("/get")//route-predicate(action) and filters
						.filters(f->f
								.addRequestHeader("MyHeader", "MyValue")
								.addRequestParameter("Param", "MyParam"))
						.uri("http://httpbin.org:80"))//showing header details-already available -url
				
				//localhost:8765/currency-exchange/currency-exchange/from/{from}/to/{to}
				
				.route(p->p.path("/currency-exchange-HC/**")//shortening url
						.uri("lb://currency-exchange")) //load balancer - localhost:xxxx/currency-exchange // from eureka server(name)
				
				.route(p->p.path("/currency-conversion-feign/**")//shortening url
						.uri("lb://currency-conversion"))
				
				.route(p->p.path("/currency-conversion-new/**") // create new uri to existing uri
						.filters(f->f.rewritePath(
								"/currency-conversion-new/(?<segment>.*)", // after new/ is moved to segment-- add multiple uris
								"/currency-conversion-feign/${segment}"))//inturn calls lb://currency-conversion
						//localhost:8765/currency-conversion/currency-conversion-feign/from/USD/to/INR/quantity/10
						//localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10
						//localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10
						.uri("lb://currency-conversion"))
				.build();
		
		//localhost:8765/get
		//localhost:8765/currency-exchange/from/{from}/to/{to}
		//localhost:8765/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}
		//localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10
				
	}
}
