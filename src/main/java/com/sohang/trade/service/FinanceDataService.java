package com.sohang.trade.service;

import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class FinanceDataService {

	public static float getCurrentPrice(final String ticker) {
		Stock stock = YahooFinance.get(ticker);
		BigDecimal price = stock.getQuote().getPrice();
		if (price != null) {
			return price.floatValue();
		}
		return 0;
	}
		
	
}
