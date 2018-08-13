package bmsgui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class CreateAccount extends JDialog {

    JDialog dg = this;
    JPanel pnlMain = new JPanel();
    JPanel pnlBottom = new JPanel();
    JLabel lblName = new JLabel("Name:");
    JLabel lblAge = new JLabel("Age:");
    JLabel lblNationalNumber = new JLabel("National Number:");
    JLabel lblAddress = new JLabel("Address:");
    JLabel lblEmail = new JLabel("Email:");
    JLabel lblJob = new JLabel("Job:");
    JTextField txtName = new JTextField();
    JTextField txtAge = new JTextField();
    JTextField txtNationalNumber = new JTextField();
    JTextField txtAddress = new JTextField();
    JTextField txtEmail = new JTextField();
    JTextField txtJob = new JTextField();
    JButton btnCreate = new JButton("Create");

    public CreateAccount() {
        setTitle("Create New Account");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(d.width / 3, d.height / 4, d.width / 2, d.height / 2);

        Container c = getContentPane();

        pnlMain.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        pnlBottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        Dimension d1 = new Dimension(300, 30);
        Dimension d2 = new Dimension(150, 30);

        lblName.setPreferredSize(d1);
        lblAge.setPreferredSize(d1);
        lblNationalNumber.setPreferredSize(d1);
        lblAddress.setPreferredSize(d1);
        lblEmail.setPreferredSize(d1);
        lblJob.setPreferredSize(d1);
        txtName.setPreferredSize(d1);
        txtAge.setPreferredSize(d1);
        txtNationalNumber.setPreferredSize(d1);
        txtAddress.setPreferredSize(d1);
        txtEmail.setPreferredSize(d1);
        txtJob.setPreferredSize(d1);
        btnCreate.setPreferredSize(d2);

        pnlMain.add(lblName);
        pnlMain.add(txtName);
        pnlMain.add(lblAge);
        pnlMain.add(txtAge);
        pnlMain.add(lblNationalNumber);
        pnlMain.add(txtNationalNumber);
        pnlMain.add(lblAddress);
        pnlMain.add(txtAddress);
        pnlMain.add(lblEmail);
        pnlMain.add(txtEmail);
        pnlMain.add(lblJob);
        pnlMain.add(txtJob);
        pnlBottom.add(btnCreate);

        c.add(pnlMain);
        c.add(pnlBottom, BorderLayout.SOUTH);

        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    File f = new File("Accounts.txt");
                    FileWriter fw = new FileWriter(f, true);
                    PrintWriter pw = new PrintWriter(fw, true);

                    String name = txtName.getText();
                    int age = Integer.parseInt(txtAge.getText());
                    int nationalNumber = Integer.parseInt(txtNationalNumber.getText());
                    String address = txtAddress.getText();
                    String email = txtEmail.getText();
                    String job = txtJob.getText();

                    pw.println(name);
                    pw.println(age);
                    pw.println(nationalNumber);
                    pw.println(address);
                    pw.println(email);
                    pw.println(job);

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
