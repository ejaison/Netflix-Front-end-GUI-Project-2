//Eric
//Netflix GUI 
//Java 
//Dr. Doderer
//Oct 18, 2022

package guiIntro;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MainFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Netflix Shows");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);
		MainFramePanel panel = new MainFramePanel();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);

	}
}

