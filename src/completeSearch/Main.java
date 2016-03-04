package completeSearch;

import java.util.Scanner;
import optimizationProblem.NQueen;

public class Main {

	public static void main(String[] args) {
		// Lecture du nombre de reines
		System.out.print(" ---- Probleme NQueen : recherche complete ----\nIndiquez le nombre de reines : ");
		int nbReines = 1;
		Scanner in = new Scanner(System.in);
		nbReines = in.nextInt();
		in.close();

		// Calcule du temps mis � trouver la solution
		long tempsDebut = System.currentTimeMillis();
		BacktrackingAlgo solveur = new ForwardChecking(new NQueen(nbReines), new MinDomain());
		int numberOfResults = solveur.solve();
		float seconds = (System.currentTimeMillis() - tempsDebut) / 1000F;

		// Affichage si c'est trop long de trouver la solution
		if (numberOfResults == 0) {
			System.out.println("Pas de solution.");
			return;
		}

		// Affichage de la solution
		System.out.println("Solution trouvee en " + seconds + " secondes :");
		System.out.println(numberOfResults + " resultats");
		solveur.printSolution();
	}
}
