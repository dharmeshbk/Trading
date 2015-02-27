package com.sohang.trade.dao.spring;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.WriteResult;
import com.sohang.trade.model.SpringTradeIdea;

@Component
public class TradeIdeaSpringDaoImpl implements TradeIdeaSpringDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(TradeIdeaSpringDaoImpl.class);
	
	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public void create(SpringTradeIdea tradeIdea) {
		try {
		this.mongoOperations.insert(tradeIdea);
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(),e);
		}
	}

	@Override
	public SpringTradeIdea getByTicker(String ticker) {
		try {
			Query query = new Query(Criteria.where("ticker").is(ticker));
			return this.mongoOperations.findOne(query, SpringTradeIdea.class);
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(),e);
		}
		return null;
	}

	@Override
	public void update(SpringTradeIdea tradeIdea) {
		try {
			this.mongoOperations.save(tradeIdea);
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(),e);
		}

	}

	@Override
	public int deleteByTicker(String ticker) {
		try {
			Query query = new Query(Criteria.where("ticker").is(ticker));
			WriteResult result = this.mongoOperations.remove(query, SpringTradeIdea.class);
			return result.getN();
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(),e);
		}
		return 0;
	}

	@Override
	public List<SpringTradeIdea> getAll() {
		try {
			return mongoOperations.findAll(SpringTradeIdea.class);
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(),e);
		}	
		return new ArrayList<>();
	}

	

}
