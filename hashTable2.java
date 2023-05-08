package tabelasHash;

public class hashTable2 {
	private int tamArray;
	private Nodo [] array;
	
	public hashTable2(int tamArray) {
		this.tamArray = tamArray;
		array = new Nodo[tamArray];
	}
	
	private int hash (String chave) {
		byte bytesChave[] = chave.getBytes();
		int hashCode = 0;
		for (int i : bytesChave) {
			hashCode += i;
		}
		return hashCode % tamArray;
	}
	
	private int hash (String chave, int numeroColisoes) {
		byte bytesChave[] = chave.getBytes();
		int hashCode = 0;
		for (int i : bytesChave) {
			hashCode += i;
		}
		return hashCode + numeroColisoes % tamArray;
	}
	
	public void inserir (String chave,  String valor) {
		int indiceArray = hash(chave);
		if (array[indiceArray] == null) {
			array[indiceArray] = new Nodo(chave, valor);
			return;
		}
		if (array[indiceArray].getChave() == chave) {
			array[indiceArray].setValor(valor);
			return;
		}
		
		int numeroColisoes = 1;
		int novoIndice = 0;
		while (array[indiceArray].getChave() == chave) {
			novoIndice = hash(chave,numeroColisoes);
			if (array[novoIndice] == null) {
				array[novoIndice] = new Nodo(chave, valor);
				return;
			}
			
			if (array[novoIndice].getChave() == chave) {
				array[novoIndice].setValor(valor);
				return;
			}
			numeroColisoes += 1;
			indiceArray = novoIndice; 
	}
	
	}
	
	public String recuperar(String chave) {
		int indiceArray = hash(chave);
		if (array[indiceArray] == null) {
			return "chave nao esta na tabela"; 
		}
		if (array[indiceArray].getChave() == chave) {
			return array[indiceArray].getValor();
		}
		int numeroColisoes = 1;
		while (array[indiceArray].getChave() != chave) {
			int novoIndice = hash(chave, numeroColisoes);
			if (array[novoIndice] == null) {
				return "chave nao esta na tabela";
			}
			if (array[novoIndice].getChave() == chave) {
				return array[novoIndice].getValor();
			}
			numeroColisoes +=1;
			indiceArray = novoIndice;
		}
		return "";
	}
}
