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

	/**
	 * @deprecated
	 */
	public int getSize() {
		return this.size();
	}

	/**
	 * @deprecated
	 */
	public int getVariable(int i) {
		// TODO Auto-generated method stub
		return variables.get(i);
	}
}
