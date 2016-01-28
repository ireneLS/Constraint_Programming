package CompleteSearch;

public interface BacktrackingAlgo {

	int solve(BranchingStrategy strat);
	void branch(Node node);
}
