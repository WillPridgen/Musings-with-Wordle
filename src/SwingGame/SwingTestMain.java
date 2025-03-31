package src.SwingGame;

import javax.swing.*;
import java.net.URL;

public class SwingTestMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                SwingTest swingTester = new SwingTest();

                //Swing window setup
                URL iconURL = getClass().getResource("health.jpg");
                ImageIcon icon = new ImageIcon(iconURL);
                swingTester.setTitle("Word Game");
                swingTester.setSize(500,300);
                swingTester.setIconImage(icon.getImage());
                swingTester.setVisible(true);

            }

        });
    }
}
