package yiqingshangbao;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
import yiqingshangbao.Window;
 
public class Ask extends JFrame {
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
     
    JButton buttonask = new JButton("查询");
    JButton buttonreturn = new JButton("返回");
     
     
    public Ask() {
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
         
        jpforbutton.add(buttonask);
        jpforbutton.add(buttonreturn);
         
        buttonask.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Connection conn = null;
                ResultSet res = null;
                Statement stat = null;
                 
                String sql = "SELECT * FROM student ";
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                     
                }catch(Exception d){
                    System.out.println("jdbc fall");
                    d.printStackTrace();
                }
                try{
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false","root","555320lll");
                    stat=conn.createStatement();
                    res=stat.executeQuery(sql);
                    while (res.next())
                    {
                        if (res.getString(1).equals(jtnumber.getText()))
                        {
                            jtname.setText(res.getString(2));
                            jtdeparment.setText(res.getString(3));
                            jtfanxiao.setText(res.getString(4));
                            jtyisi.setText(res.getString(5));
                            jtquezhen.setText(res.getString(6));
                            
                            break;
                        }
                    }
                }catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                 
                 
            }
                finally{
                    try{
                        conn.close();
                    }catch(SQLException ar){
                        ar.printStackTrace();
                    }
             
                }}}
             
                );
         
        buttonreturn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Window window = new Window();          
            }          
        });
         
         
        this.setTitle("查询疫情填报信息");
        this.setLayout(new GridLayout(9,1));
        this.add(jpnumber);
        this.add(jpname);
        this.add(jpdeparment);
        this.add(jpfanxiao);
        this.add(jpyisi);
        this.add(jpquezhen);
        this.add(jpforbutton);
        this.setLocation(400,300);
        this.setSize(750,600);
        this.setVisible(true);
         
         
    }
     
     
}