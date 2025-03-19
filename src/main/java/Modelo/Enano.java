/*
 * 
 */
package Modelo;

// TODO: Auto-generated Javadoc
/**
 * The Class Enano.
 */
public class Enano extends Heroes {

	/**
	 * Instantiates a new enano.
	 *
	 * @param nombre the nombre. Recibe parametro tipo String.
	 * @param vida the vida. Recibe parametro tipo Integer.
	 * @param armadura the armadura. Recibe parametro tipo Integer.
	 * @param tipo the tipo. Recibe el parametro estancia class Tipo_Personajes
	 */
	protected Enano(String nombre, Integer vida, Integer armadura, Tipo_Personajes tipo) {
		super(nombre, vida, armadura, tipo);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Enano [nombre=" + nombre + ", vida=" + vida + ", armadura=" + armadura + ", tipo=" + tipo + "]";
	}
}
