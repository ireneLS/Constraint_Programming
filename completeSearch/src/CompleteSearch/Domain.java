package CompleteSearch;

import java.util.ArrayList;

public class Domain {
	
	ArrayList<Integer> variables;
	
	public Domain(ArrayList<Integer> vars){
		this.variables = vars;
	}

	public int getSize() {
		return variables.size();
	}

	public int getVariable(int i) {
		// TODO Auto-generated method stub
		return variables.get(i);
	}
	
	
	
}
