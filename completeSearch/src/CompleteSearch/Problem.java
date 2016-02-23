package CompleteSearch;

public interface Problem {

	Node initialNode();
	Proof testSat(Node node);
	void printSolution(Node node);
}
