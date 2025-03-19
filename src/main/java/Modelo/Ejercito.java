/*
 * 
 */
package Modelo;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class Ejercito. Class Principal, de la que extendera la class Bestias y class Heroes.
 * Aqui utilizaremos la libreria Lombok para los metodos get y set
 */
@Getter
@Setter
public class Ejercito {
	
	/** The nombre. */
	public String nombre;
	
	/** The vida. */
	public Integer vida;
	
	/** The armadura. */
	public Integer armadura;
	
	/** The tipo. */
	Tipo_Personajes tipo;
	
	
	/**
	 * Instantiates a new ejercito.
	 *
	 * @param nombre the nombre. Recibe parametro tipo String.
	 * @param vida the vida. Recibe parametro tipo Integer.
	 * @param armadura the armadura. Recibe parametro tipo Integer.
	 * @param tipo the tipo. Recibe el parametro estancia class Tipo_Personajes
	 */
	protected Ejercito(String nombre, Integer vida, Integer armadura, Tipo_Personajes tipo) {
		super();
		this.nombre = nombre;
		this.vida = vida;
		this.armadura = armadura;
		this.tipo = tipo;
	}


	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the vida.
	 *
	 * @return the vida
	 */
	public Integer getVida() {
		return vida;
	}
	
	/**
	 * Sets the vida.
	 *
	 * @param vida the new vida
	 */
	public void setVida(Integer vida) {
		this.vida = vida;
	}
	
	/**
	 * Gets the armadura.
	 *
	 * @return the armadura
	 */
	public Integer getArmadura() {
		return armadura;
	}
	
	/**
	 * Sets the armadura.
	 *
	 * @param armadura the new armadura
	 */
	public void setArmadura(Integer armadura) {
		this.armadura = armadura;
	}
	
	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public Tipo_Personajes getTipo() {
		return tipo;
	}
	
	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(Tipo_Personajes tipo) {
		this.tipo = tipo;
	}
	

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Ejercito [nombre=" + nombre + ", vida=" + vida + ", armadura=" + armadura + ", tipo=" + tipo + "]";
	}

	/**
	 * Esta muerto metodo. Comprueba que el personaje esta muerto
	 *
	 * @return true, if successful
	 */
	public boolean estaMuerto() {
		return vida <= 0;
	}
	
	

}