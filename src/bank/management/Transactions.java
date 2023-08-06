package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdraw,fastCash,miniStatement,pinChange,balanceEnquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon("src/icons/atm.jpg");
        Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select your transactions");
        text.setBounds(220,300,400,30);
        text.setFont(new Font("Raleway", Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit =  new JButton("Deposit");
        deposit.setBounds(160,417,150,30);
        deposit.setFont(new Font ("Raleway", Font.BOLD,12));
        deposit.setForeground(Color.BLACK);
        deposit.setBackground(Color.WHITE);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw =  new JButton("Cash Withdraw"); //Withdraw butonu oluşturur.
        withdraw.setBounds(355,417,150,30);
        withdraw.setFont(new Font ("Raleway", Font.BOLD,12));
        withdraw.setForeground(Color.BLACK);
        withdraw.setBackground(Color.WHITE);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastCash =  new JButton("Fast Cash");
        fastCash.setBounds(160,450,150,30);
        fastCash.setFont(new Font ("Raleway", Font.BOLD,12));
        fastCash.setForeground(Color.BLACK);
        fastCash.setBackground(Color.WHITE);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement =  new JButton("Mini Statement");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.setFont(new Font ("Raleway", Font.BOLD,12));
        miniStatement.setForeground(Color.BLACK);
        miniStatement.setBackground(Color.WHITE);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange =  new JButton("Pin Change");
        pinChange.setBounds(160,483,150,30);
        pinChange.setFont(new Font ("Raleway", Font.BOLD,12));
        pinChange.setForeground(Color.BLACK);
        pinChange.setBackground(Color.WHITE);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry =  new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,483,150,30);
        balanceEnquiry.setFont(new Font ("Raleway", Font.BOLD,12));
        balanceEnquiry.setForeground(Color.BLACK);
        balanceEnquiry.setBackground(Color.WHITE);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit =  new JButton("Exit");
        exit.setBounds(355,516,150,30);
        exit.setFont(new Font ("Raleway", Font.BOLD,12));
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.WHITE);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);

        } else if (ae.getSource()== pinChange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);

        }else if (ae.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource()==miniStatement) {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);

        }

    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
