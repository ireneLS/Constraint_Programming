package CompleteSearch;

import java.util.ArrayList;

public class Node extends ArrayList<Domain>{
	
	public Node() {
		super();
	}
	
	public Node(Node n) {
		super(n);
	}

	/**
	 * @deprecated
	 */
	public int getSize(){
		return this.size();
	}
	
	/**
	 * @deprecated
	 */
	public ArrayList<Domain> getDomains(){
		return this;
	}
	public Node(ArrayList<Domain> domains){
		this.doms=domains;
	}
	
	public Node(Integer variable, Domain dom, Node node) {
		// retourne un noeud
	}
}
