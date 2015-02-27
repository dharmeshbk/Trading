package com.sohang.trade.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomizeConfiguation {

	 private static final Logger LOGGER = LoggerFactory.getLogger(CustomizeConfiguation.class);
	    
	    private @Value("${account.balance}") float accountBalance;
	    
	    private @Value("${max.open.positions}") float maxOpenPosition;
	    
	    public float getAccountBalance() {
			return accountBalance;
		}

		public float getMaxOpenPosition() {
			return maxOpenPosition;
		}
		
		
		

}
