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
	
	//TODO fusionner initialNodeLocal et initialNode
	public List<Node> neighbourhoods(Node node) {
		List<Node> result = new ArrayList<Node>();
		for(int i = 0 ; i < node.size() ; i++) {
			for(int j = i + 1 ; j < node.size() ; j++) {
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
		if(problem.countViolatedConstraints(n) == 0) {
			return n;
		}
		while(!solved) {
			n = move(cost(neighbourhoods(n)));
		}
		return n;
	}
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		LocalSearchSolveur solveur = new LocalSearchSolveur(new NReine(6));
		List results = solveur.solve();
		for(Object o : results) {
			System.out.println(o);
		}
	}
}

