package com.sohang.trade.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sohang.trade.model.SpringTradeIdea;
import com.sohang.trade.model.SpringTradeIdeaView;
import com.sohang.trade.service.DataServiceSpringImpl;

@Path("/tradeIdeas")
@Named
public class TradeIdeaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TradeIdeaService.class);
	
	@Autowired
	private DataServiceSpringImpl dataService;
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public SpringTradeIdeaView createTradeIdea(SpringTradeIdea tradeidea) {
		LOGGER.info("createTradeIdea {} ",tradeidea);
		SpringTradeIdeaView view = null;//dataService.store(tradeidea);
		LOGGER.info("tradeidea is stored for the ticket {} ", view.getTicker());		
		return view;
	}
	
	@GET
	@Produces("application/json")
	public List<SpringTradeIdeaView> getTradeIdeas() {
		LOGGER.info("GetTradesByProbability");
		 List<SpringTradeIdeaView> views = dataService.getTradeIdeasWithProbability(0);
		 LOGGER.info("returned the views size {} ", views.size());
		 LOGGER.info("returned the views size {} ", views);
		return views;
	}
	
	@GET
	@Path("/{ticker}")
	@Produces("application/json")
	public SpringTradeIdeaView getTradeIdeasByTicker(@PathParam("ticker") String ticker) {
		LOGGER.info("getTradeIdeasByTicker");
		return dataService.getTradeIdeaByTicker(ticker);
	}
	
	@GET
	@Path("/{probability}")
	@Produces("application/json")
	public List<SpringTradeIdeaView> getTradeIdeaByProbability(@PathParam("probability") float probability) {
		LOGGER.info("GetTradesByProbability");
		return dataService.getTradeIdeasWithProbability(probability);
	}
	
	@GET
	@Path("/{probability}/{potentials}")
	@Produces("text/plain")
	public List<SpringTradeIdeaView> getTradeIdeaByProbabilityPotentials(@PathParam("probability") float probability,@PathParam("potentials") float potentials) {
		LOGGER.info("GetTradesByProbabilityAndPotentials");
		return dataService.applyProbAndPotentials(probability, potentials);
	}
	
	@GET
	@Path("/tests")
	@Produces("text/plain")
	public List<String> getTests(){
		List<String> tests = new ArrayList<>();
		tests.add("GetTest is called");
		tests.add("GetTest is returned");
		return tests;
	}
	
	@GET
	@Path("/test")
	@Produces("text/plain")
	public String getTest(){
		System.out.println("GetTest is returned");
		return "GetTest is returned";
		
	}
}


