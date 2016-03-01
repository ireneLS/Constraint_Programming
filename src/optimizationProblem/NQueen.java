package optimizationProblem;

import java.util.ArrayList;
import java.util.Random;

public class NQueen implements Problem {

	int nbReine;
	// Map<Integer,Integer> courant;

	public NQueen(int nbR) {
		this.nbReine = nbR;

	}

	// Recherche local
	@SuppressWarnings("serial")
	public Node init() {

		// Cr�ation de l'ensemble de valeurs possible pour les variables du
		// probl�me
		ArrayList<Integer> valAleatoires = new ArrayList<Integer>();
		for (int i = 0; i < nbReine; i++) {
			valAleatoires.add(1 + i);
		}

		Random r = new Random();
		Node n = new Node();
		// boolean diagonal1=false;
		// boolean diagonal2=false;
		for (int i = 1; i <= nbReine; i++) {
			/*
			 * if(diagonal1){ if (i<=nbR-2){ if(valAleatoires.get(0) == i){
			 * n.add(new Domain(new
			 * ArrayList<Integer>(){{add(valAleatoires.get(1));}})); n.add(new
			 * Domain(new ArrayList<Integer>(){{add(valAleatoires.get(0));}}));
			 * } else{
			 * 
			 * } i=nbR;
			 * 
			 * } else{
			 * 
			 * } } else if(diagonal2){ if (i<=nbR-2){
			 * 
			 * 
			 * i=nbR;
			 * 
			 * } else{
			 * 
			 * } }
			 */
			// else{
			// On recherche une position al�atoire dans le tableau
			int pos = r.nextInt(valAleatoires.size());
			// La valeur de la variable va �tre �gale � l'�l�ment � la position
			// g�n�r�e al�atoirement
			final int temp = valAleatoires.get(pos);
			/*
			 * if (temp == i ){ diagonal1 = true; }
			 */
			/*
			 * else if(temp == this.nbR-i+1){ diagonal2=true; }
			 */
			// On supprime la valeur d�j� utilis�e
			valAleatoires.remove(pos);

			// Ajout de la valeur de la variable dans son domaine

			n.add(new Domain(new ArrayList<Integer>() {
				{
					add(temp);
				}
			}));
		}

		// }
		return n;
	}

	public int countViolatedConstraints(Node n) {
		int cpt = 0;

		for (int i = 0; i < n.size() - 1; i++) {
			for (int j = i + 1; j < n.size(); j++) {
				if (Math.abs((i + 1) - (j + 1)) == Math.abs(n.get(j).get(0) - n.get(i).get(0))) {
					cpt++;
				}
				if (n.get(i).get(0).equals(n.get(j).get(0))) {
					cpt++;
				}
			}
		}
		return cpt;
	}


	public Node initialNode() {
		Node result = new Node();
		for (int i = 1; i <= nbReine; i++) {
			Domain d = new Domain();
			for (int j = 1; j <= nbReine; j++) {
				d.add(j);
			}
			result.add(d);
		}
		return result;
	}

	public Proof testSat(Node n) {
		boolean allDomainAtOne = true;
		for (int i = 0; i < n.size(); i++) {
			// TODO on doit v�rifier les contraintes mais uniquement sur les
			// reines qui sont d�j� plac�e (domaine = 1) et pas sur tous les
			// domaines du noeud
			if (n.get(i).size() == 1) { // la premiere reine est placee
				for (int j = i + 1; j < n.size(); j++) {
					if (n.get(j).size() == 1) { // la deuxieme reine est placee
						// verifie si les contraintes sont toutes respect�es
						if (Math.abs((i + 1) - (j + 1)) == Math.abs(n.get(j).get(0) - n.get(i).get(0))) {
							return Proof.FAILURE;
						}
						if (n.get(i).get(0).equals(n.get(j).get(0))) {
							return Proof.FAILURE;
						}
					}
				}
			}
			allDomainAtOne = allDomainAtOne && (n.get(i).size() == 1);
		}
		if (allDomainAtOne) {
			// tous les domaines sont � 1 alors c'est bon.
			return Proof.SUCCESS;
		} else {
			// sinon c'est simplement un noeud interm�diaire.
			return Proof.MIDDLE_NODE;
		}
	}

	public void printSolution(Node node) {
		int cpt = 1;
		for (Domain d : node) {
			System.out.println("Reine " + cpt + " en position [" + cpt++ + "," + d.get(0) + "]");
		}
	}

//	 //Le main d'Ugo (
//	 public static void main(String[] args) {
//	 // TODO Auto-generated method stub
//	 Node test;
//	 NQueen testR = new NQueen(4);
//	 test = testR.init();
//	
//	 /*
//	 * ArrayList<Integer> var = new ArrayList<Integer>(); var.add(3); Domain
//	 * d1 = new Domain(var); var.remove(0); var.add(1); Domain d2 = new
//	 * Domain(var); var.remove(0); var.add(4); Domain d3 = new Domain(var);
//	 * var.remove(0); var.add(2); Domain d4 = new Domain(var);
//	 *
//	 * ArrayList<Domain> dom = new ArrayList<Domain>(); dom.add(d1);
//	 * dom.add(d2); dom.add(d3); dom.add(d4);
//	 *
//	 * Node test2 = new Node(dom);
//	 */
//	 System.out.println(test);
//	 System.out.println(testR.countViolatedConstraints(test));
//	 }

}
