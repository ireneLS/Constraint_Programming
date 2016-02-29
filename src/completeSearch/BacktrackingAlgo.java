package completeSearch;

import optimizationProblem.Node;

public interface BacktrackingAlgo {

	int solve(BranchingStrategy strat);
	void branch(Node node);
}