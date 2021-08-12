package br.com.learn.spring.comum.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * @author Fidelis.Guimaraes
 *
 */
public class Client {

	@NotNull
	@Size(min = 1, max = 100)
	@Pattern(regexp = "^([a-zA-Zà-úÀ-Ú0-9 ]|-|_|\\s)+$", message = "Name must be alphabetical")
	private String firstName;
	@NotNull
	@Size(min = 1, max = 50)
	private String lastName;
	@NotNull
	@Range(min = 18, max = 200)
	private String age;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", message = "Email must be valid")
	private String email;
	private List<Transaction> transactionList = new ArrayList<>();
	
	private Double salaryRange;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
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
	
	public Double getSalaryRange() {
		return salaryRange;
	}

	public void setSalaryRange(Double salaryRange) {
		this.salaryRange = salaryRange;
	}

	@Override
	public String toString() {
		return "Client [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", email=" + email
				+ ", transactionList=" + transactionList + ", salaryRange=" + salaryRange + "]";
	}

}
