package localSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import optimizationProblem.Domain;
import optimizationProblem.NReine;
import optimizationProblem.Node;
import optimizationProblem.Problem;

public class LocalSearchSolveur {

	private Problem problem;
	private boolean solved;
	
	public LocalSearchSolveur(Problem pb) {
		solved = false;
		problem = pb;

	}
	
	public List<Node> neighbourhoods(Node node) {
		List<Node> result = new ArrayList<Node>();
		for(int i = 0 ; i < node.size() ; i++) {
			for(Domain d : problem.initialNodeLocal()) {
				if(!d.equals(node.get(i))) {
					Node neighbourdhood = new Node(node);
					neighbourdhood.set(i, d);
					result.add(neighbourdhood);
				}
			}
		}
		return result;
	}
	
	public Map<Node, Integer> cost(List<Node> neighbourhoods) {
		Map<Node, Integer> result = new HashMap<Node, Integer>();
		for(Node neighbourhood : neighbourhoods) {
			result.put(neighbourhood, problem.countViolatedConstraints(neighbourhood));
		}
		return result;
	}


	// Optimisable
	public Node move(Map<Node, Integer> costs) {
		Node result = new Node();
		Integer minCost = Integer.MAX_VALUE;
		for(Node n : costs.keySet()) {
			if(costs.get(n) < minCost) {
				minCost = costs.get(n);
				result = n;
			}
		}
		if(minCost.equals(0)) {
			solved = true;
		}
		return result;
	}
	
	public Node solve() {
		Node n = problem.init();
		while(!solved) {
			n = move(cost(neighbourhoods(n)));
		}
		return n;
	}
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		LocalSearchSolveur solveur = new LocalSearchSolveur(new NReine(4));
		List results = solveur.solve();
		for(Object o : results) {
			System.out.println(o);
		}
	}
}

