package tabelasHash;

public class ListaEncadeada {
	private Nodo inicio;
	
	public ListaEncadeada(String chave, String valor) {
		inicio = new Nodo(chave,valor);
	}
	
	public void inserirFinal(String chave, String valor) {
		Nodo novo = new Nodo(chave, valor);
		Nodo aux = inicio;
		while (aux.getProx() == null) {
			aux = aux.getProx();
		}
		aux.setProx(novo);
	}
	
	public Nodo getInicio() {
		return inicio;
	}

}
