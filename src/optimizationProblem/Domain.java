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

}
