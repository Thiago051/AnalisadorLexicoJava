package pacote;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
			THIAGO GABRIEL
*/

public class AnaliseLexica {
	
	// verifica se contem o simbolo na "tabela", retorna true se contem, reorna false caso contrario
	public static boolean verificaTabela(String simbolo) {
		
		// Tabela lexica
		String[] tabela = {"","Program","Pgrau",";","Var", "Y",",","x",":","real","Const","A","=",
							"2","B","3", "(",")","y",":=","a" ,"*" ,"+","b", "Write", "End", ".",
							"Begin", "Read"};
		
		for(String i : tabela) {
			if(i.equals(simbolo))
				return true; // contem
		}
		return false; // nao contem
			
	}

	// lê o arquivo, o separa em linhas, separa as linhas em um vetor de strings, e procura por erros no vetor
	public static void lerArquivo(String caminho) throws IOException {
				
				
				BufferedReader bf = new BufferedReader(new FileReader(caminho)); // objeto para leitura do arquivo
				String linha = ""; // variavel que recebera uma linha em cada iteração

				List<String> linhasArquivo = new ArrayList<String>(); // lista para armazenar as linhas do arquivo
				
				// lendo o arquivo e adicionando cada linha na lista de linhas
				while (linha != null) {
					linha = bf.readLine(); // lendo cada linha
					if (linha != null)
						linhasArquivo.add(linha); // adicionando cada linha na lista
				}
				bf.close(); // fecha o objeto de leitura do arquivo

		boolean erro = false; // variavel para verificar erro
		
		/* percorre as linhas do arquivo e as quebra cada vez que encontrar um espaço, salva as linhas 
		   quebradas num vetor e verifica sua existencia na "tabela" lexica */
		for (int numLinha = 0; numLinha < linhasArquivo.size(); numLinha++) {
			String[] coluna = linhasArquivo.get(numLinha).split(" "); // quebra as linhas quando encontra um espaço

			int numColuna = 0; // variavel para encontrar a posição do erro
			for (String simbolo : coluna) {
				numColuna++;
				
				// printa a posição do erro, se houver 
				if (!verificaTabela(simbolo)) {
					System.err.println("Erro na linha " + (numLinha + 1) + ", coluna " + numColuna);
					erro = true;
					break;
				}
			}
		}
		// se não foi encontrado nenhum erro
		if (!erro) {
			System.out.println("Analise Lexica Concluida, Programa Aprovado!!");
		}

	}

}