package CompleteSearch;

import java.util.ArrayList;

public class Node extends ArrayList<Domain>{
	
	public Node() {
		super();
	}
	
	public Node(Node n) {
		super(n);
	}
	public Node(Integer variable, Domain dom, Node node) {
		// retourne un noeud
	}


	public Node(ArrayList<Domain> domains){
		this.doms=domains;
	}
	
}
