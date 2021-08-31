package launcher;
import gui.*;
import entities.*;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student julian = new Student(121968, "Coscia", "Julian", "juliancoscia@hotmail.com", "https://github.com/JulianCoscia", "/images/Yo.png");
            	SimplePresentationScreen frame = new SimplePresentationScreen(julian);
            	frame.setVisible(true);
            }
        });
    }
}