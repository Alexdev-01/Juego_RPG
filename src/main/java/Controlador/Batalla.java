/*
 * 
 */
package Controlador;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import javax.swing.SwingUtilities;

import Modelo.Bestias;
import Modelo.Heroes;
import Modelo.Tipo_Personajes;
import Vista.VistaJuego;
// TODO: Auto-generated Javadoc

/**
 *  The Class Batalla. Donde se desarrollara la batalla entre los dos ejercitos.
 */
public class Batalla {
	
	//metodo batalla
	/**
	 * Batalla. metodo donde se desarrolla todo la batalla
	 *
	 * @param heroes the heroes, recibira la List del ejercito Heroes
	 * @param bestias the bestias, recibira la List del ejercito Bestias
	 */
	public static void batalla(List<Heroes> heroes, List<Bestias> bestias) {
		int turno = 1;
		
		while (!heroes.isEmpty() && !bestias.isEmpty()) {	//comprueba si hay heroes y bestias
			System.out.println("Turno " + turno++);
			
			//calcular personajes para combatir
			int i = 0;
			while (i < Math.min(heroes.size(), bestias.size())) {
				Heroes heroe = heroes.get(i);
				Bestias bestia = bestias.get(i);
			
				System.out.println(heroe + " contra " + bestia);
				
				//ATAQUE MUTUOS
				int ataqueHeroe = heroe.atacar(bestia);
				int ataqueBestia = bestia.atacar(heroe);
				
				bestia.recibirAtaque(ataqueHeroe);
				heroe.recibirAtaque(ataqueBestia);
				
				//estado despues del comabe
				System.out.println("Heroe: " + heroe.getNombre() + " vida: " + heroe.getVida());
				System.out.println("Bestia: " + bestia.getNombre() + " vida: " + bestia.getVida());
				
				//Comprobar si estan muertos los personajes
				boolean heroeMuerto = heroe.estaMuerto();
				boolean bestiaMuerta = bestia.estaMuerto();
				
				//Si estan muertos notifican y eliminan personaje de su List
				if (heroeMuerto && bestiaMuerta) {
					System.out.println("El heroe " + heroe.getNombre() + " ha muerto.");
					System.out.println("La bestia " + bestia.getNombre() + " ha muerto.");
					heroes.remove(i);
					bestias.remove(i);
				} else if (bestiaMuerta) {
					System.out.println("La bestia " + bestia.getNombre() + " ha muerto.");
					bestias.remove(i);
				} else if (heroeMuerto) {
					System.out.println("El heroe " + heroe.getNombre() + " ha muerto.");
					heroes.remove(i);
				}
				
				//Se pasa al siguiente combate de la Lista si no han muerto
				if (!heroeMuerto && !bestiaMuerta) {
					i++;
				}	
			}
			
			//Recuento de los personajes despues de cada turno
			System.out.println("Estado de los ejercitos despues del turno:");
			System.out.println("Heroes restantes: " + heroes.size());
			System.out.println("Bestias restantes: " + bestias.size());
			System.out.println();
		}
		
		//Indica que ejercito a ganado
		if (heroes.isEmpty() && bestias.isEmpty()) {
			System.out.println("Las Bestias y los Heroes han perdido");
		} else if (bestias.isEmpty()) {
			System.out.println("Los Heroes han ganado la batalla");
		} else if (heroes.isEmpty()) {
			System.out.println("Las Bestias han ganado la batalla");
		}
	
	}	
	
}
