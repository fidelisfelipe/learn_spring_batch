package br.com.learn.spring.comum.model;

public class Account {

	private Integer id;
	private AccountType type;
	private Double limit;
	private String clientId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	public Double getLimit() {
		return limit;
	}
	public void setLimit(Double limit) {
		this.limit = limit;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", limit=" + limit + ", clientId=" + clientId + "]";
	}
}
