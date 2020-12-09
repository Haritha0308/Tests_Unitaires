package test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import main.Racine;

/**
 * Spec <br>
 * A < B <br>
 * Valeurs A et B doivent être strictement positifs et non null
 */
@DisplayName("Unit test Racine")
public class RacineTest {
	private static Racine racine;
	/**
	 * Initialisation de l'objet Racine
	 */
	@BeforeAll
	static void beforeAll() {
		racine = new Racine();
	}

	/**
	 * Quand a > b, on doit avoir une exception
	 */
	@Test
	@DisplayName("Value A > Value B => Exception")
	public void testParametersException(){
		assertThrows(Exception.class,()->{
			racine.allSqrt(5, 3);
		},"B must be high than A");
	}
	
	/**
	 * Quand a = b, on doit avoir une exception
	 */
	@Test
	@DisplayName("Value A = Value B => Exception")
	public void testEqualParametersException(){
		assertThrows(Exception.class,()->{
			racine.allSqrt(5, 5);
		},"B must be high than A");
	}
	
	/**
	 * Quand a<0 et b<0, on doit avoir une exception
	 */
	@Test
	@DisplayName("Value A < 0 && Value B < 0 => Exception")
	public void testNagativeParametersException(){
		assertThrows(Exception.class,()->{
			racine.allSqrt(-2, -2);
		},"Values must be superior at 0");
	}
	
	/**
	 * Quand a=0 et b=0, on doit avoir une exception
	 */
	@Test
	@DisplayName("Value A = 0 && Value B = 0 => Exception")
	public void testNullParametersException(){
		assertThrows(Exception.class,()->{
			racine.allSqrt(0, 0);
		},"Values must be superior at 0");
	}
	
	/**
	 * Quand a < b, on a un dictionnaire de nombres et leur racine carré
	 */
	@Test
	@Timeout(100)
	@DisplayName("Value A < Value B => Ok")
	public void testParamater() throws Exception {
		HashMap<Integer, Double> racineTest = racine.allSqrt(3, 5);
		HashMap<Integer, Double> racineExpected = new HashMap<Integer, Double>(){
			private static final long serialVersionUID = 1L;

			{
				put(3, Math.sqrt(3));
				put(4, Math.sqrt(4));
				put(5, Math.sqrt(5));
			}
		};
		
		assertTrue(racineExpected.equals(racineTest));
	}
}