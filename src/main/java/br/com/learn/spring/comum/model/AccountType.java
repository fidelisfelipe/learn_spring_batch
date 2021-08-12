package br.com.learn.spring.comum.model;

public enum AccountType {
	SILVER, GOLD, PLATINUM, DIAMOND, INVALID;

	public static AccountType salaryRange(Double salaryRange ) {
		if(salaryRange == null)
			return INVALID;
		if (salaryRange <= 3000)
			return SILVER;
		else if (salaryRange > 3000 && salaryRange <= 5000)
			return GOLD;
		else if (salaryRange > 5000 && salaryRange <= 10000)
			return PLATINUM;
		else
			return DIAMOND;
	}
}
