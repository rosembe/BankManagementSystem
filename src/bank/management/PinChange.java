package bank.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JButton change,back;
    JPasswordField pinTextField,repinTextField;
    String pinnumber;
    PinChange(String pinnumber) {
        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon("src/icons/atm.jpg");
        Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pin = new JLabel("New PIN");
        pin.setForeground(Color.WHITE);
        pin.setFont(new Font("System", Font.BOLD,16));
        pin.setBounds(165,320,180,35);
        image.add(pin);

        JLabel rePin = new JLabel("Re-Enter New PIN");
        rePin.setForeground(Color.WHITE);
        rePin.setFont(new Font("System", Font.BOLD,16));
        rePin.setBounds(165,355,180,35);
        image.add(rePin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(330,320,180,25);
        image.add(pinTextField);

        repinTextField = new JPasswordField();
        repinTextField.setBounds(330,360,180,25);
        image.add(repinTextField);

        change =  new JButton("CHANGE");
        change.setBounds(355,483,150,30);
        change.setFont(new Font ("Raleway", Font.BOLD,12));
        change.setForeground(Color.BLACK);
        change.setBackground(Color.WHITE);
        change.addActionListener(this);
        image.add(change);

        back =  new JButton("BACK");
        back.setBounds(355,516,150,30);
        back.setFont(new Font ("Raleway", Font.BOLD,12));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();


        setSize(900,900);
        setLocation(320,0);
        setUndecorated(true);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try {
                String npin=pinTextField.getText();
                String rpin=repinTextField.getText();
                if(!(npin.equals(rpin))){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the new PIN");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter the new PIN");
                    return;
                }
                Conn conn = new Conn();
                String query1="Update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2="Update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query3="Update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN Changed succesfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            }catch (Exception e) {
                System.out.println(e);
            }
        }else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
