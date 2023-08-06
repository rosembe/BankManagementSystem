package bank.management;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener {
    long random;
    JTextField id,passport;
    JButton next;
    JRadioButton syes,sno,eyes,eno;

    JComboBox religion,occupation,income,category,education;
    String formno;

    SignupTwo(String formno){
        this.formno= formno;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        Random ran  = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000l);




        JLabel additionalDetails= new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font ("Raleway", Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font ("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String valreligion[]= {"Muslim","Christian","Jewish","Hindu","Other"};
        religion = new JComboBox(valreligion);
        religion.setFont(new Font("Raleway", Font.BOLD,14));
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel fName = new JLabel("Blood Group:");
        fName.setFont(new Font ("Raleway", Font.BOLD,20));
        fName.setBounds(100,190,200,30);
        add(fName);
        String valcategory[] ={"A+","A-","B+","B-","AB+","AB-","O+","O-"};

        category = new JComboBox(valcategory);
        category.setFont(new Font("Raleway", Font.BOLD,14));
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);



        JLabel dob = new JLabel("Income");
        dob.setFont(new Font ("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String incomeCategory[] = {"<10,000","<20,000","<30,000","<40,000","up to 100,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setForeground(new Color(105,105,105));
        income.setBackground(Color.WHITE);
        add(income);



        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font ("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        String eduCategory[]={"Non-graduation","Gruduate","Post-Graduation","Doctrate","Other"};
        education = new JComboBox(eduCategory);
        education.setBounds(300,290,400,30);
        education.setBackground(Color.WHITE);
        add(education);






        JLabel email= new JLabel("Qualification");
        email.setFont(new Font ("Raleway", Font.BOLD,20));
        email.setBounds(100,320,200,30);
        add(email);



        JLabel marital= new JLabel("Occupation:");
        marital.setFont(new Font ("Raleway", Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        String occupValues[]={"Salaried","Self Employed","Business","Student","Retired"};
        occupation = new JComboBox(occupValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);







        JLabel address= new JLabel("ID Number:");
        address.setFont(new Font ("Raleway", Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        id = new JTextField();
        id.setFont(new Font("Raleway", Font.BOLD,14));
        id.setBounds(300,440,400,30);
        add(id);

        JLabel city= new JLabel("Passport Number:");
        city.setFont(new Font ("Raleway", Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        passport = new JTextField();
        passport.setFont(new Font("Raleway", Font.BOLD,14));
        passport.setBounds(300,490,400,30);
        add(passport);

        JLabel state= new JLabel("Senior Citizen:");
        state.setFont(new Font ("Raleway", Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,80,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540,70,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup maritalGroup= new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);




        JLabel pincode= new JLabel("Existing Account:");
        pincode.setFont(new Font ("Raleway", Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,80,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,590,70,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup yessi= new ButtonGroup();
        yessi.add(eyes);
        yessi.add(eno);


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

        String sreligion = (String) religion.getSelectedItem();
        String scategory =(String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation= (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = "null";
        if (syes.isSelected()){
            seniorcitizen="Yes";
        }else if (sno.isSelected()){
            seniorcitizen="No";        }

        String existingaccount = "null";
        if(eyes.isSelected()){
            existingaccount ="eyes";
        }else if(eno.isSelected()){
            existingaccount ="married";
        }
        String sid= id.getText();
        String spassport = passport.getText();


        try{

                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+seniorcitizen+"','"+existingaccount+"','"+sid+"','"+spassport+"');";

                c.s.executeUpdate(query);
                //Signup3 object
                setVisible(false);
                new SignupThree(formno).setVisible(true);

        }catch (Exception e ){
            System.out.println(e);
            e.printStackTrace();


        }
    }
    public static void main (String args[]) {
        new SignupTwo("");
    }
}


