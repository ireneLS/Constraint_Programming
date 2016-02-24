import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

import CompleteSearch.Domain;
import CompleteSearch.Node;
import CompleteSearch.Problem;
import CompleteSearch.Proof;


public class NReine implements LocalSearchProblem {
	
	
	int nbR;
	//Map<Integer,Integer> courant;
	
	public NReine(int nbR){
		this.nbR = nbR;
		
	}
	

	
	public Node init(){
		
		//Cr�ation de l'ensemble de valeurs possible pour les variables du probl�me
		ArrayList<Integer> valAleatoires = new ArrayList<Integer>();
		for (int i = 0;i<nbR;i++){
			valAleatoires.add(1+i);
		}
		
		Random r = new Random();
		Node n = new Node();
		
		for (int i = 1 ; i<=nbR ; i++){
			//On supprime la valeur correspondant � la grande diagonal
			
			valAleatoires.remove(Arrays.asList(i));
			
			//On recherche une position al�atoire dans le tableau 
			int pos = r.nextInt(valAleatoires.size());
			//La valeur de la variable va �tre �gale � l'�l�ment � la position g�n�r�e al�atoirement
			int temp = valAleatoires.get(pos);
			//On supprime la valeur d�j� utilis�e 
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

	//Ca osef pour l'instant
	//TODO Fusionner LocalSearchProblem et CompleteSearch.Problem
	public Node initialNode() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Proof testSat(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	public void printSolution(Node node) {
		// TODO Auto-generated method stub
		
	}



}
