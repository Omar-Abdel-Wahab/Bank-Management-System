package dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoardGUI extends JFrame implements ActionListener{
    private JPanel pnlLabels = new JPanel();
    private JPanel pnlButtons = new JPanel();
    
    private JLabel lblName = new JLabel("Name : ");
    private JLabel lblNum = new JLabel("Account Number : ");
    
    private JButton btnWithdraw = new JButton("Withdraw");
    private JButton btnDeposit = new JButton("Deposit");
    private JButton btnTransfer = new JButton("Transfer");
    private JButton btnInquiry = new JButton("Balance Inquiry");
    
    public DashBoardGUI(){
        init();
    }
    
    public void init(){
        this.setTitle("DashBoard");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400,50,600,600);
        this.setResizable(false);
        
        Container c = this.getContentPane();
        
        //pnlLabels.setPreferredSize(new Dimension(200,300));
        pnlLabels.setLayout(new GridLayout(2,1));
        pnlLabels.add(lblName);
        pnlLabels.add(lblNum);
        
        pnlButtons.setLayout(new GridLayout(4,1));
        
        pnlButtons.add(btnDeposit);
        pnlButtons.add(btnWithdraw);
        pnlButtons.add(btnTransfer);
        pnlButtons.add(btnInquiry);
        
        c.add(pnlLabels,BorderLayout.NORTH);
        c.add(pnlButtons);
        
        btnDeposit.addActionListener(this);
        btnWithdraw.addActionListener(this);
        btnTransfer.addActionListener(this);
        btnInquiry.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
        
        if(o == btnDeposit){
            String s = (String)JOptionPane.showInputDialog(null,"Please enter the amount you would like to deposit","Message" , JOptionPane.PLAIN_MESSAGE);
        }
        
        if (o == btnWithdraw){
            String s = (String)JOptionPane.showInputDialog(null,"Please enter the amount you would like to withdraw","Message" , JOptionPane.PLAIN_MESSAGE);
        }
        
        if (o == btnTransfer){
            JPanel myPanel = new JPanel();
            JLabel lblAccountNum = new JLabel("Account Number : ");
            JLabel lblAmmount = new JLabel("Amount : ");
            JTextField txtAmount = new JTextField();
            JTextField txtAccountNum = new JTextField();
            JLabel lblText = new JLabel("Please Enter the Account number you wish to tranfer to and the Amount you wish to transfer");
            
            myPanel.setLayout(new GridLayout(5,2));
            
            myPanel.add(lblText);
            myPanel.add(lblAccountNum);
            myPanel.add(txtAccountNum);
            myPanel.add(lblAmmount);
            myPanel.add(txtAmount);
            
            JOptionPane.showConfirmDialog(null,myPanel,"Message",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
        }
        
        if (o == btnInquiry){
            JOptionPane.showMessageDialog(null,"Your balance is ","Message",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
