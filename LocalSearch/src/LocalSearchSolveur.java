import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CompleteSearch.Domain;
import CompleteSearch.Node;
import CompleteSearch.Problem;

public class LocalSearchSolveur implements Solveur {

	private LocalSearchProblem problem;
	private Node initialDomain;
	private boolean solved;
	
	public LocalSearchSolveur(LocalSearchProblem pb) {
		solved = false;
		problem = pb;
		initialDomain = problem.initialNode();
	}
	
	//TODO Meilleur initialisation
	public Node initialNode() {
		Node result = new Node();
		for(Domain d : initialDomain) {
			result.add(new Domain(d.get(0)));
		}
		return result;
	}
	
	public List<Node> neighbourhoods(Node initialNode) {
		List<Node> result = new ArrayList<Node>();
		for(int i = 0 ; i < initialNode.size() ; i++) {
			for(Domain d : initialDomain) {
				if(!d.equals(initialNode.get(i))) {
					Node neighbourdhood = new Node(initialNode);
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
		Node n = initialNode();
		while(!solved) {
			n = move(cost(neighbourhoods(n)));
		}
		return n;
	}
	
	public static void main(String[] args) {
		LocalSearchSolveur solveur = new LocalSearchSolveur(new NReine(4));
		List results = solveur.solve();
		for(Object o : results) {
			System.out.println(o);
		}
	}
}
