package src.SwingGame;

import src.SwingTest;

import javax.swing.*;

public class SwingTestMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                SwingTest swingTester = new SwingTest();

                swingTester.setVisible(true);

            }

        });
    }
}
