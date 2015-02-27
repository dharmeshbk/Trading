package com.sohang.trade.model;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.sohang.trade.service.FinanceDataService;
import com.sohang.trade.service.Utils;

public class SpringTradeIdeaView {
	private String ticker;

	private Date watchDate;

	private float tradePrice;

	private float stopPrice;

	private int actualQty;

	private float lowerBand;

	private float baseBand;

	private float currentPrice;

	private float targetPrice;

	private String sector;

	private String tradeSetupIdea;

	private String chartTimeFrame; // 30M,D,W

	private String watchlistSource;

	private String technicalPattern;

	private float riskAmount;

	private float riskPercentage;

	private int estimateQty;

	private float totalAmount;

	private float totalriskAmount;

	private float totalriskPercentage;

	private float potentials;

	private float probability;

	private float riskReward;

	private boolean isConfirmed;

	private float accountBalance;
	
	private float maxOpenPosition;

	public SpringTradeIdeaView(SpringTradeIdea tradeIdea, float accountBalance,float maxOpenPosition) {
		if (tradeIdea != null && !StringUtils.isBlank(tradeIdea.getTicker())) {
			this.accountBalance = accountBalance;
			this.maxOpenPosition = maxOpenPosition;
			this.ticker = tradeIdea.getTicker();
			this.watchDate = tradeIdea.getWatchDate();
			this.tradePrice = tradeIdea.getTradePrice();
			this.stopPrice = tradeIdea.getStopPrice();
			this.actualQty = tradeIdea.getActualQty();
			this.lowerBand = tradeIdea.getLowerBand();
			this.baseBand = tradeIdea.getBaseBand();
			this.targetPrice = tradeIdea.getTargetPrice();
			this.sector = tradeIdea.getSector();
			this.tradeSetupIdea = tradeIdea.getTradeSetupIdea();
			this.chartTimeFrame = tradeIdea.getChartTimeFrame();
			this.watchlistSource = tradeIdea.getWatchlistSource();
			this.technicalPattern = tradeIdea.getTechnicalPattern();
			this.currentPrice = FinanceDataService.getCurrentPrice(tradeIdea
					.getTicker());
			derivedAll();
		}
	}

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

	public float getRiskAmount() {
		riskAmount = stopPrice - tradePrice;
		return Utils.roundTo2Decimal(riskAmount);
	}

	public float getRiskPercentage() {
		riskPercentage = (riskAmount / tradePrice)*100;
		return Utils.roundTo2Decimal(riskPercentage);
	}

	public int getEstimateQty() {
		float estQty = (getAccountBalance() / tradePrice)/getMaxOpenPosition();
		estimateQty = (int) Utils.roundTo0Decimal(estQty);
		return estimateQty;
	}

	public float getTotalAmount() {
		totalAmount = tradePrice * actualQty;
		return Utils.roundTo0Decimal(totalAmount);
	}

	public float getTotalriskAmount() {
		totalriskAmount = getRiskAmount() * actualQty;
		return Utils.roundTo0Decimal(totalriskAmount);
	}

	public float getTotalriskPercentage() {
		totalriskPercentage = (getTotalriskAmount() / getTotalAmount())/100;
		return Utils.roundTo2Decimal(totalriskPercentage);
	}

	public float getPotentials() {
		potentials = targetPrice - currentPrice;
		return Utils.roundTo0Decimal(potentials);
	}

	public float getProbability() {
		probability = (50 + (getCurrentPrice() - getBaseBand())
				* (50 / (getTargetPrice() - getBaseBand())));
		return Utils.roundTo0Decimal(probability);
	}

	public float getRiskReward() {
		riskReward = getPotentials() / getRiskAmount();
		return Utils.roundTo2Decimal(riskReward);
	}

	public boolean isConfirmed() {
		if (getProbability() > 50) {
			isConfirmed = true;
		} else {
			isConfirmed = false;
		}
		return isConfirmed;
	}

	public float getAccountBalance() {
		return accountBalance;
	}
	
	public float getMaxOpenPosition() {
		return maxOpenPosition;
	}

	private void derivedAll() {
		getRiskAmount();
		getRiskPercentage();
		getEstimateQty();
		getTotalAmount();
		getTotalriskAmount();
		getTotalriskPercentage();
		getPotentials();
		getProbability();
		getRiskReward();
		isConfirmed();
	}

	@Override
	public String toString() {
		return "SpringTradeIdeaView [ticker=" + ticker + ", watchDate=" + watchDate
				+ ", tradePrice=" + tradePrice + ", stopPrice=" + stopPrice
				+ ", actualQty=" + actualQty + ", lowerBand=" + lowerBand
				+ ", baseBand=" + baseBand + ", currentPrice=" + currentPrice
				+ ", targetPrice=" + targetPrice + ", sector=" + sector
				+ ", tradeSetupIdea=" + tradeSetupIdea + ", chartTimeFrame="
				+ chartTimeFrame + ", watchlistSource=" + watchlistSource
				+ ", technicalPattern=" + technicalPattern + ", riskAmount="
				+ riskAmount + ", riskPercentage=" + riskPercentage
				+ ", estimateQty=" + estimateQty + ", totalAmount="
				+ totalAmount + ", totalriskAmount=" + totalriskAmount
				+ ", totalriskPercentage=" + totalriskPercentage
				+ ", potentials=" + potentials + ", probability=" + probability
				+ ", riskReward=" + riskReward + ", isConfirmed=" + isConfirmed
				+ ", accountBalance=" + accountBalance + "]";
	}
	
	



}
