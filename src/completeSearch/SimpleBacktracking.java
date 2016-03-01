package completeSearch;

import java.util.ArrayList;
import optimizationProblem.Proof;
import optimizationProblem.Domain;
import optimizationProblem.Node;
import optimizationProblem.Problem;

public class SimpleBacktracking implements BacktrackingAlgo {

	Problem problem;
	BranchingStrategy strategy;
	ArrayList<Node> findedSolution = new ArrayList<Node>();
	boolean solved = false;

	public SimpleBacktracking(Problem problem, BranchingStrategy branchStrat) {
		this.problem = problem;
		this.strategy = branchStrat;
	}

	public int solve() {
		Node n = problem.initialNode();
		return backtracking(n);
	}

	public ArrayList<Node> branch(Node node) {
		int nextDomainToBranch = strategy.getNextDomain(node);
		ArrayList<Node> solutions = new ArrayList<Node>();
		Integer selectBranchingDomain; // le "domaine du noeud cree par le
										// branching"

		// J'ajoute autant de noeuds que la taille du domaine selectionné
		for (int i = 0; i < node.get(nextDomainToBranch).size(); ++i) {
			// je récupère le domaine pour pouvoir le "prune" des autres noeuds.
			selectBranchingDomain = node.get(nextDomainToBranch).get(i);
			Node noeudTmp = new Node();
			// pour chaque domaine du noeud courant. On l'ajoute au noeud
			// temporaire en enlevant le domaine avant. sauf pour le noeud
			// branch où on ne garde que le selectBranchingDomain
			for (int j = 0; j < node.size(); j++) {
				Domain domainTmp = new Domain();
				if (j == nextDomainToBranch) {
					domainTmp.add(selectBranchingDomain);
					noeudTmp.add(domainTmp);
				} else {// TODO bon.... je crois que y a un truc qui cloche
					domainTmp.addAll(node.get(j));
					domainTmp.remove(selectBranchingDomain);
					noeudTmp.add(domainTmp);
				}
			}
			solutions.add(noeudTmp);
		}
		return solutions;
	}

	public int backtracking(Node node) {
		ArrayList<Node> nextNodes = branch(node);
		int solutionTrouvee = 0;
		for (Node nextNode : nextNodes) {
			Proof proof = problem.testSat(nextNode);
			if (proof != Proof.FAILURE) {
				if (proof == Proof.SUCCESS) {
					findedSolution.add(nextNode);
					solutionTrouvee = solutionTrouvee + 1;
				} else {
					if (proof == Proof.MIDDLE_NODE) {
						solutionTrouvee = solutionTrouvee + backtracking(nextNode);
					}
				}
			}
		}
		return solutionTrouvee;
	}

	public void printSolution() {
		if (findedSolution.isEmpty()) {
			System.out.println("Il n'y a pas de solution");
			return;
		}
		int cpt = 1;
		for(Node solution : findedSolution) {
			System.out.println("Solution " + cpt++ + " :");
			problem.printSolution(solution);
			System.out.println("------------------");
		}
	}
}
