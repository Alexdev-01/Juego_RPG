/*
 * 
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import Modelo.Bestias;
import Modelo.Ejercito;
import Modelo.Elfo;
import Modelo.Heroes;
import Modelo.Hobbit;
import Modelo.Humano;
import Modelo.ModeloJuego;
import Modelo.Tipo_Personajes;
import Vista.VistaJuego;

// TODO: Auto-generated Javadoc
/**
 * The Class ControladorJuego. Contiene la logica de la app, Actua como interfaz entre la VistaJuego y ModeloJuego
 */
public class ControladorJuego implements ActionListener {	
	
	/** The vista. */
	private VistaJuego vista;
	
	/** The modelo. */
	private ModeloJuego modelo;
	
	/**
	 * Instantiates a new controlador juego. Constructor MVC
	 *
	 * @param vista the vista, recibe instancia de vista
	 * @param modelo the modelo, recibe instancia de modelo
	 */
	public ControladorJuego(VistaJuego vista, ModeloJuego modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		
		AbstractButton botones[] = vista.getBotones();	//dame todos los botones del Array "botones"
		System.out.println(botones.length);
		for (int i = 0; i < botones.length; i++) {
			System.out.println(i + "-" + botones[i]);
			((JButton)(botones[i])).addActionListener(this);	//addActionListener es el q va gestionar los eventos, porque implement "ActionListener"
		}
	}
	
	/**
	 * Instantiates a new controlador juego. Constructor con vista
	 *
	 * @param vista the vista, recibe la instancia de vista
	 */
	public ControladorJuego(VistaJuego vista) {
		super();
		this.vista = vista;
		this.modelo = new ModeloJuego();
		
		AbstractButton botones[] = vista.getBotones();	//dame todos los botones del Array "botones"
		System.out.println(botones.length);
		for (int i = 0; i < botones.length; i++) {
			System.out.println(i + "-" + botones[i]);
			((JButton)(botones[i])).addActionListener(this);	//addActionListener es el q va gestionar los eventos, porque implement "ActionListener"
		}
	}
	
	
	/**
	 * ACCIONES DE LOS BOTONES. Segun la accion recibida y que corresponda con un Button, se ejecutara una metodo
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {			
		if (e.getSource() == vista.getBtnAddHeroe()) {
			addHeroe();
			System.out.println("Creado Heroe");
			
		} else if (e.getSource() == vista.getBtnAddBestia()) {
			addBestia();
			System.out.println("Creado Bestia");
			
		} else if (e.getSource() == vista.getBtnBajarHe()) {
			downHeroe();
			
		} else if (e.getSource() == vista.getBtnBajarBe()) {
			downBestia();
			
		} else if (e.getSource() == vista.getBtnEliminarHe()) {
			deleterHeroe();
			
		} else if (e.getSource() == vista.getBtnEliminarBe()) {
			deleterBestia();
			
		} else if (e.getSource() == vista.getBtnSubirHe()) {
			upHeroe();
			
		} else if (e.getSource() == vista.getBtnSubirBe()) {
			upBestia();
			
		} else if (e.getSource() == vista.getBtnLuchar()) {
			inicarBatalla();
			
		}	
	}
	
	/**
	 * Anadir Heroe.
	 */
	public void addHeroe() {
		String nombre = vista.getTxtNombreHe().getText();
		int vida = Integer.parseInt(vista.getTxtVidaHe().getText());
		int armadura = Integer.parseInt(vista.getTxtArmaduraHe().getText());
		String tipo = (String) vista.getTipoHeroe().getSelectedItem();
		
		modelo.agregarHeroe(nombre, vida, armadura, tipo);
		actualizarListaHeroes();
	}
	
	/**
	 * Anadir Bestia.
	 */
	public void addBestia() {
		String nombre = vista.getTxtNombreBe().getText();
		int vida = Integer.parseInt(vista.getTxtVidaBe().getText());
		int armadura = Integer.parseInt(vista.getTxtArmaduraBe().getText());
		String tipo = (String) vista.getTipoBestia().getSelectedItem();
		
		modelo.agregarBestia(nombre, vida, armadura, tipo);
		actualizarListaBestias();
	}
	
	/**
	 * Iniciar Batalla.
	 */
	public void inicarBatalla() {
		vista.getInfoArea().setText("");  //limpia el cuatro "InfoArea"
		
		//SwingWorker para crear un hilo en segundo plano
		SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
			
			//doInBackground() utilzia para evitar el bloqueo de subproceso en segundo plano
			@Override
			protected Void doInBackground() throws Exception {
				
				RegistroBatalla registro = new RegistroBatalla() {
					
					@Override
					public void linea(String mensaje) {
						publish(mensaje);	//publish() envia los "mensajes" al process()
						try {
							Thread.sleep(200);	//le damos 200 miliseg, para q no sea tan rapido
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				};
			
			//Se ejecuta la Batalla entre los dos ejercitos
			Batalla.batalla(modelo.getEjercitoHeroes(), modelo.getEjercitoBestias());
			return null;
			}
			
			
			//Recibe los mensajes y los añades en el "InfoArea"
			@Override
			protected void process(List<String> chunks) {
				for (String mensaje : chunks) {
					vista.getInfoArea().append(mensaje + "\n");
				}
				
				actualizarListaHeroes();
				actualizarListaBestias();
			}
		};
		
		worker.execute();	
	}
	
	/**
	 * Actualiza List Heroes.
	 */
	public void actualizarListaHeroes() {
		DefaultListModel<String> listaModelo = vista.getModeloListaHeroes();
		listaModelo.clear();
		for (Heroes heroe : modelo.getEjercitoHeroes()) {
			String nombre = heroe.getNombre();
			int vida = heroe.getVida();
			int armadura = heroe.getArmadura();
			Tipo_Personajes tipo = heroe.getTipo();
			
			String heroeFinal = nombre + " - " + tipo + " V: " + vida + " A: "  + armadura;
			
			listaModelo.addElement(heroeFinal);
		}
	}
	
	
	
	/**
	 * Actualiza List Bestias.
	 */
	public void actualizarListaBestias() {
		DefaultListModel<String> listaModelo = vista.getModeloListaBestias();
		listaModelo.clear();
		for (Bestias bestia : modelo.getEjercitoBestias()) {
			String nombre = bestia.getNombre();
			int vida = bestia.getVida();
			int armadura = bestia.getArmadura();
			Tipo_Personajes tipo = bestia.getTipo();
			
			String heroeFinal = nombre + " - " + tipo + " V: " + vida + " A: "  + armadura;
			
			listaModelo.addElement(heroeFinal);
			//listaModelo.addElement(heroe.getVida());
		}
	}
	
	/**
	 * Elimina Heroe.
	 */
	public void deleterHeroe() {
		int index = vista.getListaHeroes().getSelectedIndex();	//obtenemos posicion seleccionada
		Integer msnDeleteHe = JOptionPane.showConfirmDialog(vista, "Seguro que quieres eliminar el Heroe?", "Cuidado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		System.out.println(msnDeleteHe);
		
		switch (msnDeleteHe) {
		case 0:
			if (index >= 0) {
				modelo.eliminarHeroe(index);
				System.out.println("Heroe Eliminado");
				actualizarListaHeroes();
			}
			break;
		//case 1:
			//System.out.println("Eliminacion cancelada");
			//break;
		default:
			break;
		}
		
	}
	
	/**
	 * Sube Heroe Lista.
	 */
	public void upHeroe() {
		JList<String> listaHeroes = vista.getListaHeroes();
		int index = listaHeroes.getSelectedIndex();
		
		if (index > 0) {
			Collections.swap(modelo.getEjercitoHeroes(), index, index -1);	//Collections.swap() intercambia dos elemento de una List
			actualizarListaHeroes();
			listaHeroes.setSelectedIndex(index -1);	//seguir seleccionando el mismo elemento
		}
	}
	
	/**
	 * Baja Heroe Lista.
	 */
	public void downHeroe() {
		JList<String> listaHeroes = vista.getListaHeroes();
		int index = listaHeroes.getSelectedIndex();
		
		if (index >= 0 && index < modelo.getEjercitoHeroes().size() -1) {	//se indica hasta el ultimo elemento de la List para que no de fallo
			Collections.swap(modelo.getEjercitoHeroes(), index, index + 1); //Collections.swap() intercambia dos elemento de una List
			actualizarListaHeroes();
			listaHeroes.setSelectedIndex(index + 1);	//seguir seleccionando el mismo elemento
		}
	}
	
	/**
	 * Elimina Bestia.
	 */
	public void deleterBestia() {
		int index = vista.getListaBestias().getSelectedIndex();	//obtenemos posicion seleccionada
		Integer msnDeleteBe = JOptionPane.showConfirmDialog(vista, "Seguro que quieres eliminar la Bestia?", "Cuidado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		System.out.println(msnDeleteBe);
		
		switch (msnDeleteBe) {
		case 0:
			if (index >= 0) {
				modelo.eliminarBestia(index);
				System.out.println("Bestia Eliminado");
				actualizarListaBestias();
			}
			break;
		//case 1:
			//System.out.println("Eliminacion cancelada");
			//break;
		default:
			break;
		}
		
	}
	
	/**
	 * Sube Bestia Lista.
	 */
	public void upBestia() {
		JList<String> listaBestias = vista.getListaBestias();
		int index = listaBestias.getSelectedIndex();
		
		if (index > 0) {
			Collections.swap(modelo.getEjercitoBestias(), index, index -1);	//Collections.swap() intercambia dos elemento de una List
			actualizarListaBestias();
			listaBestias.setSelectedIndex(index -1);	//seguir seleccionando el mismo elemento
		}
	}
	
	/**
	 * Baja Bestia Lista.
	 */
	public void downBestia() {
		JList<String> listaBestias = vista.getListaBestias();
		int index = listaBestias.getSelectedIndex();
		
		if (index >= 0 && index < modelo.getEjercitoBestias().size() -1) {	//se indica hasta el ultimo elemento de la List para que no de fallo
			Collections.swap(modelo.getEjercitoBestias(), index, index + 1); //Collections.swap() intercambia dos elemento de una List
			actualizarListaBestias();
			listaBestias.setSelectedIndex(index + 1);	//seguir seleccionando el mismo elemento
		}
	}
}

