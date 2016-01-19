package CompleteSearch;

public class Solver {

	BacktrackingAlgo algo;
	BranchingStrategy strategy;
	
	public Solver(BacktrackingAlgo algo, BranchingStrategy strategy){
		this.algo = algo;
		this.strategy = strategy;
	}

	public void solve(Problem problem){
		algo.solve(strategy);
	}
}
