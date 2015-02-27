package com.sohang.trade.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
@Table(name="trade_idea")
public class TradeIdea implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ticker")
	private String ticker;
	@Column(name="watchDate")
	private Date watchDate;
	@Column(name="tradePrice")
	private float tradePrice;
	@Column(name="stopPrice")
	private float stopPrice;
	@Column(name="actualQty")
	private int actualQty;
	@Column(name="lowerBand")
	private float lowerBand;
	@Column(name="baseBand")
	private float baseBand;
	@Column(name="currentPrice")
	private float currentPrice;
	@Column(name="targetPrice")
	private float targetPrice;
	@Field(analyze=Analyze.YES)
	@Column(name="sector")
	private String sector;
	@Field(analyze=Analyze.YES)
	@Column(name="tradeSetupIdea")
	private String tradeSetupIdea;
	@Field(analyze=Analyze.YES)
	@Column(name="chartTimeFrame")
	private String chartTimeFrame; // 30M,D,W
	@Field(analyze=Analyze.YES)
	@Column(name="watchlistSource")
	private String watchlistSource;
	@Field(analyze=Analyze.YES)
	@Column(name="technicalPattern")
	private String technicalPattern;
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
		return "TradeIdea [ticker=" + ticker + ", watchDate=" + watchDate
				+ ", tradePrice=" + tradePrice + ", stopPrice=" + stopPrice
				+ ", actualQty=" + actualQty + ", lowerBand=" + lowerBand
				+ ", baseBand=" + baseBand + ", currentPrice=" + currentPrice
				+ ", targetPrice=" + targetPrice + ", sector=" + sector
				+ ", tradeSetupIdea=" + tradeSetupIdea + ", chartTimeFrame="
				+ chartTimeFrame + ", watchlistSource=" + watchlistSource
				+ ", technicalPattern=" + technicalPattern + "]";
	}
	
	
	
	
	
}
