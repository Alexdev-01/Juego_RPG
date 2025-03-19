/*
 * 
 */
import Controlador.ControladorJuego;
import Modelo.ModeloJuego;
import Vista.VistaJuego;

// TODO: Auto-generated Javadoc
/**
 * The Class Juego. Aqui se ejecuta el juego en entorno grafico.
 */
public class Juego {
	
	/**
	 * The main method.
	 *
	 * @param arg the arguments
	 */
	public static void main(String[] arg) {
		
	VistaJuego vista = new VistaJuego();
	ModeloJuego modelo = new ModeloJuego();
	ControladorJuego controlador = new ControladorJuego(vista,modelo);
	//ControladorJuego controlador = new ControladorJuego(vista);
	
    vista.getInfoArea().setText("");

	vista.setVisible(true);
	}
}
