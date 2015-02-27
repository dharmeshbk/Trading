package com.sohang.trade.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sohang.trade.dao.TradeIdeaDAO;
import com.sohang.trade.model.TradeIdea;
import com.sohang.trade.model.TradeIdeaView;

@Named
public class SpringDataManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataManager.class);
	
	@Autowired
	private TradeIdeaDAO tradeIdeaDao;
	
	@Autowired
	private CustomizeConfiguation config;
	
	public boolean store(TradeIdea tradeidea) {
		tradeIdeaDao.create(tradeidea);
		return true;
	}
	
	public boolean store(List<TradeIdea> tradeideas) {
		for (TradeIdea tradeIdea : tradeideas) {
			store(tradeIdea);
		}
		return true;
	}
	
	public TradeIdea getTradeIdeaByTicker(String ticker) {
		LOGGER.info("Get TradeIdea by ticker {} ",ticker);
		return tradeIdeaDao.getByTicker(ticker);
		
	}

	public List<TradeIdeaView> getTradeIdeasWithProbability(float probability) {
		List<TradeIdeaView> views = new ArrayList<TradeIdeaView>();
		List<TradeIdea> tradeideas = tradeIdeaDao.getAll();
		for (TradeIdea tradeIdea : tradeideas) {
			if (tradeIdea != null ) {
				TradeIdeaView view = new TradeIdeaView(tradeIdea, config.getAccountBalance(),config.getMaxOpenPosition());
				if (view != null) {
					if (view.getProbability() > probability) {
						views.add(view);
					}
				}
			}
		}
		return views;
	}

	public List<TradeIdeaView> applyProbAndPotentials(float probability,float potentials) {
		List<TradeIdeaView> views = new ArrayList<TradeIdeaView>();
		List<TradeIdea> tradeideas = tradeIdeaDao.getAll();
		for (TradeIdea tradeIdea : tradeideas) {
			if (tradeIdea != null ) {
				TradeIdeaView view = new TradeIdeaView(tradeIdea, config.getAccountBalance(),config.getMaxOpenPosition());
				if (view != null) {
					if (Math.abs(view.getProbability()) > probability && Math.abs(view.getPotentials()) > potentials) {
						views.add(view);
					}
				}
			}
		}
		return views;
	}
	
}
