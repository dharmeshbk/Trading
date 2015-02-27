package com.sohang.trade.dao;

import java.util.List;

import com.sohang.trade.model.TradeIdea;

public interface TradeIdeaDAO {

	public void create(TradeIdea tradeIdea);
    
    public TradeIdea getByTicker(String ticker);
     
    public void update(TradeIdea tradeIdea);
     
    public int deleteByTicker(String ticker);
    
    public List<TradeIdea> getAll();
}
