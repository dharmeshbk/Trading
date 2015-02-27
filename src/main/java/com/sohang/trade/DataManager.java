package com.sohang.trade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sohang.trade.model.TradeIdea;

public class DataManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataManager.class);
	
	@PersistenceContext(unitName = "ohang_tradeIdea")
	private EntityManager entityManager;
	
		
	public boolean save(TradeIdea tradeIdea) {
		EntityTransaction txn = entityManager.getTransaction(); 
		txn.begin();
		LOGGER.info("Saving TradeIdea record for ticker {} ",tradeIdea.getTicker());
		entityManager.persist(tradeIdea);
		txn.commit();
		return true;
	}
	
	
	public boolean delete(TradeIdea tradeIdea) {
		EntityTransaction txn = entityManager.getTransaction(); 
		txn.begin();
		LOGGER.info("deleting TradeIdea record for ticker {} ",tradeIdea.getTicker());
		entityManager.remove(tradeIdea);
		txn.commit();
		return true;
	}
	
	public List<TradeIdea> get(String field,String val) {
		FullTextEntityManager ftem = Search.getFullTextEntityManager(entityManager);
		//Optionally use the QueryBuilder to simplify Query definition:
		QueryBuilder qb = ftem.getSearchFactory().buildQueryBuilder().forEntity(TradeIdea.class).get();
		
		//Create a Lucene Query:
		Query lucentQuery = qb.keyword().onField(field).matching(val).createQuery();
		
		//Transform the Lucene Query in a JPA Query:
		FullTextQuery ftQuery = ftem.createFullTextQuery(lucentQuery, TradeIdea.class);
		//This is a requirement when using Hibernate OGM instead of ORM:
		ftQuery.initializeObjectsWith(ObjectLookupMethod.SKIP,DatabaseRetrievalMethod.FIND_BY_ID);
		//List all matching Hypothesis:
		List<TradeIdea> tradeIdeas = ftQuery.getResultList();
		return tradeIdeas;
	}
	
	

}
