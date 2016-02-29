package completeSearch;

import optimizationProblem.Constraint;
import optimizationProblem.Domain;
import optimizationProblem.Node;

public class DefaultContraints extends Constraint {

	public static boolean check(Node node) {
		for(int i = 0; i < node.size();i++){
			Domain domain = node.get(i);
			for(int j = i+1; j < node.size();j++){
				Domain domain2 = node.get(j);
				int dx=domain.get(0)/4;
				int dy=domain.get(0)%4;
				int d2x=domain2.get(0)/4;
				int d2y=domain2.get(0)%4;
				if(dx==d2x || dy==d2y){
					return false;
				}
				if(Math.abs(dx-d2x)==Math.abs(dy-d2y)){
					return false;
				}
			}
		}
		return false;
	}

}