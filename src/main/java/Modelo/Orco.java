/*
 * 
 */
package Modelo;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Orco.
 */
public class Orco extends Bestias {

	/**
	 * Instantiates a new orco.
	 *
	 * @param nombre the nombre. Recibe parametro tipo String.
	 * @param vida the vida. Recibe parametro tipo Integer.
	 * @param armadura the armadura. Recibe parametro tipo Integer.
	 * @param tipo the tipo. Recibe el parametro estancia class Tipo_Personajes
	 */
	//Constructor
	public Orco(String nombre, Integer vida, Integer armadura, Tipo_Personajes tipo) {
		super(nombre, vida, armadura, tipo);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Atacar.
	 *
	 * @param heroe the heroe. es sobreescrito al metodo atacar() de "Bestias" cuando se enfrenta contra cualquier personaje.
	 * @return the int. Daño final que recibe el personaje que es atacado.
	 */
	@Override
	public int atacar(Heroes heroe) {
		
		int armaduraOriginal = heroe.getArmadura();
		
		//Reducir la armadura 10%
		int reduccionArmadura = (int) (armaduraOriginal * 0.1);
		int armaduraReducida = armaduraOriginal - reduccionArmadura;
		heroe.setArmadura(armaduraReducida);
		
		System.out.println("Fuerza desmesurada Orco, reduce la armadura del heroe " + heroe.getNombre() + " " + reduccionArmadura + " puntos.");
		
		//Daño realizado
		int fuerzaAtaque = this.lanzarDado();	//ataque el orco
		int danoFinal = Math.max(0 , fuerzaAtaque - heroe.getArmadura());	//Math.max(0, ...) para evitar numeros negativos
		heroe.setVida(heroe.getVida() - danoFinal);
		
		//Heroe recupera su armadura original
		heroe.setArmadura(armaduraOriginal);
		
		return danoFinal;
	}
	
	
	/**
	 * Lanzar dado metodo. Que sera usado en el metodo atacat()
	 *
	 * @return the int
	 */
	public int lanzarDado() {
		// El ataque será el mejor lanzamiento entre 0 a 100
		Random dado = new Random();
		int dado1 = dado.nextInt(101);	
		System.out.println("Dado de " + nombre + ": " + dado1);
		return dado1;
	}
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Orco [nombre=" + nombre + ", vida=" + vida + ", armadura=" + armadura + " tipo=" + tipo + "]";
	}
}
