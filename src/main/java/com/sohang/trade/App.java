package com.sohang.trade;


public class App {

	
	public static void main(String[] args) {
		new App().excelRead();
	}
	
	public void excelRead() {
		TradeExcelReader tradeExcelReader = new TradeExcelReader();
		tradeExcelReader.loadDataFromExcel();
	}

}
