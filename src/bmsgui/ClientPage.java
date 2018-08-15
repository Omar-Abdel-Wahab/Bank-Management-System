package bmsgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import bms.*;

public class ClientPage extends JDialog {

    JDialog dg = this;
    JPanel pnlTop = new JPanel();
    JPanel pnlMain = new JPanel();
    JPanel pnlBottom = new JPanel();
    JLabel lblWelcome = new JLabel("Welcome");
    JLabel lblName = new JLabel("Name: ");
    JLabel lblAge = new JLabel("Age: ");
    JLabel lblNationalNumber = new JLabel("National Number: ");
    JLabel lblAddress = new JLabel("Address: ");
    JLabel lblEmail = new JLabel("Email: ");
    JLabel lblJob = new JLabel("Job: ");
    JButton btnDeposit = new JButton("Deposit");
    JButton btnWithdraw = new JButton("Withdraw");
    JButton btnInquiry = new JButton("Inquiry");
    JButton btnMoneyTransfer = new JButton("Money Transfer");
    JButton btnRequestLoan = new JButton("Request Loan");
    JButton btnPayLoan = new JButton("Pay Loan");
    JButton btnViewTransactions = new JButton("View Transactions");

    public ClientPage(String username, Client client, int id) {
        setTitle("My Page");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(d.width / 3, d.height / 4, d.width / 2, d.height / 2);

        Container c = getContentPane();

        pnlMain.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        pnlTop.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        pnlBottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        pnlBottom.setPreferredSize(new Dimension(100, 80));
        Dimension d1 = new Dimension(300, 30);
        Dimension d2 = new Dimension(150, 30);

        lblWelcome.setText("Welcome " + username);
        lblName.setText("Name: " + client.getName());
        lblAge.setText("Age: " + client.getAge());
        lblNationalNumber.setText("National Number: " + client.getNationalNumber());
        lblAddress.setText("Address: " + client.getAddress());
        lblEmail.setText("Email: " + client.getEmail());
        lblJob.setText("Job: " + client.getJob());
        lblName.setPreferredSize(d1);
        lblAge.setPreferredSize(d1);
        lblNationalNumber.setPreferredSize(d1);
        lblAddress.setPreferredSize(d1);
        lblEmail.setPreferredSize(d1);
        lblJob.setPreferredSize(d1);
        btnDeposit.setPreferredSize(d2);
        btnWithdraw.setPreferredSize(d2);
        btnInquiry.setPreferredSize(d2);
        btnMoneyTransfer.setPreferredSize(d2);
        btnRequestLoan.setPreferredSize(d2);
        btnPayLoan.setPreferredSize(d2);
        btnViewTransactions.setPreferredSize(d2);

        pnlTop.add(lblWelcome);
        pnlMain.add(lblName);
        pnlMain.add(lblAge);
        pnlMain.add(lblNationalNumber);
        pnlMain.add(lblAddress);
        pnlMain.add(lblEmail);
        pnlMain.add(lblJob);
        pnlBottom.add(btnDeposit);
        pnlBottom.add(btnWithdraw);
        pnlBottom.add(btnInquiry);
        pnlBottom.add(btnMoneyTransfer);
        pnlBottom.add(btnRequestLoan);
        pnlBottom.add(btnPayLoan);
        pnlBottom.add(btnViewTransactions);
        c.add(pnlTop, BorderLayout.NORTH);
        c.add(pnlMain);
        c.add(pnlBottom, BorderLayout.SOUTH);

        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    String input = JOptionPane.showInputDialog(dg, "Enter the desired amount"
                            + " of money to put");
                    int amount = Integer.parseInt(input);
                    Account a;
                    Transaction t;
                    FileWriter fw;
                    PrintWriter pw;
                    FileReader fr;
                    BufferedReader br;

                    File f1 = new File(username + " Balance.txt");
                    File f2 = new File(username + " Transactions.txt");
                    if (!f1.exists()) {
                        f1.createNewFile();
                        a = new Account(id, client);
                        t = new Transaction(a, "Deposit");
                        t.deposit(amount);

                        fw = new FileWriter(f1, false);
                        pw = new PrintWriter(fw, true);
                        pw.println(a.getBalance());
                        pw.close();
                        fw.close();
                        if (!f2.exists()) {
                            f2.createNewFile();
                        }
                        fw = new FileWriter(f2, true);
                        pw = new PrintWriter(fw, true);
                        pw.println("Added amount: " + amount);
                        pw.println("New Balance: " + t.getDefaultAccount().getBalance());
                        pw.println(t.getType());
                        pw.close();
                        fw.close();
                    } else {
                        fr = new FileReader(f1);
                        br = new BufferedReader(fr);
                        int balance = Integer.parseInt(br.readLine());
                        a = new Account(id, client, balance);
                        t = new Transaction(a, "Deposit");
                        t.deposit(amount);
                        fw = new FileWriter(f1, false);
                        pw = new PrintWriter(fw, true);
                        pw.println(a.getBalance());
                        pw.close();
                        fw.close();
                        fw = new FileWriter(f2, true);
                        pw = new PrintWriter(fw, true);
                        pw.println("Added amount: " + amount);
                        pw.println("New Balance: " + t.getDefaultAccount().getBalance());
                        pw.println(t.getType());
                        pw.close();
                        fw.close();
                    }
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(dg, "You didn't enter a number");
                } catch (NegativeMoney e2) {
                    JOptionPane.showMessageDialog(dg, e2.getMessage());
                } catch (IOException e3) {
                    JOptionPane.showMessageDialog(dg, "IO exception occurred");
                }
            }
        });
        btnWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = JOptionPane.showInputDialog(dg, "Enter the desired amount"
                            + " of money to pull");
                    int amount = Integer.parseInt(input);
                    Account a;
                    Transaction t;
                    FileWriter fw;
                    PrintWriter pw;
                    FileReader fr;
                    BufferedReader br;

                    File f1 = new File(username + " Balance.txt");
                    File f2 = new File(username + " Transactions.txt");
                    if (!f1.exists()) {
                        f1.createNewFile();
                        a = new Account(id, client);
                        t = new Transaction(a, "Withdraw");
                        t.withdraw(amount);

                        fw = new FileWriter(f1, false);
                        pw = new PrintWriter(fw, true);
                        pw.println(a.getBalance());
                        pw.close();
                        fw.close();
                        if (!f2.exists()) {
                            f2.createNewFile();
                        }
                        fw = new FileWriter(f2, true);
                        pw = new PrintWriter(fw, true);
                        pw.println("Withdrawed amount: " + amount);
                        pw.println("New Balance: " + t.getDefaultAccount().getBalance());
                        pw.println(t.getType());
                        pw.close();
                        fw.close();
                    } else {
                        fr = new FileReader(f1);
                        br = new BufferedReader(fr);
                        int balance = Integer.parseInt(br.readLine());
                        a = new Account(id, client, balance);
                        t = new Transaction(a, "Withdraw");
                        t.withdraw(amount);
                        fw = new FileWriter(f1, false);
                        pw = new PrintWriter(fw, true);
                        pw.println(a.getBalance());
                        pw.close();
                        fw.close();
                        fw = new FileWriter(f2, true);
                        pw = new PrintWriter(fw, true);
                        pw.println("Withdrawed amount: " + amount);
                        pw.println("New Balance: " + t.getDefaultAccount().getBalance());
                        pw.println(t.getType());
                        pw.close();
                        fw.close();
                    }
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(dg, "You didn't enter a number");
                } catch (NegativeMoney e2) {
                    JOptionPane.showMessageDialog(dg, e2.getMessage());
                } catch (InsufficientBalance e3) {
                    JOptionPane.showMessageDialog(dg, "Can't extract money that is greater"
                            + " than your balance");
                } catch (IOException e4) {
                    JOptionPane.showMessageDialog(dg, "IO exception occurred");
                }
            }
        });
        btnInquiry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                File f = new File(username + " Balance.txt");
                try {
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    int balance = Integer.parseInt(br.readLine());
                    JOptionPane.showMessageDialog(dg, "Your balance = " + balance);
                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(dg, "Your balance = zero");
                } catch (IOException e2) {
                    JOptionPane.showMessageDialog(dg, "IO Exception occurred");
                }
            }
        });
        btnRequestLoan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                File f1 = new File(username + " Balance.txt");
                File f2 = new File(username + " Transactions.txt");
                File f3 = new File(username + " On Loan.txt");

                try {
                    if (!f1.exists()) {
                        f1.createNewFile();
                    }
                    FileReader fr = new FileReader(f1);
                    BufferedReader br = new BufferedReader(fr);
                    int balance = Integer.parseInt(br.readLine());
                    br.close();
                    fr.close();
                    if (!f3.exists()) {
                        f3.createNewFile();
                    }
                    fr = new FileReader(f3);
                    br = new BufferedReader(fr);
                    boolean onLoan = Boolean.parseBoolean(br.readLine());
                    br.close();
                    fr.close();
                    Account a = new Account(id, client, balance, onLoan);
                    Transaction t = new Transaction(a, "Request Loan");
                    t.requestLoan();
                    JOptionPane.showMessageDialog(dg, "Done. Check your new balance");
                    FileWriter fw = new FileWriter(f1, false);
                    PrintWriter pw = new PrintWriter(fw, true);
                    pw.println(a.getBalance());
                    pw.close();
                    fw.close();

                    fw = new FileWriter(f2, true);
                    pw = new PrintWriter(fw, true);
                    pw.println("New Balance: " + t.getDefaultAccount().getBalance());
                    pw.println(t.getType());
                    pw.close();
                    fw.close();

                    fw = new FileWriter(f3, false);
                    pw = new PrintWriter(fw, true);
                    pw.println(a.isOnLoan());
                    pw.close();
                    fw.close();

                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(dg, "File not found");
                } catch (IOException e2) {
                    JOptionPane.showMessageDialog(dg, "IO Exception occurred");
                } catch (LoanException e3) {
                    JOptionPane.showMessageDialog(dg, e3.getMessage());
                }
            }
        });
        btnPayLoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f1 = new File(username + " Balance.txt");
                File f2 = new File(username + " Transactions.txt");
                File f3 = new File(username + " On Loan.txt");

                try {
                    FileReader fr = new FileReader(f1);
                    BufferedReader br = new BufferedReader(fr);
                    int balance = Integer.parseInt(br.readLine());
                    br.close();
                    fr.close();
                    fr = new FileReader(f3);
                    br = new BufferedReader(fr);
                    boolean onLoan = Boolean.parseBoolean(br.readLine());
                    br.close();
                    fr.close();
                    Account a = new Account(id, client, balance, onLoan);
                    Transaction t = new Transaction(a, "Pay Loan");
                    t.payLoan();
                    JOptionPane.showMessageDialog(dg, "Done. Check your new balance");
                    FileWriter fw = new FileWriter(f1, false);
                    PrintWriter pw = new PrintWriter(fw, true);
                    pw.println(a.getBalance());
                    pw.close();
                    fw.close();

                    fw = new FileWriter(f2, true);
                    pw = new PrintWriter(fw, true);
                    pw.println("New Balance: " + t.getDefaultAccount().getBalance());
                    pw.println(t.getType());
                    pw.close();
                    fw.close();
                    
                    fw = new FileWriter(f3, false);
                    pw = new PrintWriter(fw, true);
                    pw.println(a.isOnLoan());
                    pw.close();
                    fw.close();

                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(dg, "File not found");
                } catch (IOException e2) {
                    JOptionPane.showMessageDialog(dg, "IO Exception occurred");
                } catch (LoanException e3) {
                    JOptionPane.showMessageDialog(dg, e3.getMessage());
                }
            }
        });
        btnViewTransactions.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            String str = "";
            File f = new File(username + " Transactions.txt");
            try{
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                while(br.ready()){
                    str+=br.readLine();
                    str+="\n";
                }
                br.close();
                fr.close();
                ViewTransactions vt = new ViewTransactions(str);
                vt.setVisible(true);
            }catch(FileNotFoundException e1){
                JOptionPane.showMessageDialog(dg, "No transactions done yet");
            }catch(IOException e2){
                JOptionPane.showMessageDialog(dg, "IO Exception occurred");
            }    
        }
    });
    }

}
