import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Show extends JFrame implements ActionListener 
{
	JButton Submit;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6,t7;

	MenuBar mb;
	Menu File,About;
	MenuItem Home,About1;
	
	Show()
	{
		Container c=getContentPane();
		c.setLayout(null);
		
		Submit=new JButton("Show");
		Submit.setBounds(150,430,100,30);
		
		l1=new JLabel("Name");
		l2=new JLabel("Father's Name");
		l3=new JLabel("Age");
		l4=new JLabel("City");
		l5=new JLabel("Phone");
		l6=new JLabel("Class");
		l7=new JLabel("");
		l8=new JLabel("id");

		l1.setBounds(50,50,200,50);
		l2.setBounds(50,110,200,50);
		l3.setBounds(50,170,200,50);
		l4.setBounds(50,230,200,50);
		l5.setBounds(50,290,200,50);
		l6.setBounds(50,350,200,50);
		l7.setBounds(50,500,200,50);
		l8.setBounds(50,5,200,50);
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		t7=new JTextField();
		
		t1.setBounds(150,60,150,30);
		t2.setBounds(150,120,150,30);
		t3.setBounds(150,180,150,30);
		t4.setBounds(150,240,150,30);
		t5.setBounds(150,300,150,30);
		t6.setBounds(150,360,150,30);
		t7.setBounds(150,10,150,30);
		
		mb=new MenuBar();
		setMenuBar(mb);
		
		File=new Menu("File",true);
		About=new Menu("About",true);

		Home=new MenuItem("Home");
		About1=new MenuItem("About");

		File.add(Home);
		About.add(About1);

		mb.add(File);
		mb.add(About);

		c.add(l1);
		c.add(t1);
		c.add(l2);
		c.add(t2);
		c.add(l3);
		c.add(t3);
		c.add(l4);
		c.add(t4);
		c.add(l5);
		c.add(t5);
		c.add(l6);
		c.add(t6);
		c.add(l7);
		c.add(l8);
		c.add(t7);
		c.add(Submit);
		
		c.setBackground(Color.BLACK);
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);
		l5.setForeground(Color.WHITE);
		l6.setForeground(Color.WHITE);
		l7.setForeground(Color.WHITE);
		l8.setForeground(Color.WHITE);

		Submit.addActionListener(this);		
	}
	
	 public void actionPerformed(ActionEvent ae)
	{

		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
	
					
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/student";
				con=DriverManager.getConnection(url,"root","root123");
				stmt=con.createStatement();
				
				int id=Integer.parseInt(t7.getText());
				String qry="select * from stud where id=id";
				rs=stmt.executeQuery(qry);
				 
				while(rs.next())
				{
				String s=rs.getString("sname");
				String fs=rs.getString("fname");
				int a=rs.getInt("age");
				String c=rs.getString("city");
				String p=rs.getString("phno");
				String cl=rs.getString("class1");
				
				t1.setText(s);
				t2.setText(fs);
				t3.setText(String.valueOf(a));
				t4.setText(c);
				t5.setText(p);
				t6.setText(cl);
				}	
				con.close();
			}catch(Exception e){
					System.out.println(e.getMessage());
					 }


	

		
	}
	
}	