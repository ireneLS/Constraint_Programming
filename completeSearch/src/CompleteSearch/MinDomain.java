package CompleteSearch;

import java.util.ArrayList;

public class MinDomain implements BranchingStrategy {

	public MinDomain(){
		
	}

	public int getNext(Node node){
		ArrayList<Domain> domains = node.getDomains();
		int choix=-1;
		for(int i=0; i<node.getSize();++i){
			if(domains.get(i).getSize() < choix && domains.get(i).getSize()!=1){
				choix = i;
			}
		}
		return choix;
		
	}
}
