/*
 * 
 */
import java.util.ArrayList;
import java.util.List;

import Controlador.Batalla;
import Modelo.Bestias;
import Modelo.Elfo;
import Modelo.Heroes;
import Modelo.Hobbit;
import Modelo.Humano;
import Modelo.Orco;
import Modelo.Tipo_Personajes;
import Modelo.Trasgo;

// TODO: Auto-generated Javadoc
/**
 * The Class Main. Aqui se ejecuta el juego en modod consola.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		//Elfo elfo = new Elfo("Legolas",100,50);
		//Elfo elfo2 = new Heroes.Elfo();
		
		List<Heroes> ejercitoHeroes = new ArrayList<>();
		List<Bestias> ejercitoBestoas = new ArrayList<>();
		
		
		ejercitoHeroes.add(new Elfo("Legolas", 150, 30, Tipo_Personajes.ELFO));
		ejercitoHeroes.add(new Humano("Aragorn", 150, 50, Tipo_Personajes.HUMANO));
		ejercitoHeroes.add(new Humano("Boromir", 100, 60, Tipo_Personajes.HUMANO));
		ejercitoHeroes.add(new Humano("Gandalf", 300, 30, Tipo_Personajes.HUMANO));
		ejercitoHeroes.add(new Hobbit("Frodo", 20, 10, Tipo_Personajes.HOBBIT));
		
		ejercitoBestoas.add(new Orco("Lurtz", 200, 60, Tipo_Personajes.ORCO));
		ejercitoBestoas.add(new Orco("Shagrat", 220, 50, Tipo_Personajes.ORCO));
		ejercitoBestoas.add(new Trasgo("Ugluk", 120, 30, Tipo_Personajes.TRASGO));
		ejercitoBestoas.add(new Trasgo("Mauhur", 100, 30, Tipo_Personajes.TRASGO));

			
		System.out.println(ejercitoHeroes);
		System.out.println(ejercitoBestoas);
		
		
		Batalla.batalla(ejercitoHeroes, ejercitoBestoas);
		
		
		
	}

}
