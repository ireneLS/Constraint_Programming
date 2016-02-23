package CompleteSearch;

import java.util.ArrayList;

public class SimpleBacktracking implements BacktrackingAlgo{

	Problem problem;
	BranchingStrategy strategy;
	
	public SimpleBacktracking(Problem problem){
		this.problem=problem;
	}
	
	@Override
	public int solve(BranchingStrategy strat) {
		// TODO Auto-generated method stub
		Node racine=problem.initialNode();
		strategy=strat;
		
		backtracking(racine);
		
		return 0;
	}

	@Override
	public void branch(Node node) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<ArrayList<Domain>> backtracking(Node node){
		int domain = strategy.getNext(node);
		
		ArrayList<ArrayList<Domain>> solutions = new ArrayList<ArrayList<Domain>>();
		
		if(problem.testSat(node)==Proof.middle_node){
			Domain dom;
			for(int i=0; i< node.getOneDomain(domain).getSize() ;++i){
				dom = node.getOneDomain(domain);
				Node nouveauNode = new Node(dom.getVariable(i), dom, node);
				
				solutions.addAll(backtracking(nouveauNode));
			}
		}
		if(problem.testSat(node)==Proof.success){
			solutions.add(e);
		}
		
		
		
		
		return solutions;
	}
}
