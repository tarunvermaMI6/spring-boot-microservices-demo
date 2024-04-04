package com.learning.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	 Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer(){
		
		return factory -> factory.configureDefault(
				
				id -> new Resilience4JConfigBuilder(id).circuitBreakerConfig(CircuitBreakerConfig.ofDefaults()).
				build()
				
				);
	}
	
//	@Bean
//     Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {
//        
//		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
//				  .failureRateThreshold(5)
//				  .waitDurationInOpenState(Duration.ofMillis(1000))
//				  .slidingWindowSize(2)
//				  .build();
//				TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
//				  .timeoutDuration(Duration.ofSeconds(4))
//				  .build();
//
//				return factory -> factory.configure(builder -> builder.circuitBreakerConfig(circuitBreakerConfig)
//					      .timeLimiterConfig(timeLimiterConfig).build(), "CircuitBreaker");
//    } 
	
}
