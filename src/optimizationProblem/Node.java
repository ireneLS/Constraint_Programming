package optimizationProblem;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Node extends ArrayList<Domain> {

	public Node() {
		super();
	}

	public Node(Node n) {
		super(n);
	}

	public Node(ArrayList<Domain> domains) {
		this.addAll(domains);
	}
}
