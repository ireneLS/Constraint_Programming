package completeSearch;

import java.util.ArrayList;

import optimizationProblem.Node;

public interface BacktrackingAlgo {

	int solve();
	ArrayList<Node> branch(Node node); // renvoie une liste de noeud sinon, comment on les récupère ??
	void printSolution();
}