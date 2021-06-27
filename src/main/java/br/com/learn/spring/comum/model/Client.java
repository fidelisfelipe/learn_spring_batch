package br.com.learn.spring.comum.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fidelis.Guimaraes
 *
 */
public class Client {

	private String firstName;
	private String lastName;
	private String age;
	private String email;
	private List<Transaction> transactionList = new ArrayList<>();
	
	public String getFirstName() {
		return firstName;
	}
	public void setFistName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Transaction> getTransactionList() {
		return transactionList;
	}
	
	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}
	@Override
	public String toString() {
		return "Client [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", email=" + email
				+ ", transactionList=" + transactionList + "]";
	}
	
}
