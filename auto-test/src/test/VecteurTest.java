package test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import main.VecteurTest;

public class VecteurTest {
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
    public void fusionTestOk() {
        Vector <Object> result;
        result = assertDoesNotThrow(() -> Vecteur.unionSet(intVector, intVector1));
        assertEquals(result.size(), 5);
    }

    @Test
    public void fusionTestPasParametres() {
        Exception thrown = assertThrows(
            Exception.class,
            () -> Vecteur.unionSet(new Vector<Object>(), new Vector<Object>()),
            "Expected thrown exception, but it didn't"
        );

        assertSame(thrown.getMessage(), "Empty Vector(s), fusion impossible");
    }
	
}
