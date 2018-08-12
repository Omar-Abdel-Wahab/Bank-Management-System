package bmsgui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
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
    JButton btnLogin = new JButton("Login");
    JButton btnCreateProfile = new JButton("Create Profile");
    JButton btnRecoverProfile = new JButton("Recover Profile");
    String strLogin = "login.txt";

    public Home() {

        setTitle("AOS Bank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(d.width / 4, d.height / 4, d.width / 2, d.height / 2);

        Container c = getContentPane();

        pnlMain.setPreferredSize(new Dimension(d.width / 2, d.height / 4));
        pnlTop.setPreferredSize(new Dimension(d.width / 2, d.height / 8));
        pnlBottom.setPreferredSize(new Dimension(d.width / 2, d.height / 8));

        pnlTop.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        pnlTop.add(lblWelcome);

        lblUsername.setPreferredSize(new Dimension(300, 30));
        lblPassword.setPreferredSize(new Dimension(300, 50));
        txtUsername.setPreferredSize(new Dimension(300, 30));
        txtPassword.setPreferredSize(new Dimension(300, 30));
        btnLogin.setPreferredSize(new Dimension(150, 30));
        pnlMain.add(lblUsername);
        pnlMain.add(txtUsername);
        pnlMain.add(lblPassword);
        pnlMain.add(txtPassword);
        pnlMain.add(btnLogin);

        lblCreateProfile.setPreferredSize(new Dimension(300, 30));
        lblRecoverProfile.setPreferredSize(new Dimension(300, 30));
        btnCreateProfile.setPreferredSize(new Dimension(150, 30));
        btnRecoverProfile.setPreferredSize(new Dimension(150, 30));
        pnlBottom.add(lblCreateProfile);
        pnlBottom.add(btnCreateProfile);
        pnlBottom.add(lblRecoverProfile);
        pnlBottom.add(btnRecoverProfile);

        c.add(pnlTop, BorderLayout.NORTH);
        c.add(pnlBottom, BorderLayout.SOUTH);
        c.add(pnlMain);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String strUsername = txtUsername.getText();
                String strPassword = txtPassword.getText();
                
                try {    
                    FileReader file = new FileReader(strLogin);
                    BufferedReader read = new BufferedReader(file);
                    String input = read.readLine();
                    boolean success = false;
                   
                    while (input != null) {
                        if (input.contains(strUsername) && input.contains(strPassword)) {
                            JOptionPane.showMessageDialog(null,
                                    "Login Successful",
                                    "Login",
                                    JOptionPane.WARNING_MESSAGE);
                            success = true;

                            // Place your code Here !!
                            // Your code supposed to call the dashboard gui & extract...
                            // the profile data from the txt file named after the ...
                            // username.
                            break;
                        }
                        input = read.readLine();
                    }
                    if (!success) {
                        JOptionPane.showMessageDialog(null,
                                "Login Failled",
                                "Login",
                                JOptionPane.WARNING_MESSAGE);
                        txtUsername.repaint();
                        txtPassword.repaint();
                    }
                    read.close();
                    file.close();
                    
                } catch (Exception ex) {
                    try {
                        JOptionPane.showMessageDialog(null,
                                "Looks like you are my first client, "
                                + "a test profile will be generated now. "
                                + "Username is 'admin' & password is '1234'",
                                "Status",
                                JOptionPane.WARNING_MESSAGE);
                        
                        FileWriter file = new FileWriter("login.txt");
                        PrintWriter print = new PrintWriter(file);
                        print.println("admin 1234");
                        print.close();
                        file.close();
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                txtUsername.setText(" ");
                txtPassword.setText(" ");
                txtUsername.repaint();
                txtPassword.repaint();
            }
        });
        btnCreateProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Place your code Here !!
                // Your code supposed to call the create account gui & import
                // the profile data to a txt file named after the ...
                // username.    
            }
        });
        btnRecoverProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String strUsernameRecover = JOptionPane.showInputDialog(
                        "Enter your username");
                try {
                    FileReader file = new FileReader(strLogin);
                    BufferedReader read = new BufferedReader(file);
                    String input = read.readLine();
                    boolean recovered = false;
                    
                    while (input != null) {
                        if (input.contains(strUsernameRecover)) {
                            String strPasswordRecover = input.substring(
                                    strUsernameRecover.length());
                            JOptionPane.showMessageDialog(null,
                                    "Your Passowrd is: " + strPasswordRecover,
                                    "Recovery",
                                    JOptionPane.WARNING_MESSAGE);
                            recovered = true;
                            break;
                        }
                        input = read.readLine();
                    }
                    if (!recovered) {
                        JOptionPane.showMessageDialog(null,
                                "Profile Doesn't Exist",
                                "Recovery",
                                JOptionPane.WARNING_MESSAGE);
                        txtUsername.repaint();
                        txtPassword.repaint();
                    }
                    read.close();
                    file.close();
                } catch (Exception e) {
                    try {
                        JOptionPane.showMessageDialog(null,
                                "Looks like you are my first client, a test profile will "
                                + "be generated now. Username is 'admin' & "
                                + "password is '1234'",
                                "Status",
                                JOptionPane.WARNING_MESSAGE);
                        FileWriter file = new FileWriter("login.txt");
                        PrintWriter print = new PrintWriter(file);
                        print.println("admin 1234");
                        print.close();
                        file.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}
