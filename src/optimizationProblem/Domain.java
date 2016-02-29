package optimizationProblem;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Domain extends ArrayList<Integer> {
	
	public Domain() {
		super();
	}
	
	public Domain(Integer var) {
		super();
		this.add(var);
	}
	
	public Domain(ArrayList<Integer> vars){
		super(vars);
	}
	
	public String afficherDomain() {
		// TODO Auto-generated method stub
		String res = "{";
		int i =0;
		for ( i=0 ;i<this.size()-1;i++){
			res+=this.get(i)+",";
			
		}
		res+=this.get(i);
		res+="} ";
		return res;
	}

}
