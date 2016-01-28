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

	public boolean contientValeur(int temp) {
		// TODO Auto-generated method stub
		for (int var : variables){
			if (var == temp){
				return true;
			}
		}
		return false;
	}
	
	
	
}
