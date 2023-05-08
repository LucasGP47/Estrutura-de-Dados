package tabelasHash;

public class TesteHash {

	public static void main(String[] args) {
		
		HashTable tabelaHash = new HashTable(10);

		tabelaHash.inserir("012.345.647.99", "Joao da Silva");
		tabelaHash.inserir("839.564.343.21", "Joao da Silva");
		tabelaHash.inserir("475.485.123.71", "Joao da Silva");
		tabelaHash.inserir("400.289.922.00", "Luiz Silverio");
		
		System.out.println();
		
		
	}

}
