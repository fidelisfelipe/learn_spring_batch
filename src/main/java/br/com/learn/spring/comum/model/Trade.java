package br.com.learn.spring.comum.model;

import java.math.BigDecimal;

public class Trade {
	
	private String isin;
	private Long quantity;
	private BigDecimal price;
	private String customer;
	
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Trade [isin=" + isin + ", quantity=" + quantity + ", price=" + price + ", customer=" + customer + "]";
	}
}
