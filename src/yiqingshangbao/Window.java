package yiqingshangbao;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Window {
   public static void main(String[] args){
       JFrame jframe = new JFrame("疫情上报管理系统") ; //window
       Dimension d = new Dimension(700,300);
       Point p = new Point (250,350);
        
       jframe.setSize(d);
       jframe.setLocation(p);
       jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
       JButton button1 = new JButton("上报疫情信息");
       JButton button2 = new JButton("修改疫情填报信息");
       JButton button3 = new JButton("查询疫情填报信息");
       JButton button4 = new JButton("浏览疫情填报信息");
        
       FlowLayout flow = new FlowLayout(FlowLayout.LEFT,10,10);
       JPanel panel = new JPanel(flow);
       panel.add(button1);
       panel.add(button2);
       panel.add(button3);
       panel.add(button4);
        
       jframe.add(panel);
       jframe.setVisible(true);
       button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Add add = new Add();
 
            }          
        });
        
       button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Change change = new Change();          
            }          
        });
        
       button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Ask ask = new Ask();           
            }          
        });
        
        
       button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Look look = new Look();        
            }          
        });
        
   }
 
}