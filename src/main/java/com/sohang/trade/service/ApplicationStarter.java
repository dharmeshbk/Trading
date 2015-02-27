package com.sohang.trade.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sohang.trade.TradeExcelReader;
import com.sohang.trade.dao.TradeIdeaDAO;
import com.sohang.trade.model.TradeIdea;
import com.sohang.trade.model.TradeIdeaView;
import com.sohang.trade.spring.SpringMongoConfig;

public class ApplicationStarter {

	
	public static void main(String[] args) {
		
		 		
		//ApplicationContext applContext = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		//TradeIdeaDAO mgr = applContext.getBean("tradeIdeaDAO",TradeIdeaDAO.class);
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		TradeIdeaDAO mgr =  applicationContext.getBean(TradeIdeaDAO.class);
				
		TradeExcelReader excelReader = new TradeExcelReader();
		List<TradeIdea> tradeIdeas = excelReader.loadDataFromExcel();
		
		TradeIdea tradeIdea = null;
		for (TradeIdea t : tradeIdeas) {
			mgr.deleteByTicker(t.getTicker());
		}
				
		tradeIdea =  mgr.getByTicker("SWKS");
		System.out.println("SWKS Ticker {} "+tradeIdea);
		
		
		
		/*CustomizeConfiguation config = applicationContext.getBean(CustomizeConfiguation.class);
		config.getAccountBalance();
		float accountBalance = 50000;//new ApplicationStarter().confi.getAccountBalance();
		float maxOpenPos = 10;
		TradeIdeaView view = new TradeIdeaView(tradeIdea, accountBalance,maxOpenPos);
		
		System.out.println("SWKS Ticker {} "+view);
		
		
		SpringDataManager springMgr =  applicationContext.getBean(SpringDataManager.class);
		List<TradeIdeaView> views = springMgr.applyProbAndPotentials(100f,2f);
		for (TradeIdeaView t : views) {
			System.out.println(t);
		}*/
	}
	
	
	
	

}
