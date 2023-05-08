package tabelasHash;

public class HashTable {
	
	private int tam_array;
	private String[] array;
	
	public HashTable(int tam_array) {
		this.tam_array = tam_array;
		array = new String[tam_array];
	}
	
	private int Hash(String chave) {
		byte bytesChave[] = chave.getBytes();
		int hashCode = 0;
		for (int i = 0; i < bytesChave.length; i++) {
			hashCode += bytesChave[i];
		}
		
		return hashCode % tam_array;
	}
	
	public void inserir(String chave, String valor) {
		int indiceArray = Hash(chave);
		array [indiceArray] = valor;
	}
	
	public String recuperar (String chave) {
		int indiceArray = Hash(chave);
		return array [indiceArray];
	}

}
