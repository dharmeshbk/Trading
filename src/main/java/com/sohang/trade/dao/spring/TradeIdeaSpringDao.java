package com.sohang.trade.dao.spring;

import java.util.List;

import com.sohang.trade.model.SpringTradeIdea;

public interface TradeIdeaSpringDao {

public void create(SpringTradeIdea tradeIdea);
    
    public SpringTradeIdea getByTicker(String ticker);
     
    public void update(SpringTradeIdea tradeIdea);
     
    public int deleteByTicker(String ticker);
    
    public List<SpringTradeIdea> getAll();
}
