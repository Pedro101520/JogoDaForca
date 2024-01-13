package tech.pedrolima.jogoDaForca;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Programa {
	
	static int numRandom(Random random, int num) {
		return random.nextInt(num);
	}
	
	static void plvr(String palavra) {
		int count = 0;
		char[] letrasDescobertas = new char[palavra.length()];
		int vidas = 3;
		String tentativa;
		
		while(count < palavra.length()) {
			boolean achou = false;
			char letras;
			Scanner input = new Scanner(System.in);
			
			letras = input.next().toLowerCase().charAt(0);
			for(int i = 0; i < palavra.length(); i++) {
				if(letras == palavra.charAt(i)) {
					letrasDescobertas[i] = letras;
					achou = true;
					count++;
				}
			}
			
			if(letras == '.') {
				tentativa = input.next().toLowerCase();
				if(tentativa.equals(palavra)) {
					System.out.println("Voce acertou ");
					break;
				}
				else {
					System.out.println("Voce errou");
					break;
				}
			}
			
			if(!achou) {
				vidas -= 1;
				System.out.println("Vidas restantes: " + vidas);
				if(vidas == 0) {
					System.out.println("Suas vidas acabaram");
					break;
				}
			}
			
			if(vidas > 0 && count == palavra.length()) {
				System.out.println("Voce descobriu a palavra");
			}
			System.out.println(letrasDescobertas);
		}
	}
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		char jogarNovamente;

		do {
			int pontuacao;
			ArrayList<String> palavras = new ArrayList<>();
			palavras.add("batata");
			palavras.add("computador");
			palavras.add("espinafre");
			palavras.add("faca");
			palavras.add("pipoca");
			palavras.add("filme");
			palavras.add("teclado");
			
			System.out.println("Voce tera 3 vidas");
			System.out.println("Para jogar, digite letras até ter certeza da qual é a palavra");
			System.out.println("Quando souber a palavra, digite . e informe a palavra");
			plvr(palavras.get(numRandom(random, 7)));
			
			System.out.println("Deseja jogar novamente? (S para Sim, qualquer outra tecla para sair)");
			jogarNovamente = input.next().charAt(0);

		} while (Character.toUpperCase(jogarNovamente) == 'S');
		
		System.out.println("Obrigado por jogar! Até mais!");
		
	}
}
