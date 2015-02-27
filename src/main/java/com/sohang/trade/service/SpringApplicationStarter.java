package com.sohang.trade.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sohang.trade.SpringTradeExcelReader;
import com.sohang.trade.dao.spring.TradeIdeaSpringDao;
import com.sohang.trade.model.SpringTradeIdea;
import com.sohang.trade.model.SpringTradeIdeaView;

public class SpringApplicationStarter {

	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		TradeIdeaSpringDao mgr =  applicationContext.getBean(TradeIdeaSpringDao.class);
				
		SpringTradeExcelReader excelReader = new SpringTradeExcelReader();
		List<SpringTradeIdea> tradeIdeas = excelReader.loadDataFromExcel();
		
		for (SpringTradeIdea t : tradeIdeas) {
			mgr.create(t);
			//break;
		}
		
		SpringTradeIdea tradeIdea =  mgr.getByTicker("SWKS");		
		
		DataServiceSpringImpl springMgr =  applicationContext.getBean(DataServiceSpringImpl.class);
		List<SpringTradeIdeaView> views = springMgr.applyProbAndPotentials(100f,2f);
		for (SpringTradeIdeaView t : views) {
			System.out.println(t);
		}
		views = springMgr.getTradeIdeasWithProbability(100f);
		for (SpringTradeIdeaView t : views) {
			System.out.println(t);
		}
	}

}
