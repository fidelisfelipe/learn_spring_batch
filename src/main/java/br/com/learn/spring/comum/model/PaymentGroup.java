package br.com.learn.spring.comum.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentGroup {
	private Integer codNatureExpense;
	private String descNatureExpense;
	private List<Payment> paymentList = new ArrayList<>();
	private Payment paymentTmp;
	
	public Double getTotal() {
		return paymentList
				.stream()
				.mapToDouble(Payment::getValue)
				.reduce(0.0, Double::sum);
	}

	public Integer getCodNatureExpense() {
		return codNatureExpense;
	}

	public void setCodNatureExpense(Integer codNatureExpense) {
		this.codNatureExpense = codNatureExpense;
	}

	public String getDescNatureExpense() {
		return descNatureExpense;
	}

	public void setDescNatureExpense(String descNatureExpense) {
		this.descNatureExpense = descNatureExpense;
	}

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	public Payment getPaymentTmp() {
		return paymentTmp;
	}

	public void setPaymentTmp(Payment paymentTmp) {
		this.paymentTmp = paymentTmp;
	}
	
}
