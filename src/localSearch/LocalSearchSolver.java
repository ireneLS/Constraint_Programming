package localSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import optimizationProblem.Domain;
import optimizationProblem.Node;
import optimizationProblem.Problem;

public class LocalSearchSolver {

	private Problem problem;
	private boolean solved;
	private final int NB_MAX_LOOP = 10000;

	public LocalSearchSolver(Problem pb) {
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

}
