import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class Lvl1Login extends JFrame{

    private JPasswordField  input; 
    private String      password; 
    private JButton     goBtn;
    private JButton     returnBtn;
    private JPanel      verify;
    private JPanel      pane;
    private JLabel      prompt;
    Color lpink = (new  Color(250, 200, 250));
    Color dblue = (new  Color(10, 10, 15));
    Color dpink = (new  Color(255, 30, 75));

    Lvl1Login(){
        password = "lvl1";
        setTitle("Level 1");
        verify = new JPanel();
        pane = new JPanel();
        prompt = new JLabel("Enter the Level 1 Password:");
        prompt.setForeground(Color.WHITE);
        pane.add(prompt); 


        pane.setBackground(dblue);
        verify.setBackground(dblue);


        pane.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        input = new JPasswordField();
        
        input.setEchoChar('*');
        pane.add(input);
        pane.setLayout(new GridLayout(3,1));

        goBtn  = new JButton("Enter");
        returnBtn = new JButton("Return");

        goBtn.setBackground(lpink);
        returnBtn.setBackground(lpink);

        verify.add(goBtn);
        verify.add(returnBtn);

        goBtn.addActionListener(new passwordButtonListener());
        returnBtn.addActionListener(new returnButtonListener());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setUndecorated(true);
        add(pane, BorderLayout.CENTER);
        add(verify, BorderLayout.SOUTH);
        pack();
        setResizable(false);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    private class passwordButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            if (String.valueOf(input.getPassword()).equals(password)){
                MainMenu.createAndShowGUI();
                setVisible(false);
            }else{
                prompt.setText("Incorrect Password.");
                pane.remove(input);
                pane.add(input);
            }
        }
    }

    private class returnButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            new EntryScreen();
            setVisible(false);
        }
    }
}
