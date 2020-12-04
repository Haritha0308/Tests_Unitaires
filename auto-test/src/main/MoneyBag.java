package main;

import java.util.ArrayList;

public class MoneyBag {
	private ArrayList<Money> Bag = new ArrayList<Money>();
	
	public ArrayList<Money> getBag(){
		return this.Bag;
	}
	
	public Money normalisation(Money m) {
		if(this.Bag != null && this.Bag.size() > 0){
			Money first = this.Bag.get(0);
		
			if(!first.getfCurrency().equals(m.getfCurrency())){
				if(first.getfCurrency().equals("EUR") && m.getfCurrency().equals("YEN")){
					return new Money((int) (m.getfAmount() / 100), "EUR");
				}
				else if(first.getfCurrency().equals("EUR") && m.getfCurrency().equals("GBP")){
					return new Money((int) (m.getfAmount() / 1.2), "EUR");
				}
				else if(first.getfCurrency().equals("YEN") && m.getfCurrency().equals("EUR")){
					return new Money((int) (m.getfAmount() * 100), "YEN");
				}
				else if(first.getfCurrency().equals("YEN") && m.getfCurrency().equals("GBP")){
					return new Money((int) (m.getfAmount() * 120), "YEN");
				}
				else if(first.getfCurrency().equals("GBP") && m.getfCurrency().equals("YEN")){
					return new Money((int) (m.getfAmount() / 120), "GBP");
				}
				else if(first.getfCurrency().equals("GBP") && m.getfCurrency().equals("EUR")){
					return new Money((int) (m.getfAmount() / 1.2), "GBP");	
				}
			}
		}
		return m;
	}
	
	public boolean equal(Money m1, Money m2) {
		return (m1.getfAmount()==m2.getfAmount() && m1.getfCurrency().equals(m2.getfCurrency()));
	}
	
	public void add(Money m1) {
		this.Bag.add(m1);
	}
	
	public void sub(Money m) {
		for(int i=0; i<this.Bag.size(); i++) {
			if(this.equal(this.Bag.get(i), m)) {
				this.Bag.remove(i);
			}
		}
	}
	
}
