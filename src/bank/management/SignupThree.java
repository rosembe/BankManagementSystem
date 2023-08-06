package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    SignupThree( String formno){
    this.formno=formno;
        setLayout(null);
        JLabel l1= new JLabel("Page 3: Account Details");
        l1.setBounds(280,40,400,40);
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD,22));
        type.setBounds(100,140,400,40);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD,16));
        r1.setBounds(100,180,200,30);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2=new JRadioButton("Current Account");// Current account kutucuğu oluşturur.
        r2.setFont(new Font("Raleway", Font.BOLD,16));
        r2.setBounds(100,210,200,30);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3=new JRadioButton("Fixed Deposit Account");  // Fixed deposit account kutucuğu oluşturur.
        r3.setFont(new Font("Raleway", Font.BOLD,16));
        r3.setBounds(350,180,200,30);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD,16));
        r4.setBounds(350,210,250,30);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup account = new ButtonGroup();
        account.add(r1);
        account.add(r2);
        account.add(r3);
        account.add(r4);

        JLabel l2= new JLabel("Card Number");
        l2.setBounds(100,280,400,40);
        l2.setFont(new Font("Raleway", Font.BOLD,22));
        add(l2);

        JLabel l3= new JLabel("Your 16 digit card number");
        l3.setBounds(100,310,400,30);
        l3.setFont(new Font("Raleway", Font.BOLD,12));
        add(l3);

        JLabel number= new JLabel("XXXX-XXXX-XXXX-4184");
        number.setBounds(320,280,400,40);
        number.setFont(new Font("Raleway", Font.BOLD,22));
        add(number);

        JLabel l4= new JLabel("PIN:");
        l4.setBounds(100,360,400,40);
        l4.setFont(new Font("Raleway", Font.BOLD,22));
        add(l4);

        JLabel pin= new JLabel("XXXX");
        pin.setBounds(320,360,400,40);
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        add(pin);

        JLabel l5= new JLabel("Your 4 digit password");
        l5.setBounds(100,390,400,30);
        l5.setFont(new Font("Raleway", Font.BOLD,12));
        add(l5);

        JLabel l6= new JLabel("Services Required:");
        l6.setBounds(100,440,400,40);
        l6.setFont(new Font("Raleway", Font.BOLD,22));
        add(l6);

        c1 = new JCheckBox("ATM CARD");
        c1.setBounds(100,500,200,30);
        c1.setFont(new Font("Raleway", Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(350,500,200,30);
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        c2.setBackground(Color.WHITE);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(100,540,200,30);
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        c3.setBackground(Color.WHITE);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBounds(350,540,200,30);
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        c4.setBackground(Color.WHITE);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(100,580,200,30);
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        c5.setBackground(Color.WHITE);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBounds(350,580,200,30);
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        c6.setBackground(Color.WHITE);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBounds(100,680,600,30);
        c7.setFont(new Font("Raleway", Font.BOLD,12));
        c7.setBackground(Color.WHITE);
        add(c7);

        submit = new JButton("Submit");
        submit.setBounds(270,730,100,30);
        submit.setFont(new Font("Raleway", Font.BOLD,12));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,730,100,30);
        cancel.setFont(new Font("Raleway", Font.BOLD,12));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);



        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit) {
            String accountType = "null";
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Current Account";
            } else if (r3.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }
            Random random = new Random();

            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (c1.isSelected()) {
                facility = facility + "ATM CARD";
            } else if (c2.isSelected()) {
                facility = facility + "Internet Banking";
            } else if (c3.isSelected()) {
                facility = facility + "Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility + "EMAIL & SMS Alerts";
            } else if (c5.isSelected()) {
                facility = facility + "Cheque Book";
            } else if (c6.isSelected()) {
                facility = facility + "E-Statement";
            }
            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values ('" + formno + "','" + accountType + "','" + cardNumber + "','" + pinNumber + "','" + facility + "')";
                    String query2 = "insert into login values ('" + formno + "','" + cardNumber + "','" + pinNumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number:"+cardNumber + "\n Pin: "+pinNumber);

                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }

            } catch (Exception e) {
                System.out.println(e);

            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}
