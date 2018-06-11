package br.com.sysmap.teste;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TesteTrackerLerDadosCSV {
	
	
	
	public  ArrayList<TesteTrackerUsuario> retornaUsuario() {
		
		ArrayList<TesteTrackerUsuario> usuarios = new ArrayList<TesteTrackerUsuario>();
		String[] dados;
		try {
			Scanner scanner = new Scanner(new File("/Users/guilherme.borges/Desktop/Automação de Testes Mobile/Dados para Eclipse/DadosAcesso.csv"));
			//scanner.useDelimiter(";");
			
			while(scanner.hasNext()) {
				dados = scanner.next().split(";");
				usuarios.add(new TesteTrackerUsuario(dados[0],dados[1]));
								
		}
			scanner.close();
			
			
		}
		catch(Exception ex) {
		System.out.println(ex.toString());	
		}
		return usuarios;
	}
}