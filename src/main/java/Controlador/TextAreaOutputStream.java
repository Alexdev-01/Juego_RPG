/*
 * 
 */
package Controlador;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

// TODO: Auto-generated Javadoc
/**
 * The Class TextAreaOutputStream. Extiende de OutputStream, para poder trabajar con flujo E/S, con la ayuda del metodo write()
 */
public class TextAreaOutputStream extends OutputStream {
	
	/** The text area. */
	private final JTextArea textArea;
	
	/**
	 * Instantiates a new text area output stream. Contructor TextAreaOutputStream
	 *
	 * @param textArea the text area. Parametro es un JTextArea
	 */
	public TextAreaOutputStream(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	/**
	 * Write. Metodo que convierte el byte en caracter y lo añade al JTextArea
	 *
	 * @param b the b. Parametro que recibe tipo dato int
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	public void write(int b) throws IOException {
		//Convierte el byte en caracter y lo añade al JTextArea
		textArea.append(String.valueOf((char) b));
		//Desplaza el caret al final, para que se vea el último texto añadido
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
}


