package src;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest extends JFrame {
    private JPanel contentPane;
    private JTextField GuessArea;
    private JTextArea gameArea;
    private JButton guessButton;



    public SwingTest(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessClick();
            }
        });

    }



    private void guessClick() {
        System.out.println("Guess Clicked");
    }

}


