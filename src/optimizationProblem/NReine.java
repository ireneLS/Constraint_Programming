package optimizationProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


import completeSearch.DefaultContraints;

public class NReine implements Problem {

	int nbR;
	//Map<Integer,Integer> courant;
	
	public NReine(int nbR){
		this.nbR = nbR;
		
	}
	
	// Recherche local
	public Node init(){
		

		//Création de l'ensemble de valeurs possible pour les variables du problème
		ArrayList<Integer> valAleatoires = new ArrayList<Integer>();
		for (int i = 0;i<nbR;i++){
			valAleatoires.add(1+i);
		}
		
		Random r = new Random();
		Node n = new Node();
		
		for (int i = 1 ; i<=nbR ; i++){

			//On supprime la valeur correspondant à la grande diagonal
			
			valAleatoires.remove(Arrays.asList(i));
			
			//On recherche une position aléatoire dans le tableau 
			int pos = r.nextInt(valAleatoires.size());
			//La valeur de la variable va être égale à l'élément à la position générée aléatoirement
			int temp = valAleatoires.get(pos);
			//On supprime la valeur déjà utilisée 
			valAleatoires.remove(pos);
			
			
			//Ajout de la valeur de la variable dans son domaine
			ArrayList<Integer> domain = new ArrayList<Integer>();
			domain.add(temp);
			Domain dom = new Domain(domain);
		
			n.add(dom);
			
			//On ajoute une nouvelle valeur possible (une histoire de grande diagonale)
			valAleatoires.add(i);
		}
		return n;
	}
	

	public boolean verificationSolution(Node n){
		for(int i = 0; i < n.size()-1;i++){
			for (int j = i+1;j<n.size(); j++){
				if( Math.abs((i+1)-(j+1)) == Math.abs( n.get(j).get(0)-n.get(i).get(0))){
					return false;
				}
			}
		}
		
		return true;
	}


	public ArrayList<Node> solve(int nbQ) {
		// TODO Auto-generated method stub
		
		return null;
	}

	//TODO A VRAIMENT FAIRE
	public int countViolatedConstraints(Node n) {
		// TODO Auto-generated method stub
		int cpt = 0;
		
		for(int i = 0; i < n.size()-1;i++){
			for (int j = i+1;j<n.size(); j++){
				if( Math.abs((i+1)-(j+1)) == Math.abs( n.get(j).get(0)-n.get(i).get(0))){
					cpt++;
				}
			}
		}
		return cpt;
	}

	public Node initialNodeLocal() {
		Node result = new Node();
		for(int i = 1; i <= nbR ; i++) {
			Domain d = new Domain();
			for(int j = 1; j<= nbR ; j++ ){
				d.add(j);
			}
			result.add(d);
		}
		return result;
	}
	
	//Recherche complete
	public Node initialNode() {
		Node result = new Node();
		for(int i = 1; i <= nbR ; i++) {
			Domain d = new Domain();
			for(int j = 1; j<= nbR*nbR ; j++ ){
				d.add(j);
			}
			result.add(d);
		}
		return result;
	}
	
	public Proof testSat(Node node) {
		boolean middleNode = false;
		
		for(int i = 0; i < node.size()-1;i++){
			if(node.get(i).size()!=1){
				middleNode=true;
			}
		}
		if(middleNode){
			return Proof.middle_node;
		}
		if(DefaultContraints.check(node)){
			return Proof.success;
		}
		return Proof.failure;
	}

	public void printSolution(Node node) {
		// TODO Auto-generated method stub
		
	}

	//Le main d'Ugo (anciennement classe Main de notre projet)
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
