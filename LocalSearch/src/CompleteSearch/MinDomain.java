package CompleteSearch;

import java.util.ArrayList;

public class MinDomain implements BranchingStrategy {

	public MinDomain(){
		
	
	}

	public int getNextDomain(Node node){
		int choix=0; //mise à 0 du choix pour pouvoir compiler
		for(int i=1; i<node.getSize();++i){
			ArrayList<Domain> domains = node.getDomains();
			if(domains.get(i).getSize() < choix){
				
			}
		}
		return 0;
		
	}
}
