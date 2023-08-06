package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon("src/icons/atm.jpg");
        Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back =  new JButton("BACK");
        back.setBounds(355,516,150,30);
        back.setFont(new Font ("Raleway", Font.BOLD,12));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

        Conn c= new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");

            while (rs.next()) {
                String type = rs.getString("type");
                int amount = Integer.parseInt(rs.getString("amount"));

                if (type.equals("deposit")) {
                    balance += amount; // Para yatırma işlemi için bakiyeye ekle
                } else if (type.equals("withdraw")) {
                    balance -= amount; // Para çekme işlemi için bakiyeden çıkar
                }
            }
            }catch(Exception e){
                System.out.println(e);
            }

        JLabel text = new JLabel("Your current balance is $ "+ balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);

        setSize(900,900);
        setLocation(320,0);
        setUndecorated(true);
        setVisible(true);




    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");


    }
}
