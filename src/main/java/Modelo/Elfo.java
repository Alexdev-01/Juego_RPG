/*
 * 
 */
package Modelo;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Elfo. extends Heroes
 */
public class Elfo extends Heroes {
	
	/**
	 * Instantiates a new elfo. Constructor
	 *
	 * @param nombre the nombre. Recibe parametro tipo String.
	 * @param vida the vida. Recibe parametro tipo Integer.
	 * @param armadura the armadura. Recibe parametro tipo Integer.
	 * @param tipo the tipo. Recibe el parametro estancia class Tipo_Personajes
	 */
	public Elfo(String nombre, Integer vida, Integer armadura, Tipo_Personajes tipo) {
		super(nombre, vida, armadura, tipo);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Atacar metodo. es sobreescrito al metodo atacar() de "Heroes" cuando se enfrenta contra un Orco.
	 * Los Elfos tiene una ventaja de +10 de ataque, cuando se enfrentan contra los Orcos.
	 *
	 * @param bestia the bestia
	 * @return the int. el daño causado al ORCO que ataca.
	 */
	@Override
	public int atacar(Bestias bestia) {
		if (bestia.getTipo() == Tipo_Personajes.ORCO) {
			System.out.println("Ventaja por odio a los Orcos");
			int extra = 10;			
			return super.atacar(bestia) + extra;
		}
		return super.atacar(bestia);
	}
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Elfo [nombre=" + nombre + ", vida=" + vida + ", armadura=" + armadura + " tipo=" + tipo + "]";
	}
	
	
}


