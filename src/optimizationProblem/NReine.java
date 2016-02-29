package optimizationProblem;

import java.util.ArrayList;

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
		
		//Cr�ation de l'ensemble de valeurs possible pour les variables du probl�me
		ArrayList<Integer> valAleatoires = new ArrayList<Integer>();
		for (int i = 0;i<nbR;i++){
			valAleatoires.add(1+i);
		}
		
		Random r = new Random();
		Node n = new Node();
		//boolean diagonal1=false;
		//boolean diagonal2=false;
		for (int i = 1 ; i<=nbR ; i++){
			/*
			if(diagonal1){
				if (i<=nbR-2){
					if(valAleatoires.get(0) == i){
						n.add(new Domain(new ArrayList<Integer>(){{add(valAleatoires.get(1));}}));
						n.add(new Domain(new ArrayList<Integer>(){{add(valAleatoires.get(0));}}));
					}
					else{
						
					}
					i=nbR;
					
				}
				else{
					
				}
			}
			else if(diagonal2){
				if (i<=nbR-2){
					
					
					i=nbR;
					
				}
				else{
					
				}
			}*/
			//else{
				//On recherche une position al�atoire dans le tableau 
				int pos = r.nextInt(valAleatoires.size());
				//La valeur de la variable va �tre �gale � l'�l�ment � la position g�n�r�e al�atoirement
				int temp = valAleatoires.get(pos);
				/*if (temp == i ){
					diagonal1 = true;
				}*/
				/*else if(temp == this.nbR-i+1){
					diagonal2=true;
				}*/
				//On supprime la valeur d�j� utilis�e 
				valAleatoires.remove(pos);
				
				
				//Ajout de la valeur de la variable dans son domaine
				
			
			
				n.add(new Domain(new ArrayList<Integer>(){{add(temp);}}));
			}
			
		//}
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
		NReine testR = new NReine(6);
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
