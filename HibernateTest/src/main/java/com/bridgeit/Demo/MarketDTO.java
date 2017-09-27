package com.bridgeit.Demo;

import java.io.Serializable;


public class MarketDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int shopNum;
	
	private String shopName;
	
	private String marketName;
	
	private int noOfShop;
	
	public MarketDTO() {

	}

	public int getShopNum() {
		return shopNum;
	}

	public void setShopNum(int shopNum) {
		this.shopNum = shopNum;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public int getNoOfShop() {
		return noOfShop;
	}

	public void setNoOfShop(int noOfShop) {
		this.noOfShop = noOfShop;
	}

	
}
