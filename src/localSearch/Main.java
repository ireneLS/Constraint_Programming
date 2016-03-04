package localSearch;

import java.util.Scanner;

import optimizationProblem.NQueen;
import optimizationProblem.Node;
import optimizationProblem.Problem;

public class Main {

	public static void main(String[] args) {
		// Lecture du nombre de reines
		System.out.print(" ---- Probleme NQueen : recherche locale ----\nIndiquez le nombre de reines : ");
		int nbReines = 1;
		Scanner in = new Scanner(System.in);
		nbReines = in.nextInt();
		in.close();

		// Calcule du temps mis a trouver la solution
		long tempsDebut = System.currentTimeMillis();
		Problem pbReines = new NQueen(nbReines);
		LocalSearchSolver solveur = new LocalSearchSolver(pbReines);
		Node result = solveur.solve();
		float seconds = (System.currentTimeMillis() - tempsDebut) / 1000F;

		// Affichage si c'est trop long de trouver la solution
		if (result == null) {
			System.out.println("Pas de solution.");
			return;
		}

		// Affichage de la solution
		System.out.println("Solution trouv�e en " + seconds + "sc :");
		pbReines.printSolution(result);
	}

}
