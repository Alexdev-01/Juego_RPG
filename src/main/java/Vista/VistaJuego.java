/*
 * 
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.PrintStream;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Controlador.ControladorJuego;
import Controlador.TextAreaOutputStream;

import java.io.PrintStream;

import Modelo.Tipo_Personajes;
//import controlador.ControladorCalculadora;
import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaJuego. Contiene todo lo la interfaz grafica. Representacion visual de los datos de cara al usurario.
 */
@Getter
@Setter
public class VistaJuego  extends JFrame {
	
	/** The txt armadura be. */
	/*txt resultado. añadir personajes*/
	private JTextField txtNombreHe, txtVidaHe, txtArmaduraHe, txtNombreBe, txtVidaBe, txtArmaduraBe;
	
	/** The btn luchar. */
	/*btn. acciones*/
	private JButton btnAddHeroe, btnAddBestia, btnSubirHe, btnBajarHe, btnEliminarHe, btnSubirBe, btnBajarBe, btnEliminarBe, btnLuchar;	//btnCentrado
	
	/** The tipo bestia. */
	/*btn. desplegable*/
	private JComboBox<String> tipoHeroe, tipoBestia;
	
	/** The botones.
	 * AbstractButton, para añadir todos los Button como un Array para darles funcionalidad*/
	private AbstractButton botones[];
	
	/** The panel inferior DOWN.
	 * panel operadores. paneles principales y paneles Heroes, Bestias, Button...*/
	private JPanel panelPrincipal, panelSuperior, panelInferior, panelInferiorUP, panelInferiorDOWN;
	
	/** The panel bestias contenido. */
	private JPanel panelHeroe, panelHeroeContenido, panelBestias, panelBestiasContenido;
	
	/** The botones bestias. */
	private JPanel panelTexto,panelBotones, botonesHeroe, botonesBestias;
	
	/** The text area bestias.
	 * Ventana Héroe y Bestia con barra desplazamiento*/
	private JTextArea textAreaHeroe,textAreaBestias;
	
	/** The scroll info. */
	private JScrollPane scrollHeroes,scrollBestias, scrollInfo;
	
	
	/** The info area.
	 * Ventana de información Batalla*/
	private JTextArea infoArea = new JTextArea("Información general.");    
	
	
	/** The modelo lista heroes.
	 * Modelo de List predeterminada para las List de los ejercitos*/
	private DefaultListModel<String> modeloListaHeroes;
	
	/** The modelo lista bestias. */
	private DefaultListModel<String> modeloListaBestias;
	
	
	/**
	 * Instantiancias de new VistaJuego. Contiene la interfaz grafica. Estan todos los componentes de la app, colocacion, estilos...
	 */
	public VistaJuego() {
		
		setSize(800, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/icono.png")).getImage());	//icono de la app
		setTitle("Batalla por la Tierra Media");
		setLocationRelativeTo(null);
		
		panelPrincipal = new JPanel(new BorderLayout());
		
		//Estilo "Nimbus" del las ventanas, botones, letras...
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		

////////*Ventana Superior y Dos ventanas en paralelo*/
		panelSuperior = new JPanel(new GridLayout(1, 2, 20, 10));

		//Primera ventana: Heroe
		panelHeroe = new JPanel(new BorderLayout());
		panelHeroe.setBorder(BorderFactory.createTitledBorder("Héroe"));
		panelHeroeContenido = new JPanel(new GridLayout(4, 2, 5, 10));	//4,2,30,10
		panelHeroeContenido.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));	//10,20,10,20
		
		//Componentes de la ventana Heroe
		panelHeroeContenido.add(new JLabel("Nombre:"));
		txtNombreHe = new JTextField();
		panelHeroeContenido.add(txtNombreHe);
		
		panelHeroeContenido.add(new JLabel("Tipo:"));
		tipoHeroe = new JComboBox<>(new String[]{"Elfo", "Humano", "Hobbit", "Enano"});
		panelHeroeContenido.add(tipoHeroe);
		
		panelHeroeContenido.add(new JLabel("Vida:"));
		txtVidaHe = new JTextField();
		panelHeroeContenido.add(txtVidaHe);
		
		panelHeroeContenido.add(new JLabel("Armadura:"));
		txtArmaduraHe = new JTextField();
		panelHeroeContenido.add(txtArmaduraHe);
		
		//Button añadir Heroe
		JPanel panelAnadirHe = new JPanel();
		btnAddHeroe = new JButton("Añadir Heroe");
		panelAnadirHe.add(btnAddHeroe);
		btnAddHeroe.setHorizontalAlignment(SwingConstants.CENTER);
		btnAddHeroe.setPreferredSize(new Dimension(120,30));
		
		panelHeroe.add(panelHeroeContenido, BorderLayout.CENTER);
		panelHeroe.add(panelAnadirHe, BorderLayout.SOUTH);
		
		//Segunda ventana: Bestias
		panelBestias = new JPanel(new BorderLayout());
		panelBestias.setBorder(BorderFactory.createTitledBorder("Bestia"));
		panelBestiasContenido = new JPanel(new GridLayout(4, 2, 5, 10));  //4,2,30,10
		panelBestiasContenido.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));	//10,20,10,20
		
		//Componentes de la ventana Bestias
		panelBestiasContenido.add(new JLabel("Nombre:"));
		txtNombreBe = new JTextField();
		panelBestiasContenido.add(txtNombreBe);
		
		panelBestiasContenido.add(new JLabel("Tipo:"));
		tipoBestia = new JComboBox<>(new String[]{"Orco", "Trasgo", "Troll"});
		panelBestiasContenido.add(tipoBestia);
		
		panelBestiasContenido.add(new JLabel("Vida:"));
		txtVidaBe = new JTextField();
		panelBestiasContenido.add(txtVidaBe);
		
		panelBestiasContenido.add(new JLabel("Armadura:"));
		txtArmaduraBe = new JTextField();
		panelBestiasContenido.add(txtArmaduraBe);
		
		//Button Añadir Bestia
		JPanel panelAnadirBe = new JPanel();
		btnAddBestia = new JButton("Añadir Bestias");
		panelAnadirBe.add(btnAddBestia);
		btnAddBestia.setHorizontalAlignment(SwingConstants.CENTER);
		btnAddBestia.setPreferredSize(new Dimension(120,30));
		
		panelBestias.add(panelBestiasContenido, BorderLayout.CENTER);
		panelBestias.add(panelAnadirBe, BorderLayout.SOUTH);
		
		//añade los dos paneles de crear personaje al "panelSuperiors"
		panelSuperior.add(panelHeroe);
		panelSuperior.add(panelBestias);
		
////////*Panel inferior*/
		panelInferior = new JPanel(new BorderLayout());
		
		panelInferiorUP = new JPanel(new BorderLayout());
		panelInferiorDOWN = new JPanel(new BorderLayout());
		
		//Subpanel con dos ventanas en paralelo
		panelTexto = new JPanel(new GridLayout(1, 2, 10, 10));
		
		modeloListaHeroes = new DefaultListModel<>();	//<String>
		modeloListaBestias = new DefaultListModel<>();	//<String>
		JList<String> jlistHeroes = new JList<>(modeloListaHeroes);	//<String>	
		JList<String> jlistBestias  = new JList<>(modeloListaBestias);	//<String>
		
		//Ventana Heroe con barra desplazamiento		
		scrollHeroes = new JScrollPane(jlistHeroes);
		scrollHeroes.setBorder(BorderFactory.createTitledBorder("Heroes"));
		scrollHeroes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollHeroes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		//Ventana Bestias con barra desplazamiento		
		scrollBestias = new JScrollPane(jlistBestias);
		scrollBestias.setBorder(BorderFactory.createTitledBorder("Bestias"));
		scrollBestias.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollBestias.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panelTexto.add(scrollHeroes);
		panelTexto.add(scrollBestias);
		
		/*Subpanel con botones*/
		panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
		
		//Button Heroe
		botonesHeroe = new JPanel(new FlowLayout());
		btnSubirHe = new JButton("Subir");
		btnSubirHe.setPreferredSize(new Dimension(120,30));
		btnBajarHe = new JButton("Bajar");
		btnBajarHe.setPreferredSize(new Dimension(120,30));
		btnEliminarHe = new JButton("Eliminar");
		btnEliminarHe.setPreferredSize(new Dimension(120,30));
		
		//Button Bestias
		botonesBestias = new JPanel(new FlowLayout());
		btnSubirBe = new JButton("Subir");
		btnSubirBe.setPreferredSize(new Dimension(120,30));
		btnBajarBe = new JButton("Bajar");
		btnBajarBe.setPreferredSize(new Dimension(120,30));
		btnEliminarBe = new JButton("Eliminar");
		btnEliminarBe.setPreferredSize(new Dimension(120,30));
		
		botonesHeroe.add(btnSubirHe);
		botonesHeroe.add(btnBajarHe);
		botonesHeroe.add(btnEliminarHe);
		botonesBestias.add(btnSubirBe);
		botonesBestias.add(btnBajarBe);
		botonesBestias.add(btnEliminarBe);
		
		panelBotones.add(botonesHeroe);
		panelBotones.add(botonesBestias);
		
		/*Ventana Info combate con barra desplazamiento*/
		scrollInfo = new JScrollPane(infoArea);
		infoArea.setVisible(true);
		scrollInfo.setBorder(BorderFactory.createTitledBorder("Combate"));
		scrollInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollInfo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		System.setOut(new PrintStream(new TextAreaOutputStream(infoArea)));
		
		
		/*Bottun Luchar*/
		JPanel panelLuchar = new JPanel();
		btnLuchar = new JButton("LUCHAR !!!");
		panelLuchar.add(btnLuchar);
		btnLuchar.setHorizontalAlignment(SwingConstants.CENTER);
		btnLuchar.setPreferredSize(new Dimension(150,30));
		
		
/////////*Add de los paneles*/
		panelInferiorUP.add(panelTexto, BorderLayout.NORTH);
		panelInferiorUP.add(panelBotones, BorderLayout.SOUTH);
		
		panelInferior.add(panelInferiorUP, BorderLayout.NORTH);
		panelInferior.add(scrollInfo, BorderLayout.CENTER);
		panelInferior.add(panelLuchar, BorderLayout.SOUTH);
		
		// Agregar paneles a la ventana principal
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		panelPrincipal.add(panelInferior, BorderLayout.CENTER);
		
		
		/*añadimos todos los botones al array "botones"*/
		botones=new AbstractButton[] {btnAddHeroe, btnAddBestia, btnSubirHe, btnBajarHe, btnEliminarHe, btnSubirBe, btnBajarBe, btnEliminarBe, btnLuchar};
		
		
		//Para ejecutar la ventan si tuviera MAIN esta class
		add(panelPrincipal);
		setVisible(true);
	};
	
	
	
	/**
	 * Sets de controlador. Metodo que envia las acciones de cada Button de la interfaz grafica
	 *
	 * @param controlador the new controlador
	 */
	public void setControlador(ControladorJuego controlador) {
		btnAddHeroe.addActionListener(controlador);
		btnAddBestia.addActionListener(controlador);
		btnBajarHe.addActionListener(controlador);
		btnBajarBe.addActionListener(controlador);
		btnEliminarHe.addActionListener(controlador);
		btnEliminarBe.addActionListener(controlador);
		btnSubirHe.addActionListener(controlador);
		btnSubirBe.addActionListener(controlador);
		btnLuchar.addActionListener(controlador);
	}
	 
	
	/**
	 * Gets the lista Heroe. Acceder JList Heroes.
	 *
	 * @return the lista heroes
	 */
	public JList<String> getListaHeroes() {
		return (JList<String>) scrollHeroes.getViewport().getView();
	}
	
	/**
	 * Gets the lista bestias. Acceder JList Heroes.
	 *
	 * @return the lista bestias
	 */
	public JList<String> getListaBestias() {
		return (JList<String>) scrollBestias.getViewport().getView();
	}
	
	/**
	 * Gets the info area. Mostrar datos en infoArea
	 *
	 * @return the info area
	 */
	public JTextArea getInfoArea() {
		return infoArea;
	}
	
	/**
	 * Sets the info area. 
	 *
	 * @param infoArea the new info area
	 */
	public void setInfoArea(JTextArea infoArea) {
		this.infoArea = infoArea;
		
	}
	
	/**
	 * Sets the info area.
	 *
	 * @param string the new info area
	 */
	public void setInfoArea(String string) {
		this.infoArea = infoArea;
		
	}

}
