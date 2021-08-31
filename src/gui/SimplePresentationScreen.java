package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		//Guardo los datos del dia y la hora
		LocalDateTime ahora= LocalDateTime.now();
	    int año = ahora.getYear();
	    int mes = ahora.getMonthValue();
	    int dia = ahora.getDayOfMonth();
	    int hora = ahora.getHour();
	    int minutos = ahora.getMinute();
	    int segundos = ahora.getSecond();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		
		//Fecha y la hora
		JLabel fechaYhora = new JLabel("Esta ventana fue generada el "+dia+"/"+mes+"/"+año+" a las: "+hora+":"+minutos+":"+segundos+".");
		contentPane.add(fechaYhora, BorderLayout.SOUTH);
		
		//Foto
		JLabel foto = new JLabel();
		ImageIcon imagenIcon = new ImageIcon(this.getClass().getResource("/images/Yo.png"));
		foto.setIcon(imagenIcon);
		contentPane.add(foto, BorderLayout.EAST);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Informacion del alumno", null, tabInformation, "Muestra la informacion declarada por el alumno");
		contentPane.add(tabbedPane, BorderLayout.WEST);
		tabInformation.setLayout(new GridLayout(5, 5));
		
		//Creo las etiquetas
		JLabel lblLu = new JLabel("LU: ");
		JLabel lblApellido = new JLabel("Apellido: ");
		JLabel lblNombre = new JLabel("Nombre: ");
		JLabel lblEmail = new JLabel("E-mail: ");
		JLabel lblGitHub = new JLabel("github URL: ");
		
		//Creo los campos de texto
		JTextField txtLu = new JTextField(studentData.getId()+"");
		JTextField txtApellido = new JTextField(studentData.getLastName(), 32);
		JTextField txtNombre = new JTextField(studentData.getFirstName(), 32);
		JTextField txtEmail = new JTextField(studentData.getMail(), 32);
		JTextField txtGitHub = new JTextField(studentData.getGithubURL(), 30);
		
		//Agrego todo lo anteriormente creado al panel information
		tabInformation.add(lblLu);
		tabInformation.add(txtLu);
		tabInformation.add(lblApellido);
		tabInformation.add(txtApellido);
		tabInformation.add(lblNombre);
		tabInformation.add(txtNombre);
		tabInformation.add(lblEmail);
		tabInformation.add(txtEmail);
		tabInformation.add(lblGitHub);
		tabInformation.add(txtGitHub);		
	}
}
