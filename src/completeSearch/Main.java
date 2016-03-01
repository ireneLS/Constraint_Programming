package completeSearch;

import java.util.Scanner;
import optimizationProblem.NQueen;

public class Main {

	public static void main(String[] args) {
		// Lecture du nombre de reines
		System.out.print(" ---- Probl�me NQueen : recherche compl�te ----\nIndiquez le nombre de reines : ");
		int nbReines = 1;
		Scanner in = new Scanner(System.in);
		nbReines = in.nextInt();
		in.close();

		// Calcule du temps mis � trouver la solution
		long tempsDebut = System.currentTimeMillis();
		BacktrackingAlgo solveur = new SimpleBacktracking(new NQueen(nbReines), new MinDomain());
		int numberOfResults = solveur.solve();
		long seconds = (System.currentTimeMillis() - tempsDebut) / 1000;

		// Affichage si c'est trop long de trouver la solution
		if (numberOfResults == 0) {
			System.out.println("Pas de solution.");
			return;
		}

		// Affichage de la solution
		System.out.println("Solution trouv�e en " + seconds + "sc :");
		System.out.println(numberOfResults + " r�sultats");
		solveur.printSolution();
	}
}
