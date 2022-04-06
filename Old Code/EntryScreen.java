import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import javax.sound.sampled.*;
// import javax.sound.sampled.AudioInputStream;
// import javax.sound.sampled.Clip;
// import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
// import java.awt.Insets;
// import java.awt.BorderLayout;

import java.awt.GridBagLayout;  
import java.awt.GridBagConstraints;  



public class EntryScreen extends JFrame{


    private static final long serialVersionUID = 1L;
    private JButton lvl1button;
    private JButton lvl2button;
    private JButton exitbutton;
    
    private JPanel pnlCover;
    private JPanel pnlButtons;

    private JFrame frame;
    
    // private JLabel imageLabel;
    private int top = 1, left = 1, bottom = 1, right = 1;
    //private TheMainMenu thisMainU;
    //private EntryScreen enter;

    public EntryScreen(){
        Color lpink = (new  Color(250, 200, 250));
        Color dblue = (new  Color(10, 10, 15));
        Color dpink = (new  Color(255, 30, 75));
        
        
        sfx("sfx/magic.wav");
        setTitle("Login");
        ///defining the layout initially
        setLayout(new GridLayout(2,1));
        setSize(1000,1000);

        //creating panels and their colours 
        GridBagConstraints gbc = new GridBagConstraints(); 
        
        ///top half
        pnlCover = new JPanel();
        
        pnlCover.setBackground(dblue);
        

        JLabel title = new JLabel("", JLabel.SOUTH_EAST);
        pnlCover.add(title, BorderLayout.NORTH); 

        ImageIcon logo = new ImageIcon("icons/logo.png");
        JLabel label = new JLabel("", logo, JLabel.NORTH_EAST);
        pnlCover.add(label, BorderLayout.NORTH); 
        pnlCover.setBorder(new EmptyBorder(new Insets(20, 100, 0, 100)));
        

        ///bottom half
        pnlButtons = new JPanel();
        pnlButtons.setLayout(new GridBagLayout()); 
        pnlButtons.setBackground(dblue); 
        pnlButtons.setBorder(new EmptyBorder(new Insets(10, 100, 10, 100)));  //Move around buttons ///[t l b r] border?
        
        
        //Create Buttons
        // gbc.weightx=1; //c.weightx=0.0;
        gbc.weighty=0.25; ///button spacing
        gbc.gridx = 0;  ///sets button positions
        gbc.gridy = 0; 
        gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.gridwidth = 2;  
        gbc.insets = new Insets(2, 20, 2, 20);///padding or gaps
        Icon level1icon = new ImageIcon("icons/lvl1.png");
        lvl1button = new JButton   ("  Level 1 User", level1icon);
        lvl1button.setSize(new Dimension(340, 100));
        lvl1button.addActionListener(new Lvl1ButtonListener());

        lvl1button.setFont(new Font("Arial", Font.BOLD, 32));///set button font
        lvl1button.setBackground(lpink);///set button bg colour
        lvl1button.setForeground(Color.black);///set button text colour
        pnlButtons.add(lvl1button, gbc);
        gbc.insets = new Insets(2, 20, 2, 20);///padding or gaps



        gbc.weighty=0.25; ///button spacing
        gbc.gridx = 1;  
        gbc.gridy = 1;  
        gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.gridwidth = 2;  
        Icon level2icon = new ImageIcon("icons/lvl2.png");
        lvl2button = new JButton   ("  Level 2 User", level2icon);
        lvl2button.addActionListener(new Lvl2ButtonListener());
        // lvl2button.setSize(new Dimension(340, 100));
        
        lvl2button.setFont(new Font("Arial", Font.BOLD, 32));///set button font
        lvl2button.setBackground(lpink);///set button bg colour
        lvl2button.setForeground(Color.black);///set button text colour
        pnlButtons.add(lvl2button, gbc);


        
        gbc.weighty= 1;
        // gbc.insets = new Insets(top, left, bottom, right);
        gbc.insets = new Insets(10, left, 40, right);///padding or gaps

        gbc.gridx = 0; ///determines the horizontal position of exit button 
        gbc.gridy = 2; ///determines the vertical position of exit button  
        gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.gridwidth = 2; 
        Icon exiticon = new ImageIcon("icons/exit.png"); 
        exitbutton = new JButton   ("  Close Program", exiticon);
        exitbutton.addActionListener(new ExitButtonListener());

        exitbutton.setPreferredSize(new Dimension(400, 100)); ///set button size dimensions
        exitbutton.setFont(new Font("Arial", Font.BOLD, 32));///set button font
        exitbutton.setBackground(dpink);///set button bg colour
        exitbutton.setForeground(Color.white);///set button text colour
        pnlButtons.add(exitbutton, gbc);



        //frames
        add(pnlCover);
        add(pnlButtons); 
        // add(frame);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        pack();
        setResizable(false);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }


    public void setMenuOff(){
        this.dispose();
    }

    //plays audio
    public void sfx(String soundFile)
    {
        try 
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile).getAbsoluteFile( ));
            Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    }


    //opens admin login
    private class Lvl1ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        { 
            sfx("sfx/button.wav");
            new Lvl1Login();
            setVisible(false);
        }
    }

    private class Lvl2ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            sfx("sfx/button.wav");
            setVisible(false);
            new Lvl2Login();
        }
    }
  

    private class ExitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            sfx("sfx/button.wav");
            System.exit(0);
        }
    }
    public static void main(String []args) {
        new EntryScreen();
        
    }
}
