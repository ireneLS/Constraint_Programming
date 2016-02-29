package completeSearch;

import optimizationProblem.Node;

public class MinDomain implements BranchingStrategy {

	public MinDomain(){}

	public int getNextDomain(Node node){
		int choix=-1;
		for(int i=0; i<node.size();++i){
			if(node.get(i).size() < choix && node.get(i).size()!=1){
				choix = i;
			}
		}
		return choix;
	}
}
