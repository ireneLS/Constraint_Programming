package localSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import optimizationProblem.Domain;
import optimizationProblem.NQueen;
import optimizationProblem.Node;
import optimizationProblem.Problem;

public class LocalSearchSolveur {

	private Problem problem;
	private boolean solved;
	private final int NB_MAX_LOOP = 3000000;

	public LocalSearchSolveur(Problem pb) {
		solved = false;
		problem = pb;
	}

	public List<Node> neighbourhoods(Node node) {
		List<Node> result = new ArrayList<Node>();
		for (int i = 0; i < node.size(); i++) {
			for (int j = i + 1; j < node.size(); j++) {
				Node neighbourdhood = new Node(node);
				Domain tmp = node.get(j);
				neighbourdhood.set(j, node.get(i));
				neighbourdhood.set(i, tmp);
				result.add(neighbourdhood);
			}
		}
		return result;
	}

	public Map<Node, Integer> cost(List<Node> neighbourhoods) {
		Map<Node, Integer> result = new HashMap<Node, Integer>();
		for (Node neighbourhood : neighbourhoods) {
			result.put(neighbourhood, problem.countViolatedConstraints(neighbourhood));
		}
		return result;
	}

	// Optimisable
	public Node move(Map<Node, Integer> costs) {
		List<Node> results = new ArrayList<Node>();
		Integer minCost = Integer.MAX_VALUE;
		for (Node n : costs.keySet()) {
			if (costs.get(n) <= minCost) {
				minCost = costs.get(n);
				results.add(n);
			}
		}
		if (minCost.equals(0)) {
			solved = true;
		}
		return results.get((int) (Math.random() * results.size()));
	}

	public Node solve() {
		Node n = problem.init();
		int cptLoop = 0;
		if (problem.countViolatedConstraints(n) == 0) {
			return n;
		}
		while (!solved) {
			n = move(cost(neighbourhoods(n)));
			cptLoop++;
			// Pas de solution
			if (cptLoop == this.NB_MAX_LOOP) {
				return null;
			}
		}
		return n;
	}

	public static void main(String[] args) {
<<<<<<< HEAD
		LocalSearchSolveur solveur = new LocalSearchSolveur(new NReine(6));
		List results = solveur.solve();
		for(Object o : results) {
			System.out.println(o);
=======
		// Lecture du nombre de reines
		System.out.print(" ---- Problème NQueen ----\nIndiquez le nombre de reines : ");
		int nbReines = 1;
		Scanner in = new Scanner(System.in);
		nbReines = in.nextInt();
		in.close();
		
		// Calcule du temps mis à trouvé la solution
		long tempsDebut = System.currentTimeMillis();
		LocalSearchSolveur solveur = new LocalSearchSolveur(new NQueen(nbReines));		
		Node result = solveur.solve();
		long seconds = (System.currentTimeMillis() - tempsDebut) / 1000;

		// Affichage si c'est trop long de trouver la solution
		if (result == null) {
			System.out.println("Pas de solution.");
			return;
		}
		
		// Affichage de la solution
		System.out.println("Solution trouvée en " + seconds + "sc :");
		int cpt = 1;
		for (Domain d : result) {
			System.out.println("Reine " + cpt + " en position [" + cpt++ + "," + d.get(0) + "]");
>>>>>>> 1f72c6e8d3497e36723bc1b55a4f40132b4b5159
		}
	}
}
