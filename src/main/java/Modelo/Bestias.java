/*
 * 
 */
package Modelo;

import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Bestias. Extends "Ejercito", se defirenciara El ejercito de Bestias y Heroes.
 *De esta class se extendera a class hijo, que seran los tipos de Bestias
 */
public abstract class Bestias extends Ejercito {
	
	/**
	 * Instantiates a new bestias. Contructor Bestias
	 *
	 * @param nombre the nombre. Recibe parametro tipo String.
	 * @param vida the vida. Recibe parametro tipo Integer.
	 * @param armadura the armadura. Recibe parametro tipo Integer.
	 * @param tipo the tipo. Recibe parametro estancia class Tipo_Personajes.
	 */
	protected Bestias(String nombre, Integer vida, Integer armadura, Tipo_Personajes tipo) {
		super(nombre, vida, armadura, tipo);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Atacar metodo.
	 *
	 * @param heroe the heroe. Parametro el Heroe que va ser atacado.
	 * @return the int. Devuelve daño realizado.
	 */
	public int atacar(Heroes heroe) {
		// El ataque será el mejor lanzamiento entre 0 a 100
		Random dado = new Random();
		int dado1 = dado.nextInt(101);	
		System.out.println("Dado de " + nombre + ": " + dado1);
		return dado1;
	}
	
	
	/**
	 * Vida metodo, vida de la Bestia y si ha sido eliminada.
	 *
	 * @param bestias the bestias. Parametro indica la Bestia.
	 * @return true, if successful. Devuelve la vida de la Bestia.
	 */
	public boolean vida( List<Bestias> bestias) {
		boolean vidaBestia = getVida() <= 0;
		if(vidaBestia == false) {
			System.out.println(getNombre() + " ha sido eliminado ");
		}
		return vidaBestia;
	}
	
	
	/**
	 * Recibir ataque metodo.
	 *
	 * @param ataque the ataque. Parametro se indica el daño recibido.
	 */
	public void recibirAtaque(int ataque) {
		if (ataque > armadura) {
			vida -= ataque - armadura;
		}
		if (vida < 0) {
			vida = 0; //Para que no sean valores negativos
		}
	}	
}


