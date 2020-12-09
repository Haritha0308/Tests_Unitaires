package main;

import java.util.Vector;

/**
 * On testera la possibilité de faire une duplication de deux vecteurs aves des paramètres non null
 */
public class Vecteur {
	public static Vector<Object> unionSet(Vector<Object> a, Vector<Object> b) throws Exception {
		Vector<Object> fusion = new Vector<Object>();
		
		if (a.size() == 0 || b.size() == 0) {
            throw new Exception("Empty Vector(s), fusion impossible");
        }
		
		fusion.addAll(a);
		fusion.addAll(b);
		fusion.stream().distinct().collect(Collectors.toCollection(Vector::new));
        return fusion;
	};
	
}
