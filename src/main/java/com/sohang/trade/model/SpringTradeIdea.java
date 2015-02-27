package com.sohang.trade.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class SpringTradeIdea {

	@Id
	@Indexed(unique=true)
	private String ticker;

	private Date watchDate;

	private float tradePrice;

	private float stopPrice;

	private int actualQty;

	private float lowerBand;

	private float baseBand;

	private float currentPrice;

	private float targetPrice;

	@Indexed
	private String sector;

	private String tradeSetupIdea;

	private String chartTimeFrame; // 30M,D,W
	@Indexed
	private String watchlistSource;
	@Indexed
	private String technicalPattern;

/*	public SpringTradeIdea(final String ticker) {
		this.ticker = ticker;
	}*/

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public Date getWatchDate() {
		return watchDate;
	}

	public void setWatchDate(Date watchDate) {
		this.watchDate = watchDate;
	}

	public float getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(float tradePrice) {
		this.tradePrice = tradePrice;
	}

	public float getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(float stopPrice) {
		this.stopPrice = stopPrice;
	}

	public int getActualQty() {
		return actualQty;
	}

	public void setActualQty(int actualQty) {
		this.actualQty = actualQty;
	}

	public float getLowerBand() {
		return lowerBand;
	}

	public void setLowerBand(float lowerBand) {
		this.lowerBand = lowerBand;
	}

	public float getBaseBand() {
		return baseBand;
	}

	public void setBaseBand(float baseBand) {
		this.baseBand = baseBand;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public float getTargetPrice() {
		return targetPrice;
	}

	public void setTargetPrice(float targetPrice) {
		this.targetPrice = targetPrice;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getTradeSetupIdea() {
		return tradeSetupIdea;
	}

	public void setTradeSetupIdea(String tradeSetupIdea) {
		this.tradeSetupIdea = tradeSetupIdea;
	}

	public String getChartTimeFrame() {
		return chartTimeFrame;
	}

	public void setChartTimeFrame(String chartTimeFrame) {
		this.chartTimeFrame = chartTimeFrame;
	}

	public String getWatchlistSource() {
		return watchlistSource;
	}

	public void setWatchlistSource(String watchlistSource) {
		this.watchlistSource = watchlistSource;
	}

	public String getTechnicalPattern() {
		return technicalPattern;
	}

	public void setTechnicalPattern(String technicalPattern) {
		this.technicalPattern = technicalPattern;
	}

	@Override
	public String toString() {
		return "SpringTradeIdea [ticker=" + ticker + ", watchDate=" + watchDate
				+ ", tradePrice=" + tradePrice + ", stopPrice=" + stopPrice
				+ ", actualQty=" + actualQty + ", lowerBand=" + lowerBand
				+ ", baseBand=" + baseBand + ", currentPrice=" + currentPrice
				+ ", targetPrice=" + targetPrice + ", sector=" + sector
				+ ", tradeSetupIdea=" + tradeSetupIdea + ", chartTimeFrame="
				+ chartTimeFrame + ", watchlistSource=" + watchlistSource
				+ ", technicalPattern=" + technicalPattern + "]";
	}
	
	

}
