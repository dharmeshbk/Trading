package com.sohang.trade.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sohang.trade.dao.spring.TradeIdeaSpringDao;
import com.sohang.trade.model.SpringTradeIdea;
import com.sohang.trade.model.SpringTradeIdeaView;

@Named
public class DataServiceSpringImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataServiceSpringImpl.class);
	
	@Autowired
	private TradeIdeaSpringDao tradeIdeaDao;
	
	@Autowired
	private CustomizeConfiguation config;
	
	public SpringTradeIdeaView store(SpringTradeIdea tradeidea) {
		tradeIdeaDao.create(tradeidea);
		return new SpringTradeIdeaView(tradeidea, config.getAccountBalance(),config.getMaxOpenPosition());
		
	}
	
	public boolean store(List<SpringTradeIdea> tradeideas) {
		for (SpringTradeIdea tradeIdea : tradeideas) {
			store(tradeIdea);
		}
		return true;
	}
	
	public SpringTradeIdeaView getTradeIdeaByTicker(String ticker) {
		LOGGER.info("Get TradeIdea by ticker {} ",ticker);
		SpringTradeIdea tradeIdea = tradeIdeaDao.getByTicker(ticker);
		if (tradeIdea != null) {
			return new SpringTradeIdeaView(tradeIdea, config.getAccountBalance(),config.getMaxOpenPosition());
		}
		return null;
		
	}

	public List<SpringTradeIdeaView> getTradeIdeasWithProbability(float probability) {
		List<SpringTradeIdeaView> views = new ArrayList<SpringTradeIdeaView>();
		List<SpringTradeIdea> tradeideas = tradeIdeaDao.getAll();
		LOGGER.info("Got total tradeIdeas {} ",tradeideas.size());
		for (SpringTradeIdea tradeIdea : tradeideas) {
			if (tradeIdea != null ) {
				SpringTradeIdeaView view = new SpringTradeIdeaView(tradeIdea, config.getAccountBalance(),config.getMaxOpenPosition());
				if (view != null) {
					if (view.getProbability() > probability) {
						views.add(view);
					}
				}
			}
		}
		LOGGER.info("Got total views {} ",views.size());
		return views;
	}
	

	public List<SpringTradeIdeaView> applyProbAndPotentials(float probability,float potentials) {
		List<SpringTradeIdeaView> views = new ArrayList<SpringTradeIdeaView>();
		List<SpringTradeIdea> tradeideas = tradeIdeaDao.getAll();
		for (SpringTradeIdea tradeIdea : tradeideas) {
			if (tradeIdea != null ) {
				SpringTradeIdeaView view = new SpringTradeIdeaView(tradeIdea, config.getAccountBalance(),config.getMaxOpenPosition());
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
