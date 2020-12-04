package main;

import java.util.ArrayList;

public class Money {
	private int fAmount;
	private String fCurrency;
	public static ArrayList<String> CURRENCIES_MANAGED = new ArrayList<String>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		{
			 add("EUR");
		     add("USD");
		     add("CHF");
		     add("GBP");
		}	
	};
	
	public Money(int amount, String currency) {
		this.setfAmount(amount);
		this.setfCurrency(currency);
	};	
	
	public int getfAmount() {
		return fAmount;
	}
	public void setfAmount(int fAmount) {
		this.fAmount = fAmount;
	}

	public String getfCurrency() {
		return fCurrency;
	}

	public void setfCurrency(String fCurrency) {
		this.fCurrency = fCurrency;
	}
	
	public Money add (Money m) throws Exception {
        if(m.getfCurrency() != getfCurrency()) {
            throw new Exception("currency not equals");
        }
        return new Money(getfAmount() + m.getfAmount(), getfCurrency());
    }
    
    public Money add (int amount, String currency) throws Exception {
        if(currency != getfCurrency()) {
            throw new Exception("currency not equals");
        }
        if (!CURRENCIES_MANAGED.contains((currency))) {
            throw new Exception("Currency not managed");
        }        
        if ((getfAmount() + amount) < 0) {
        	throw new Exception("GetfAmount too low");
        }
        return new Money(getfAmount() + amount, currency);
    }
    
    public boolean equals(Object anObject) {
    	if(anObject instanceof Money) {
    		Money aMoney = (Money)anObject;
    		return aMoney.getfCurrency().equals(getfCurrency()) && getfAmount() == aMoney.getfAmount(); 
    	}
    	return false;
    }
}
