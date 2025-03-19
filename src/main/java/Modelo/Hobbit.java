/*
 * 
 */
package Modelo;

// TODO: Auto-generated Javadoc
/**
 * The Class Hobbit.
 */
public class Hobbit extends Heroes {
	
	/**
	 * Instantiates a new hobbit.
	 *
	 * @param nombre the nombre. Recibe parametro tipo String.
	 * @param vida the vida. Recibe parametro tipo Integer.
	 * @param armadura the armadura. Recibe parametro tipo Integer.
	 * @param tipo the tipo. Recibe el parametro estancia class Tipo_Personajes
	 */
	public Hobbit(String nombre, Integer vida, Integer armadura, Tipo_Personajes tipo) {
		super(nombre, vida, armadura, tipo);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Atacar metodo. es sobreescrito al metodo atacar() de "Heroes" cuando se enfrenta contra un Trasgo.
	 * Los Hobbit tiene una desventaja de -10 de ataque, cuando se enfrentan conta los Trasgos.
	 *
	 * @param bestia the bestia
	 * @return the int. el daño causado al Trasgo que ataca.
	 */
	//Metodo atacar(), es modificado al metodo atacar() de "Heroes" cuando se enfrenta contra un Trasgo
	@Override
	public int atacar(Bestias bestia) {
		if (bestia.getTipo() == Tipo_Personajes.TRASGO) {
			System.out.println("Desventaja por miedo a los Trasgos");
			int extra = 10;			
			return super.atacar(bestia) - extra;
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
		return "Hobbit [nombre=" + nombre + ", vida=" + vida + ", armadura=" + armadura + ", tipo=" + tipo + "]";
	}
	
}