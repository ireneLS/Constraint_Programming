package optimizationProblem;

import java.util.ArrayList;
import java.util.Random;

public class NQueen implements Problem {

	int nbReine;

	// Map<Integer,Integer> courant;

	public NQueen(int nbR) {
		this.nbReine = nbR;

	}

	/**
	 * Methode renvoyant un ensemble de variables, un Node, qui permet de
	 * commencer la recherche local Ce node est initilise de facon a ce que
	 * chaque reine soit placee sur un ligne et une colonne differente
	 * 
	 * @return Node, le noeud initialise pour le probleme des NQueens en
	 *         recherche local
	 * 
	 * 
	 * 
	 * */
	@SuppressWarnings("serial")
	public Node init() {

		// Creation de l'ensemble de valeurs possible pour les variables du
		// probleme
		ArrayList<Integer> valAleatoires = new ArrayList<Integer>();
		for (int i = 0; i < nbReine; i++) {
			valAleatoires.add(1 + i);
		}

		Random r = new Random();
		Node n = new Node();

		for (int i = 1; i <= nbReine; i++) {

			// On recherche une position aleatoire dans le tableau
			int pos = r.nextInt(valAleatoires.size());
			// La valeur de la variable va etre egale a l'element a la position
			// generee aleatoirement

			final int temp = valAleatoires.get(pos);

			// On supprime la valeur deja utilisee
			valAleatoires.remove(pos);

			// Ajout de la valeur de la variable dans son domaine

			n.add(new Domain(new ArrayList<Integer>() {
				{
					add(temp);
				}
			}));
		}

		return n;
	}

	public int countViolatedConstraints(Node n) {
		int cpt = 0;

		for (int i = 0; i < n.size() - 1; i++) {
			for (int j = i + 1; j < n.size(); j++) {
				if (Math.abs((i + 1) - (j + 1)) == Math.abs(n.get(j).get(0)
						- n.get(i).get(0))) {
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
			if (n.get(i).size() == 0) {
				return Proof.FAILURE; // un domaine est vide
			}
			// on doit verifier les contraintes mais uniquement sur les
			// reines qui sont deja placees (domaine = 1) et pas sur tous les
			// domaines du noeud
			if (n.get(i).size() == 1) { // la premiere reine est placee
				for (int j = i + 1; j < n.size(); j++) {
					if (n.get(j).size() == 1) { // la deuxieme reine est placee
						// verifie si les contraintes sont toutes respectees
						if (Math.abs((i + 1) - (j + 1)) == Math.abs(n.get(j)
								.get(0) - n.get(i).get(0))) {
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
			// tous les domaines sont a 1 alors c'est bon.
			return Proof.SUCCESS;
		} else {
			// sinon c'est simplement un noeud intermediaire.
			return Proof.MIDDLE_NODE;
		}
	}

	public void printSolution(Node node) {
		int cpt = 1;
		for (Domain d : node) {
			System.out.println("Reine " + cpt + " en position [" + cpt++ + ","
					+ d.get(0) + "]");
		}
	}

	// //Le main d'Ugo (
	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// Node test;
	// NQueen testR = new NQueen(4);
	// test = testR.init();
	//
	// /*
	// * ArrayList<Integer> var = new ArrayList<Integer>(); var.add(3); Domain
	// * d1 = new Domain(var); var.remove(0); var.add(1); Domain d2 = new
	// * Domain(var); var.remove(0); var.add(4); Domain d3 = new Domain(var);
	// * var.remove(0); var.add(2); Domain d4 = new Domain(var);
	// *
	// * ArrayList<Domain> dom = new ArrayList<Domain>(); dom.add(d1);
	// * dom.add(d2); dom.add(d3); dom.add(d4);
	// *
	// * Node test2 = new Node(dom);
	// */
	// System.out.println(test);
	// System.out.println(testR.countViolatedConstraints(test));
	// }

}
