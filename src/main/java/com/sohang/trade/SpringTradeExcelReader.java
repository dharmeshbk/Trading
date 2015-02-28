package com.sohang.trade;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sohang.trade.model.SpringTradeIdea;

public class SpringTradeExcelReader {


	
	String inputXMLMap = "C:\\Users\\dkumar\\projects\\sohang\\Trading\\src\\main\\resources\\tradeIdeaTemplate.xml";
	String inputTradeExcel = "C:\\Users\\dkumar\\Desktop\\Misc\\TradePlanning.xlsx";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringTradeExcelReader.class);
	
	public List<SpringTradeIdea> loadDataFromExcel() {
		try {
			FileInputStream fi = new FileInputStream(new File(inputXMLMap));
			InputStream input = new FileInputStream(inputXMLMap);
			//InputStream inputXML = new BufferedInputStream(getClass().getResourceAsStream(inputXMLMap));	
			XLSReader mainReader = ReaderBuilder.buildFromXML(new File(inputXMLMap));
			//InputStream inputExcel = new FileInputStream(inputTradeExcel);
			InputStream inputXLS = new BufferedInputStream(new FileInputStream(inputTradeExcel));
			  
			List<SpringTradeIdea> result = new ArrayList<SpringTradeIdea>();
			Map<String,List<SpringTradeIdea>> tradeideas = new HashMap<>();			
			tradeideas.put("result",result);			
			mainReader.read(inputXLS, tradeideas);
			System.out.println(result.size());
			return result;
		} catch (Exception e) {
			System.out.println(e);
			LOGGER.error(e.getLocalizedMessage(),e);
		}
		return new ArrayList<SpringTradeIdea>(); 
	}
	
    
    



}
