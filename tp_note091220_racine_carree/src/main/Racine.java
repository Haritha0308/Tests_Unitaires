package main;

import java.util.HashMap;

public class Racine {
	/**
	 * Calcul des racines carrés compris entre deux nombres entiers
	 * @author Jennifer CALIANASSOUNDARAM && Jean-Baptiste DA COSTA
	 * @author github.com/Haritha0308/Tests_Unitaires/
	 * @version 1.0
	 * @param a premier nombre entier
	 * @param b second nombre entier
	 * @return dictionnaire avec les nombres et leur racine
	 */
	public HashMap<Integer, Double> allSqrt(int a, int b) throws Exception{
		if(a <= 0 || b <= 0) {
			throw new Exception("Values must be superior at 0");
		}
		if(a>=b) {
			throw new Exception("B must be high than A");
		}
		
		HashMap<Integer, Double> allRacine = new HashMap<Integer, Double>();
		for (int i = a; i <= b; i++) {
			allRacine.put(i, Math.sqrt(i));
		}
		
		return allRacine;
	}
}
