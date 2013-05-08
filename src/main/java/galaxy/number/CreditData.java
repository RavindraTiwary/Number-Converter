package galaxy.number;

public class CreditData {
	
	private String number;
	private String currency;

	public CreditData(String number, String currency) {
		this.number = number;
		this.currency = currency;
	}

	public String number() {
		return number;
	}

	public String currency() {
		return currency;
	}

	@Override
	public int hashCode() {
		return currency.hashCode();
	}

	@Override
	public boolean equals(Object otherCreditData) {
		if (!(otherCreditData instanceof CreditData)) return false;
		CreditData other = (CreditData) otherCreditData;
		return number.equals(other.number()) && currency.equals(other.currency());
	}
	
	

}
