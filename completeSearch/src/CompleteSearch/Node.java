package CompleteSearch;

import java.util.ArrayList;

public class Node extends ArrayList<Domain>{
	
	public Node() {
		super();
	}
	
	public Node(Node n) {
		super(n);
	}
	
	public int getSize(){
		return this.size();
	}
	
	public ArrayList<Domain> getDomains(){
		return this;
	}
}
