package bank.management;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField,fNameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton single,married,other,male,female;
    JDateChooser dateChooser;

    SignupOne(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        Random ran  = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000l);


        JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personDetails= new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font ("Raleway", Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font ("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fName = new JLabel("Father's Name:");
        fName.setFont(new Font ("Raleway", Font.BOLD,20));
        fName.setBounds(100,190,200,30);
        add(fName);

        fNameTextField = new JTextField();
        fNameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        fNameTextField.setBounds(300,190,400,30);
        add(fNameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font ("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font ("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290,70,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup= new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);


        JLabel email= new JLabel("Email:");
        email.setFont(new Font ("Raleway", Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel marital= new JLabel("Marital Status:");
        marital.setFont(new Font ("Raleway", Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,390,80,30);
        married.setBackground(Color.WHITE);
        add(married);

        single = new JRadioButton("Single");
        single.setBounds(450,390,70,30);
        single.setBackground(Color.WHITE);
        add(single);

        other = new JRadioButton("Other");
        other.setBounds(600,390,70,30);
        other.setBackground(Color.WHITE);
        add(other);



        ButtonGroup maritalGroup= new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(single);
        maritalGroup.add(other);

        JLabel address= new JLabel("Address:");
        address.setFont(new Font ("Raleway", Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city= new JLabel("City:");
        city.setFont(new Font ("Raleway", Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state= new JLabel("State:");
        state.setFont(new Font ("Raleway", Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode= new JLabel("Pin Code:");
        pincode.setFont(new Font ("Raleway", Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);

        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(660,630,80,30);
        next.addActionListener(this);
        add(next);














        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850,800);

        setLocation(350,10);



    }
    public void actionPerformed (ActionEvent ae){
        String formno= ""+random;
        String name = nameTextField.getText();
        String fName =fNameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = "null";
        if (male.isSelected()){
            gender="male";
        }else if (female.isSelected()){
            gender="female";        }
        String email = emailTextField.getText();
        String marital = "null";
        if(single.isSelected()){
            marital ="single";
        }else if(married.isSelected()){
            marital ="married";
        }else if(other.isSelected()){
            marital="other";
        }
        String address= addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"','"+fName+"','"+dob+"','"+email+"','"+gender+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"');";

                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        }catch (Exception e ){
            System.out.println(e);
            e.printStackTrace();




        }
    }
    public static void main (String args[]) {
        new SignupOne();
    }
}


