package completeSearch;

import optimizationProblem.Node;

public interface BranchingStrategy {
	public int getNextDomain(Node node);
}