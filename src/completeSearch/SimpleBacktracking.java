package completeSearch;

import java.util.ArrayList;
import optimizationProblem.Proof;
import optimizationProblem.Domain;
import optimizationProblem.Node;
import optimizationProblem.Problem;

public class SimpleBacktracking implements BacktrackingAlgo{

	Problem problem;
	BranchingStrategy strategy;
	
	public SimpleBacktracking(Problem problem){
		this.problem=problem;
	}
	

	public int solve(BranchingStrategy strat) {
		// TODO Auto-generated method stub
		Node racine=problem.initialNode();
		strategy=strat;
		
		backtracking(racine);
		
		return 0;
	}


	public void branch(Node node) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Node> backtracking(Node node){
		int domain = strategy.getNextDomain(node);
		
		ArrayList<Node> solutions = new ArrayList<Node>();

		if(problem.testSat(node)==Proof.middle_node){
			Domain dom;
			for(int i=0; i< node.get(domain).size() ;++i){
				dom = node.get(domain);
				Node nouveauNode = new Node(dom.get(i), dom, node);
				
				solutions.addAll(backtracking(nouveauNode));
			}
		}
		if(problem.testSat(node)==Proof.success){
			solutions.add(node);
		}
		return solutions;
	}
}
