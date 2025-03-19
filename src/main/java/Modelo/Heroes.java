/*
 * 
 */
package Modelo;

import java.util.List;
import java.util.Random;

import Vista.*;


// TODO: Auto-generated Javadoc
/**
 * The Class Heroes. Extends "Ejercito", se defirenciara El ejercito de Bestias y Heroes.
 *De esta class se extendera a class hijo, que seran los tipos de Heroes
 */
public abstract class Heroes extends Ejercito {
	
	/**
	 * Instantiates a new heroes.
	 *
	 * @param nombre the nombre. Recibe parametro tipo String.
	 * @param vida the vida. Recibe parametro tipo Integer.
	 * @param armadura the armadura. Recibe parametro tipo Integer.
	 * @param tipo the tipo. Recibe el parametro estancia class Tipo_Personajes
	 */
	//constructor
	protected Heroes(String nombre, Integer vida, Integer armadura, Tipo_Personajes tipo) {
		super(nombre, vida, armadura, tipo);
	}
	
	
	/**
	 * Atacar.
	 *
	 * @param bestia the bestia. Parametro la Bestia que va ser atacado.
	 * @return the int. Devuelve daño realizado.
	 */
	public int atacar(Bestias bestia) {
		// El ataque será el mejor lanzamiento entre dos dados de 0 a 100
		Random dado = new Random();
		int dado1 = dado.nextInt(101);
		int dado2 = dado.nextInt(101);
		System.out.println("Primer dado de " + nombre + ": " + dado1);
		System.out.println("Segundo dado de " + nombre + ": " + dado2);
		return Math.max(dado1, dado2);
	}
	
	
	/**
	 * Vida metodo. vida de la Heroe y si ha sido eliminada.
	 *
	 * @param heroes the heroes. Parametro indica la Heroe.
	 * @return true, if successful. Devuelve la vida de la Heroe.
	 */
	//metodo vida del Heroe y si ha sido eliminado
	public boolean vida( List<Heroes> heroes) { 
		boolean vidaHeroe = getVida() <= 0;
		if (vidaHeroe == false) {
		System.out.println( getNombre() + " ha sido eliminado");
		}
		return vidaHeroe;
	}
	
	
	//metodo recibir daño
	/**
	 * Recibir ataque metodo.
	 *
	 * @param ataque the ataque. Parametro se indica el daño recibido.
	 */
	//1º codigo
	public void recibirAtaque(int ataque) {
		if (ataque > armadura) {
			vida -= ataque - armadura;
		}
		if (vida < 0) {
			vida = 0; //Para que no sean valores negativos
		}
	}


}
