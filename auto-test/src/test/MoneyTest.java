package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import main.Money;

public class MoneyTest {
	
	@Test
	public void testSimpleAdd() throws Exception {
		Money m12C = new Money(12, "CHF");
		Money m10C = new Money(10, "CHF");
		Money expected = new Money(22, "CHF");
		Money resultat = m12C.add(m10C);
		assertEquals(expected.getfAmount(), resultat.getfAmount());
		assertEquals(expected.getfCurrency(), resultat.getfCurrency());
	}
	
	@Test
	public void testSimpleAddFailed() throws Exception {
		Money m12C = new Money(12, "CHF");
		assertThrows(Exception.class, () -> {
			m12C.add(10, "USD");
		}, "Currency not equals");
	}
	
	@Test
	public void testSimpleAddFailedCurrency() throws Exception {
		Money m12C = new Money(12, "CHF");
		assertThrows(Exception.class, () -> {
			m12C.add(10, "DSU");
		},  "Currency not managed");
	}
	
	@Test
	public void testSimpleAddFailedAmount() throws Exception {
		Money m12C = new Money(0, "CHF");
		assertThrows(Exception.class, () -> {
			m12C.add(-10, "CHF");
		}, "GetfAmount too low");
	}
	
	@Test
	public void testAdd() throws Exception {
		Money m12C = new Money(12, "CHF");
		Money expected = new Money(22, "CHF");
		Money res = m12C.add(10, "CHF");
		assertEquals(expected.getfAmount(), res.getfAmount());
		assertEquals(expected.getfCurrency(), res.getfCurrency());
	}
	
	@Test
	public void testAddFailed() {
		Money m12C = new Money(12, "CHF");
		assertThrows(Exception.class, () -> {
			m12C.add(10, "USD");
		}, "Currency not equals");
	}
	
	@Test
	public void testAddFailedCurrency() {
		Money m12C = new Money(12, "CHF");
		assertThrows(Exception.class, () -> {
			m12C.add(10, "AZE");
		}, "Currency not managed");
	}
	
	@Test
	public void testAddFailedAmount() {
		Money m12C = new Money(0, "CHF");
		assertThrows(Exception.class, () -> {
			m12C.add(-10, "USD");
		}, "GetfAmount too low");
	}
}
