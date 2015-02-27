package com.sohang.trade.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.WriteResult;
import com.sohang.trade.model.TradeIdea;

@Component
public class TradeIdeaDaoImpl implements TradeIdeaDAO {

	@Autowired
	private MongoOperations mongoOperations;
	
	/*public TradeIdeaDaoImpl(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}*/
	
	@Override
	public void create(TradeIdea tradeIdea) {
		this.mongoOperations.insert(tradeIdea);

	}

	@Override
	public TradeIdea getByTicker(String ticker) {
		Query query = new Query(Criteria.where("ticker").is(ticker));
		return this.mongoOperations.findOne(query, TradeIdea.class);
	}

	@Override
	public void update(TradeIdea tradeIdea) {
		this.mongoOperations.save(tradeIdea);

	}

	@Override
	public int deleteByTicker(String ticker) {
		Query query = new Query(Criteria.where("ticker").is(ticker));
		WriteResult result = this.mongoOperations.remove(query, TradeIdea.class);
		return result.getN();
	}

	@Override
	public List<TradeIdea> getAll() {
		return mongoOperations.findAll(TradeIdea.class);		
	}

	

}
