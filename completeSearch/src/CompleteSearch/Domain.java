package CompleteSearch;

import java.util.ArrayList;

public class Domain extends ArrayList<Integer> {
	
	public Domain(Integer var) {
		super();
		this.add(var);
	}
	
	public Domain(ArrayList<Integer> vars){
		super(vars);
	}

	public int getSize() {
		return this.size();
	}
}
