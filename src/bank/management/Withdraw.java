package bank.management;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class Withdraw extends JFrame implements ActionListener {
    JButton withdraw,back;
    String pinnumber;
    JTextField amount;
    Withdraw(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon("src/icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        text.setBounds(180,300,400,30);
        text.setFont(new Font("Raleway", Font.BOLD,15));
        text.setForeground(Color.WHITE);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(180,340,305,25);
        image.add(amount);

        withdraw =  new JButton("Withdraw");
        withdraw.setBounds(355,483,150,30);
        withdraw.setFont(new Font ("Raleway", Font.BOLD,12));
        withdraw.addActionListener(this);
        withdraw.setForeground(Color.BLACK);
        withdraw.setBackground(Color.WHITE);

        image.add(withdraw);

        back =  new JButton("Back");    //
        back.setBounds(355,516,150,30);
        back.addActionListener(this);
        back.setFont(new Font ("Raleway", Font.BOLD,12));

        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);

        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
            }else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+number+"');"; // Inserting data to database
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"$"+number+" Withdraw Succesfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }

            }

        }else if (ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdraw("");
    }


}

