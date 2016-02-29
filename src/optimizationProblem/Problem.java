package optimizationProblem;

public interface Problem {
	
	//Recherche complete
	Node initialNode();
	Proof testSat(Node node);
	void printSolution(Node node);
	
	//Recherche local
	int countViolatedConstraints(Node node);
}