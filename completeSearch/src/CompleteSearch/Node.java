package CompleteSearch;

import java.util.ArrayList;

public class Node {

	ArrayList<Domain> doms;
	
	public Node(ArrayList<Domain> domains){
		this.doms=domains;
	}
	
	public Node() {
		// TODO Auto-generated constructor stub
		doms = new ArrayList<Domain>();
	}

	public int getSize(){
		return doms.size();
	}
	
	public ArrayList<Domain> getDomains(){
		return doms;
	}

	public void setDomain(Domain dom) {
		// TODO Auto-generated method stub
		doms.add(dom);
	}
}
