import java.util.ArrayList;

import CompleteSearch.Domain;
import CompleteSearch.Node;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node test;
		NReine testR = new NReine(4);
		test = testR.init();
		
		
		
		/*
		ArrayList<Integer> var = new ArrayList<Integer>();
		var.add(3);
		Domain d1 = new Domain(var);
		var.remove(0);
		var.add(1);
		Domain d2 = new Domain(var);
		var.remove(0);
		var.add(4);
		Domain d3 = new Domain(var);
		var.remove(0);
		var.add(2);
		Domain d4 = new Domain(var);
		
		ArrayList<Domain> dom = new ArrayList<Domain>();
		dom.add(d1);
		dom.add(d2);
		dom.add(d3);
		dom.add(d4);
		
		Node test2 = new Node(dom);
		*/
		System.out.println(test.afficherVariables());
		System.out.println(testR.countViolatedConstraints(test));
	}

}
