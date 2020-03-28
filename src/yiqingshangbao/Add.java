package yiqingshangbao;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
import com.mysql.jdbc.Driver;
 
import yiqingshangbao.Window;
 
public class Add extends JFrame {
    private static final long serialVersionUID = -1928970409928880648L;
     
    JLabel jlnumber = new JLabel("学号：");
    JLabel jlname = new JLabel("姓名：");
    JLabel jldeparment = new JLabel("学院：");
    JLabel jlfanxiao = new JLabel("是否今天从外地返校：");
    JLabel jlyisi = new JLabel("是否有疑似疫情症状：");
    JLabel jlquezhen = new JLabel("是否已经确诊："); 
    
    JTextField jtnumber = new JTextField("",20);
    JTextField jtname = new JTextField("",20);
    JTextField jtdeparment = new JTextField("",20);
    JTextField jtfanxiao = new JTextField("",20);
    JTextField jtyisi = new JTextField("",20);
    JTextField jtquezhen = new JTextField("",20);
     
    JButton buttonadd = new JButton("添加");
    JButton buttonreturn = new JButton("返回");
     
     
    public Add() {
        JPanel jpnumber = new JPanel();
        JPanel jpname = new JPanel();
        JPanel jpdeparment = new JPanel();
        JPanel jpfanxiao = new JPanel();
        JPanel jpyisi = new JPanel();
        JPanel jpquezhen = new JPanel();
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));
         
        jpnumber.add(jlnumber);
        jpnumber.add(jtnumber);
         
        jpname.add(jlname);
        jpname.add(jtname);
         
        jpdeparment.add(jldeparment);
        jpdeparment.add(jtdeparment);
         
        jpfanxiao.add(jlfanxiao);
        jpfanxiao.add(jtfanxiao);
         
        jpyisi.add(jlyisi);
        jpyisi.add(jtyisi);
        
        jpquezhen.add(jlquezhen);
        jpquezhen.add(jtquezhen);
         
        jpforbutton.add(buttonadd);
        jpforbutton.add(buttonreturn);
         
        buttonadd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 
                //Add
                Connection conn = null;
                Statement stat = null;
                PreparedStatement ps=null;
                String sql = "INSERT INTO student(number,name,deparment,fanxiao,yisi,quezhen) "
                        + "values(?,?,?,?,?,?)";
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("JBDC 加载成功!");
                }catch(Exception a){
                    System.out.println("JBDC 狗带!");
                    a.printStackTrace();
                }
                try{
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false","root","555320lll");
                    ps=conn.prepareStatement(sql);
                     
                    ps.setString(1,jtnumber.getText());
                    ps.setString(2,jtname.getText());
                    ps.setString(3,jtdeparment.getText());
                    ps.setString(4,jtfanxiao.getText());
                    ps.setString(5,jtyisi.getText());
                    ps.setString(6,jtquezhen.getText());
 
                    ps.executeUpdate();
                     
                    //System.out.println("MySQL 连接成功!");
                    //stat = conn.createStatement();
                    //stat.executeUpdate(sql);
                    //System.out.println("插入数据成功!");
                     
                }catch (SQLException b){
                    b.printStackTrace();
                }finally{
                    try{
                        conn.close();
                        System.out.println("MySQL 关闭成功");
                    }catch (SQLException c){
                        System.out.println("MySQL 关闭失败 ");
                        c.printStackTrace();
                    }
                     
                }
                     
                     
        }} 
         
                );
         
        buttonreturn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Window window = new Window();          
            }          
        });
         
         
        this.setTitle("疫情信息上报");
        this.setLayout(new GridLayout(9,1));
        this.add(jpnumber);
        this.add(jpname);
        this.add(jpdeparment);
        this.add(jpfanxiao);
        this.add(jpyisi);
        this.add(jpquezhen);
        this.add(jpforbutton);
        this.setLocation(400,300);
        this.setSize(700,600);
        this.setVisible(true);
         
    }
     
     
}