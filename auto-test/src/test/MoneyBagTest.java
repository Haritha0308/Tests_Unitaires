package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.Money;
import main.MoneyBag;

public class MoneyBagTest {
	@Test
	public void testEqualsMoney(){
		Money m1 = new Money(5, "EUR");
		Money m2 = new Money(5, "EUR");
		Money m3 = new Money(10, "EUR");
		Money m4 = new Money(5, "YEN");

		MoneyBag test = new MoneyBag();
		assertTrue(test.equal(m1, m2));
		assertFalse(test.equal(m1, m3));
		assertFalse(test.equal(m1, m4));
		assertFalse(test.equal(m2, m3));
		assertFalse(test.equal(m2, m4));	
	}
	
	@Test
	public void testAddMoney(){
		MoneyBag test = new MoneyBag();
		assertEquals(0, test.getBag().size());
		test.add(new Money(5, "EUR"));
		ArrayList<Money> list = test.getBag();
		assertEquals(list.size(), 1);
		Money item1 = list.get(0);
		assertEquals(item1.getfCurrency(), "EUR");
		assertEquals(item1.getfAmount(), 5);
	}
	
	@Test
	public void testSubMoney(){
		MoneyBag test = new MoneyBag();
		assertEquals(0, test.getBag().size());
		test.add(new Money(5, "EUR"));
		assertEquals(test.getBag().size(), 1);
		test.sub(new Money(10, "EUR"));
		assertEquals(test.getBag().size(), 1);

		test.sub(new Money(5, "YEN"));
		assertEquals(test.getBag().size(), 1);
 
		test.sub(new Money(5, "EUR"));
		assertEquals(test.getBag().size(), 0); 

	}
	
	@Test
	public void testMoneyNormalise(){
		Money m1 = new Money(4, "EUR");
		Money m2 = new Money(4, "EUR");
		Money m3 = new Money(1000, "YEN");
		Money m4 = new Money(10, "EUR");
		MoneyBag test = new MoneyBag();
		test.add(m1);
		assertTrue(test.equal(test.normalisation(m2), m2));
		assertTrue(test.equal(test.normalisation(m2), m1));
		assertTrue(test.equal(test.normalisation(m3), m4));
	}

}
