import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import CompleteSearch.Domain;
import CompleteSearch.Node;


public class NReine implements Probleme {
	
	
	int nbR;
	Map<Integer,Integer> courant;
	
	public NReine(int nbR){
		this.nbR = nbR;
		
	}
	
	
	public Node init(){
		Random r = new Random();
		Node n = new Node();
		
		for (int i = 1 ; i<nbR ; i++){
			int temp = r.nextInt(nbR)+1;
			if (!n.contientValeur(temp)){
				Domain dom = new Domain(new ArrayList<Integer>(temp));
				n.setDomain(dom);
			}
		}
	
		return n;
		
	}


	public ArrayList<Node> solve(int nbQ) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
