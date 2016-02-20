import CompleteSearch.Node;
import CompleteSearch.Problem;

public interface LocalSearchProblem extends Problem {
	public int countViolatedConstraints(Node node);
}
