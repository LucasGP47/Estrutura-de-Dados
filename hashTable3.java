package tabelasHash;

public class hashTable3 {
	private int tamArray;
	private ListaEncadeada [] array;
	
	public hashTable3(int tamArray) {
		this.tamArray = tamArray;
		array = new ListaEncadeada[tamArray];
	}
	
	public int hash(String chave) {
		byte bytesChave[] = chave.getBytes();
		int hashCode = 0;
		for (int i: bytesChave) {
			hashCode += i;
		}
		return hashCode % tamArray;
	}
	
	public void inserir(String chave, String valor) {
		int indiceArray = hash(chave);
		if (array[indiceArray] == null) {
			array[indiceArray] = new ListaEncadeada(chave, valor);
			return;
		}
		
		Nodo aux = array[indiceArray].getInicio();
		while (aux != null){
			if (aux.getChave() == chave) {
				aux.setValor(valor);
				return;
			}
			
			aux = aux.getProx();
		}
		
		array[indiceArray].inserirFinal(chave, valor);
	}
	
	public String recuperar(String chave) {
		int indiceArray = hash(chave);
		if (array[indiceArray] == null) {
			return "chave nao esta na tabela";
		}
		Nodo aux = array[indiceArray].getInicio();
		while (aux != null) {
			if (aux.getChave() == chave) {
				return aux.getValor();
			}
			aux = aux.getProx();
		}
		return "chave nao esta na tabela";
		
	}

}
