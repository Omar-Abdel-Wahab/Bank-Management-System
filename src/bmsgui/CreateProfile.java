package bmsgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CreateProfile extends JDialog {
    JDialog dg = this;
    JPanel pnlMain = new JPanel();
    JLabel lblUsername = new JLabel("Username:");
    JLabel lblPassword = new JLabel("Password:");
    JTextField txtUsername = new JTextField();
    JTextField txtPassword = new JTextField();
    JButton btnCreate = new JButton("Create");

    public CreateProfile() {
        setTitle("Create New Profile");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(d.width / 3, d.height / 4, d.width / 2, d.height / 2);

        Container c = getContentPane();

        pnlMain.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        Dimension d1 = new Dimension(300, 30);
        Dimension d2 = new Dimension(150, 30);

        lblUsername.setPreferredSize(d1);
        lblPassword.setPreferredSize(d1);
        txtUsername.setPreferredSize(d1);
        txtPassword.setPreferredSize(d1);
        btnCreate.setPreferredSize(d2);

        pnlMain.add(lblUsername);
        pnlMain.add(txtUsername);
        pnlMain.add(lblPassword);
        pnlMain.add(txtPassword);
        pnlMain.add(btnCreate);
        c.add(pnlMain);

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File f = new File("Login.txt");
                    FileWriter fw = new FileWriter(f, true);
                    PrintWriter pw = new PrintWriter(fw, true);
                    
                    String username = txtUsername.getText();
                    String password = txtPassword.getText();
                    
                    pw.println(username);
                    pw.println(password);

                    pw.close();
                    fw.close();
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(dg, "IOException encountered. Please check"
                            + "the Accounts.txt file if in use or deleted");
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(dg, "Please check that you filled all the"
                            + "fields with the right data types");
                }
            }
        });
    }
}