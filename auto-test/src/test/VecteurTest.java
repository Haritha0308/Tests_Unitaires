package test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import main.VecteurTest;

public class VecteurTest {
	
	/**
	 * Instanciation de 3 vecteurs pour r�aliser les tests
	 * Un sous forme de string
	 * Deux sous forme d'entier
	 */
    Vector<Object> stringVector = new Vector<Object>() {
        private static final long serialVersionUID = 1L;

        {
            add("Test");
            add("Test2");
        }
    };
    
    Vector<Object> intVector = new Vector<Object>() {
        private static final long serialVersionUID = 1L;

        {
            add(2);
            add(9);
            add(3);
        }
    };
    
    Vector<Object> intVector1 = new Vector<Object>() {
        private static final long serialVersionUID = 1L;

        {
            add("6");
            add(12);
        }
    };
    
    
    @Test
    /**
     * Test pour l'usage de la m�thode unionSet fonctionne
     * et si on ne rencontre pas d'exceptions
     * Pour cela, on dit que l'on peut avoir un r�sultat, lorsqu'il n'y a pas d'exception
     * avec l'usage de la m�thode unionSet sur les 3 vecteurs
     */
    public void fusionTestOk() {
        Vector <Object> result;
        result = assertDoesNotThrow(() -> Vecteur.unionSet(intVector, intVector1));
        assertEquals(result.size(), 5);
    }

    @Test
    /**
     * Test pour savoir si les param�tres des vecteurs ont une taille 
     * sup�rieur � 0
     * Pour cela, on utilise deux vecteurs vides
     * Ainsi, on fait ressortir une erreur que l'on va comparer avec celle
     * pr�sente sur la m�thode
     */
    public void fusionTestPasParametres() {
        Exception thrown = assertThrows(
            Exception.class,
            () -> Vecteur.unionSet(new Vector<Object>(), new Vector<Object>()),
            "Expected thrown exception, but it didn't"
        );

        assertSame(thrown.getMessage(), "Empty Vector(s), fusion impossible");
    }
	
}
