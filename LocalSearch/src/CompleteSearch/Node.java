package CompleteSearch;

import java.util.ArrayList;

public class Node {

	ArrayList<Domain> doms;
	public Node(){
		this.doms=new ArrayList<Domain>();
	}
	public Node(ArrayList<Domain> domains){
		this.doms=domains;
	}
	
	public int getSize(){
		return doms.size();
	}
	
	public ArrayList<Domain> getDomains(){
		return doms;
	}
	
	public void setDomain(Domain dom){
		this.doms.add(dom);
	}
	public boolean contientValeur(int temp) {
		// TODO Auto-generated method stub
		for (Domain d : doms){
			if (d.contientValeur(temp)){
				return true;
			}
		}
		return false;
	}
}
