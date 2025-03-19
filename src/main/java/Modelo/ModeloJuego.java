/*
 * 
 */
package Modelo;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class ModeloJuego. Realiza la logica de los datos de la app y del almacenamiento y recuperacion de datos.
 */
@Getter
@Setter
public class ModeloJuego {
	
	/** The ejercito heroes. */
	private List<Heroes> ejercitoHeroes;
	
	/** The ejercito bestias. */
	private List<Bestias> ejercitoBestias;
	
	/**
	 * Instantiates a new modelo juego. Constructor
	 */
	public ModeloJuego() {
		this.ejercitoHeroes = new ArrayList<>();
		this.ejercitoBestias = new ArrayList<>();
	}
	
	///Metodos Heroes
	/**
	 * Agregar heroe metodo. Agregar un Heroe segun el "tipo" de personaje seleccionado.
	 *
	 * @param nombre the nombre. Recibe parametro tipo String.
	 * @param vida the vida. Recibe parametro tipo Integer.
	 * @param armadura the armadura. Recibe parametro tipo Integer.
	 * @param tipo the tipo. Recibe parametro estancia class Tipo_Personajes.
	 */
	public void agregarHeroe(String nombre, int vida, int armadura, String tipo) {
		switch (tipo) {
			case "Humano":
				ejercitoHeroes.add(new Humano(nombre, vida, armadura, Tipo_Personajes.HUMANO));
				break;
			case "Elfo":
				ejercitoHeroes.add(new Elfo(nombre, vida, armadura, Tipo_Personajes.ELFO));
				break;
			case "Hobbit":
				ejercitoHeroes.add(new Hobbit(nombre, vida, armadura, Tipo_Personajes.HOBBIT));
				break;
			case "Enano":
				ejercitoHeroes.add(new Enano(nombre, vida, armadura, Tipo_Personajes.ENANO));
				break;
			default:
				throw new IllegalArgumentException("Tipo de heroe no valido: " + tipo);
		}
	}
	
	/**
	 * Gets the ejercito heroes.
	 *
	 * @return the ejercito heroes
	 */
	public List<Heroes> getEjercitoHeroes() {
		return ejercitoHeroes;
	}
	
	/**
	 * Eliminar Heroe metodo.
	 *
	 * @param indice the indice
	 */
	public void eliminarHeroe(int indice) {
		if (indice >= 0 && indice < ejercitoHeroes.size()) {
			ejercitoHeroes.remove(indice);
		}
	}
	
	///Metodos Bestias
	/**
	 * Agregar bestia metodo.
	 *
	 * @param nombre the nombre. Recibe parametro tipo String.
	 * @param vida the vida. Recibe parametro tipo Integer.
	 * @param armadura the armadura. Recibe parametro tipo Integer.
	 * @param tipo the tipo. Recibe parametro estancia class Tipo_Personajes.
	 */
	//Metodos para agregar un Bestia segun el "tipo" de personaje seleccionado
	public void agregarBestia(String nombre, int vida, int armadura, String tipo) {
		switch (tipo) {
			case "Orco":
				ejercitoBestias.add(new Orco(nombre, vida, armadura, Tipo_Personajes.ORCO));
				break;
			case "Trasgo":
				ejercitoBestias.add(new Trasgo(nombre, vida, armadura, Tipo_Personajes.TRASGO));
				break;
			case "Troll":
				ejercitoBestias.add(new Troll(nombre, vida, armadura, Tipo_Personajes.TROLL));
				break;
			default:
				throw new IllegalArgumentException("Tipo de bestia no valido: " + tipo);
		}
	}
	
	/**
	 * Gets the ejercito bestias.
	 *
	 * @return the ejercito bestias
	 */
	public List<Bestias> getEjercitoBestias() {
		return ejercitoBestias;
	}
	
	/**
	 * Eliminar Bestia metodo.
	 *
	 * @param indice the indice
	 */
	public void eliminarBestia(int indice) {
		if (indice >= 0 && indice < ejercitoBestias.size()) {
			ejercitoBestias.remove(indice);
		}
	}
	
	
	/**
	 * Hay heroes metodo.
	 *
	 * @return true, if successful
	 */
	//Metodos de ejercitos
	public boolean hayHeroes() {
		return !ejercitoHeroes.isEmpty();
	}
	
	/**
	 * Hay bestias metodo.
	 *
	 * @return true, if successful
	 */
	public boolean hayBestias() {
		return !ejercitoBestias.isEmpty();
	}
	
	/**
	 * Limpiar ejercitos metodo. Borra el contenido de los Ejercitos.
	 */
	public void limpiarEjercitos() {
		ejercitoHeroes.clear();
		ejercitoBestias.clear();
	}
}
