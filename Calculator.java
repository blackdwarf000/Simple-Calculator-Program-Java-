/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author pc
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public  class Calculator extends JFrame{
    
   static int i = 0;
   static int a = -20;
   static JLabel operation; 
   
   static ArrayList<JLabel> arr =  new ArrayList<JLabel>();;
   static JButton add,subs,div,mul,mod,clear;
   static JTextField num1,num2;
   static JLabel firstNum,secondNum,total;
   static JPanel panel1,panel2; 
   static Font f ;
   static SpringLayout sprng;
   static Calculator calc;
   
   public Calculator(){
       this.setSize(500,500);
       this.setLocationRelativeTo(null);
       this.setTitle("Calculator");
       this.setLayout(new GridLayout(1,2));
       this.setResizable(false);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setVisible(true);
   }
   
   //Panels
    static void pan1(){
       panel1 = new JPanel();
       panel1.setBackground(Color.WHITE);
       panel1.setLayout(sprng);
       panel1.setVisible(true);
       
    }
    
   static void pan2(){
       panel2 = new JPanel();
       panel2.setBackground(Color.WHITE);
       panel2.setVisible(true);
       panel2.setLayout(new GridLayout(6,1));
    }
   

    //BUTTONS
    static void add(){
       add = new JButton("Add");
       add.setSize(50,50);
       add.setName("add");
        add.setActionCommand("add");
       add.addActionListener(new Action());
       add.setVisible(true);
   }
    static void subs(){
       subs = new JButton("Subtract");
       subs.setSize(50,50);
        subs.setActionCommand("subs");
       subs.setName("subs");
       subs.addActionListener(new Action());
       subs.setVisible(true);
   }
     static void div(){
       div = new JButton("Divide");
       div.setSize(50,50);
       div.setName("div");
        div.setActionCommand("div");
       div.addActionListener(new Action());
       div.setVisible(true);
   }
    static void mul(){
       mul = new JButton("Multiply");
       mul.setSize(50,50);
       mul.setName("mul");
        mul.setActionCommand("mul");
       mul.addActionListener(new Action());
       mul.setVisible(true);
   }
    static void mod(){
       mod = new JButton("Modulo");
       mod.setSize(50,50);
       mod.setActionCommand("mod");
       mod.addActionListener(new Action());
       mod.setVisible(true);
   }
    
    static void clear(){
       f = new Font("AvantGrande",Font.PLAIN,15); 
       clear = new JButton("C l e a r");
       clear.setSize(50,50);
       clear.setBackground(Color.gray);
       clear.setForeground(Color.white);
       clear.setActionCommand("clear");
       clear.setBorderPainted(false);
       clear.setCursor(new Cursor(Cursor.HAND_CURSOR));
       clear.setFont(f);
       clear.addActionListener(new Action());
       clear.setVisible(true);
   }
    
    //LABELS
    static void fnum(){
       f = new Font("AvantGrande",Font.PLAIN,10);
       firstNum = new JLabel("First Number : "); 
       firstNum.setFont(f);
       firstNum.setVisible(true);
       
    }
    
    static void snum(){
       f = new Font("AvantGrande",Font.PLAIN,10);
       secondNum = new JLabel("Second Number : ");
       secondNum.setFont(f);
       secondNum.setVisible(true);
        
    }
    
 
    //TEXTFIELDS
    static void num1(){
        num1 = new JTextField();
        num1.setVisible(true);
        num1.setColumns(20);
    }
    
    static void num2(){
        num2 = new JTextField();
        num2.setVisible(true);
        num2.setColumns(20);
        
    }
    
    static void total(){
       f = new Font("AvantGrande",Font.PLAIN,30);
       total = new JLabel();
       //total.setColumns(9);
       total.setBorder(null);
       total.setCursor(new Cursor(Cursor.HAND_CURSOR));
       total.setPreferredSize(new Dimension(250,30));
       total.setBackground(Color.gray);
       //total.setEditable(false);
       total.setFont(f);
       total.setForeground(Color.red);
       total.setVisible(true);
        
    }
    
    //MAIN
    public static void main(String[] args) {
        calc = new Calculator();
        sprng = new SpringLayout();
        //ADDING PANELS
        calc.pan1();
        calc.add(panel1);
        calc.pan2();
        calc.add(panel2);
        
        //ADDING COMPONENETS TO FIRST PANEL
        calc.fnum();
        calc.panel1.add(firstNum);
        sprng.putConstraint(SpringLayout.WEST, firstNum, 15, SpringLayout.WEST, panel1);
        sprng.putConstraint(SpringLayout.NORTH, firstNum, 55,SpringLayout.NORTH,panel1);
      
        calc.num1();
        calc.panel1.add(num1);
        sprng.putConstraint(SpringLayout.WEST, num1, 15, SpringLayout.WEST, panel1);
        sprng.putConstraint(SpringLayout.NORTH, num1, 10, SpringLayout.SOUTH, firstNum);
      
        calc.snum();
        calc.panel1.add(secondNum);
        sprng.putConstraint(SpringLayout.WEST, secondNum, 15, SpringLayout.WEST, panel1);
        sprng.putConstraint(SpringLayout.NORTH, secondNum, 20,SpringLayout.SOUTH,num1);
      
        calc.num2();
        calc.panel1.add(num2);
        sprng.putConstraint(SpringLayout.WEST, num2, 15, SpringLayout.WEST, panel1);
        sprng.putConstraint(SpringLayout.NORTH, num2, 10, SpringLayout.SOUTH, secondNum);
      
        calc.total();
        calc.panel1.add(total);
        sprng.putConstraint(SpringLayout.WEST, total, 5, SpringLayout.WEST, panel1);
        sprng.putConstraint(SpringLayout.NORTH, total, 125, SpringLayout.SOUTH, num2);
      
        //ADDING COMPONENTS TO SECOND PANEL
        calc.add();
        calc.panel2.add(add);
        calc.subs();
        calc.panel2.add(subs);
        calc.mul();
        calc.panel2.add(mul);
        calc.div();
        calc.panel2.add(div);
        calc.mod();
        calc.panel2.add(mod);
        calc.clear();
        calc.panel2.add(clear);    
    }
    
   static class Action implements ActionListener{
       
        public void actionPerformed(ActionEvent e){
             try{
           String command = e.getActionCommand();
           long n = Long.parseLong(num1.getText());
           long n2 = Long.parseLong(num2.getText());
           long tot = 0;
        if(command.equals("add")){
            tot = n + n2;
            total.setText(String.valueOf(tot));
            total.setToolTipText(total.getText());
            operation = new JLabel("+");
            history();
        }
        if(command.equals("subs")){
            tot = n - n2;
            total.setText(String.valueOf(tot));
           total.setToolTipText(total.getText());
             operation = new JLabel("-");
               history();     
        }
        if(command.equals("mul")){
            tot = n * n2;
            total.setText(String.valueOf(tot));
            total.setToolTipText(total.getText());
             operation = new JLabel("*");
               history();
        }
        if(command.equals("div")){
            tot = n / n2;
            total.setText(String.valueOf(tot));
            total.setToolTipText(total.getText());
             operation = new JLabel("/");
               history();
        }
        if(command.equals("mod")){
            tot = n % n2;
            total.setText(String.valueOf(tot));
            total.setToolTipText(total.getText());
            operation = new JLabel("%");
              history();
        }
        if(command.equals("clear")){
           total.setText("");
           num1.setText("");
           num2.setText("");
        } 
        }
         
        catch(Exception ex) {    
           String command = e.getActionCommand();
            if(command.equals("clear")){
               num1.setText("");
               num2.setText("");
            }  
            
            else{
                if(num1.getText().equals("") || num2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Empty Field");   
                }
               
                else{
                     JOptionPane.showMessageDialog(null,"Error: " + ex.toString(),"Error",JOptionPane.WARNING_MESSAGE);
                 }
            }
            }
      
        }
   
   }
    static void history(){
          if(a == -120){
              for(int q = 0; q < arr.size();q++){
                  arr.get(q).setText("");
              }
              arr.clear();
              a = -20;
              i = 0;  
          }
          
           String tots = total.getText() + " => " + num1.getText() + " " + operation.getText() + " " + num2.getText();
           if(!total.getText().isEmpty()){
           arr.add(new JLabel(tots)); // add a new label in the array    
           }
           
           while(i < arr.size()){
               arr.get(i).setVisible(true);
               arr.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
               arr.get(i).setToolTipText(arr.get(i).getText()); // set a tooltip for label
               calc.panel1.add(arr.get(i));
               sprng.putConstraint(SpringLayout.WEST, arr.get(i), 15, SpringLayout.WEST, panel1);
               sprng.putConstraint(SpringLayout.NORTH, arr.get(i), a, SpringLayout.SOUTH, panel1);
               a -= 10;
               i++;
           }
    }
}
                           