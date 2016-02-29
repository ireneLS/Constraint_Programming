package optimizationProblem;

public interface Problem {
	
	//Recherche complete
	Node initialNode();
	Proof testSat(Node node);
	void printSolution(Node node);
	
	//Recherche local
	Node init();
	int countViolatedConstraints(Node node);
	Node initialNodeLocal();
}
