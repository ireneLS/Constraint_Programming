package CompleteSearch;

import java.util.ArrayList;

public class Node {

	ArrayList<Domain> doms;
	
	public Node(ArrayList<Domain> domains){
		this.doms=domains;
	}
	
	public Node(Integer variable, Domain dom, Node node) {
		// retourne un noeud
	}



	public int getSize(){
		return doms.size();
	}
	
	public ArrayList<Domain> getDomains(){
		return doms;
	}
	
	public Domain getOneDomain(int i){
		return doms.get(i);
	}
}
