package bmsgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame {

    JPanel pnlTop = new JPanel();
    JPanel pnlMain = new JPanel();
    JPanel pnlBottom = new JPanel();
    JLabel lblWelcome = new JLabel("Welcome to the AOS bank!");
    JLabel lblUsername = new JLabel("Username:");
    JLabel lblPassword = new JLabel("Password:");
    JLabel lblCreateProfile = new JLabel("Don't have a profile? Sign up ..");
    JLabel lblRecoverProfile = new JLabel("Don't remember password? Recover ..");
    JTextField txtUsername = new JTextField();
    JTextField txtPassword = new JTextField();
    JButton btnCreateProfile = new JButton("Create Profile");
    JButton btnRecoverProfile = new JButton("Recover Profile");
    
    public Home(){
        
        setTitle("AOS Bank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(d.width/4,d.height/4,d.width/2,d.height/2);
        
        Container c = getContentPane();
        
        pnlMain.setPreferredSize(new Dimension(d.width/2,d.height/4));
        pnlTop.setPreferredSize(new Dimension(d.width/2,d.height/8));
        pnlBottom.setPreferredSize(new Dimension(d.width/2,d.height/8));
        
        pnlTop.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        pnlTop.add(lblWelcome);
        
        lblUsername.setPreferredSize(new Dimension(300,30));
        lblPassword.setPreferredSize(new Dimension(300,30));
        txtUsername.setPreferredSize(new Dimension(300,30));
        txtPassword.setPreferredSize(new Dimension(300,30));
        pnlMain.add(lblUsername);
        pnlMain.add(txtUsername);
        pnlMain.add(lblPassword);
        pnlMain.add(txtPassword);
        
        lblCreateProfile.setPreferredSize(new Dimension(300,30));
        lblRecoverProfile.setPreferredSize(new Dimension(300,30));
        btnCreateProfile.setPreferredSize(new Dimension(150,30));
        btnRecoverProfile.setPreferredSize(new Dimension(150,30));
        pnlBottom.add(lblCreateProfile);
        pnlBottom.add(btnCreateProfile);
        pnlBottom.add(lblRecoverProfile);
        pnlBottom.add(btnRecoverProfile);
        
        c.add(pnlTop,BorderLayout.NORTH);
        c.add(pnlBottom, BorderLayout.SOUTH);
        c.add(pnlMain);
    }
}
