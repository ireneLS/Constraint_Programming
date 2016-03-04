package completeSearch;

import java.util.ArrayList;
import optimizationProblem.Proof;
import optimizationProblem.Domain;
import optimizationProblem.Node;
import optimizationProblem.Problem;

/**
 * Forward Checking methode de backtracking qui alterne simplement entre un
 * branch et un prune
 * 
 * @author E124293B
 *
 */
public class ForwardChecking implements BacktrackingAlgo {

	Problem problem;
	BranchingStrategy strategy;
	ArrayList<Node> findedSolution = new ArrayList<Node>();
	boolean solved = false;

	/**
	 * Le forward checking est associe a un probleme et une branching strategy
	 * 
	 * @param problem
	 * @param branchStrat
	 */
	public ForwardChecking(Problem problem, BranchingStrategy branchStrat) {
		this.problem = problem;
		this.strategy = branchStrat;
	}

	public int solve() {
		Node n = problem.initialNode();
		return backtracking(n);
	}

	/**
	 * methode qui "branch and prune"
	 */
	public ArrayList<Node> branch(Node node) {
		// l'indice du domaine a branch :
		int nextDomainToBranch = strategy.getNextDomain(node);
		ArrayList<Node> solutions = new ArrayList<Node>();
		// le "domaine utilise/actuel du noeud cree par le branching" pour
		// chaque sous noeud cree
		Integer selectBranchingDomain;

		// J'ajoute autant de noeuds que la taille du domaine selectionne
		for (int i = 0; i < node.get(nextDomainToBranch).size(); ++i) {
			// je recupere le domaine de la branche que je cree pour pouvoir le
			// "prune" des autres noeuds.
			selectBranchingDomain = node.get(nextDomainToBranch).get(i);
			Node noeudTmp = new Node();
			// pour chaque domaine du noeud courant. On l'ajoute au noeud
			// temporaire en enlevant le domaine avant. sauf pour le noeud
			// branch ou l'on ne garde que le selectBranchingDomain
			for (int j = 0; j < node.size(); j++) {
				Domain domainTmp = new Domain();
				if (j == nextDomainToBranch) {
					domainTmp.add(selectBranchingDomain);
					noeudTmp.add(domainTmp);
				} else {
					domainTmp.addAll(node.get(j));
					domainTmp.remove(selectBranchingDomain);
					noeudTmp.add(domainTmp);
				}
			}
			solutions.add(noeudTmp);
		}
		return solutions;
	}

	/**
	 * methode recursive de backtracking. Pour chaque noeud cree par le branch,
	 * on verifie s'il verifie les contraintes. si non, on s'arrete, si oui on
	 * continue ou on a une solution
	 * 
	 * @param node
	 * @return le nombre de solution trouvee a partir de ce noeud
	 */
	public int backtracking(Node node) {
		ArrayList<Node> nextNodes = branch(node);
		int solutionTrouvee = 0;
		for (Node nextNode : nextNodes) {
			Proof proof = problem.testSat(nextNode);
			// si le noeud repond aux contraintes
			if (proof != Proof.FAILURE) {
				// soit c'est un noeud succes dans ce cas on ajoute la solution
				// a celle qu'on a deja
				if (proof == Proof.SUCCESS) {
					findedSolution.add(nextNode);
					solutionTrouvee = solutionTrouvee + 1;
				} else {
					// soit c'est un noeud intermediaire et dans ce cas on
					// continue a le branch
					if (proof == Proof.MIDDLE_NODE) {
						solutionTrouvee = solutionTrouvee
								+ backtracking(nextNode);
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
		for (Node solution : findedSolution) {
			System.out.println("Solution " + cpt++ + " :");
			problem.printSolution(solution);
			System.out.println("------------------");
		}
	}
}
