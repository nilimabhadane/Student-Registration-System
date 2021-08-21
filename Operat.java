import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Operat extends JFrame implements ActionListener
{
	JButton Submit,delete;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6,t7;

	MenuBar mb;
	Menu File,About;
	MenuItem Home,About1;
	
	Operat()
	{
		Container c=getContentPane();
		c.setLayout(null);
		
		Submit=new JButton("Update");
		Submit.setBounds(80,500,100,30);
		delete=new JButton("Delete");
		delete.setBounds(300,500,100,30);
		
		l1=new JLabel("ID");
		l2=new JLabel("Name");
		l3=new JLabel("Father's Name");
		l4=new JLabel("Age");
		l5=new JLabel("City");
		l6=new JLabel("Phone");
		l7=new JLabel("Class");
		l8=new JLabel("");

		l1.setBounds(50,50,200,50);
		l2.setBounds(50,110,200,50);
		l3.setBounds(50,170,200,50);
		l4.setBounds(50,230,200,50);
		l5.setBounds(50,290,200,50);
		l6.setBounds(50,350,200,50);
		l7.setBounds(50,410,200,50);
		l8.setBounds(50,460,200,50);
		
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
		t7.setBounds(150,420,150,30);
		
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
		c.add(t7);
		c.add(l8);
		c.add(Submit);
		c.add(delete);
		
		
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
		delete.addActionListener(this);
	

		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});	
		
		

	}
	 public void actionPerformed(ActionEvent ae)
	{

		Connection con=null;
		PreparedStatement pstmt=null;
		
				
			if (ae.getSource()==Submit)
			{
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/student";
				con=DriverManager.getConnection(url,"root","root123");
				
			
				
				String qry="update stud set sname=?,fname=?,age=?,city=?,phno=?,class1=? where id=?";
				pstmt=con.prepareStatement(qry);
				
				String sname=t2.getText();
				int id=Integer.parseInt(t1.getText());
				String fname=t3.getText();
				int age=Integer.parseInt(t4.getText());
				String city=t5.getText();
				String  phno=t6.getText();
				String class1=t7.getText();												
				
				
				pstmt.setInt(7,id);
				pstmt.setString(1,sname);
				pstmt.setString(2,fname);
				pstmt.setInt(3,age);
				pstmt.setString(4,city);
				pstmt.setString(5,phno);
				pstmt.setString(6,class1);
				

				int n=pstmt.executeUpdate();
				
				if(n>0)
				l8.setText("Update Record......");
				else
				l8.setText("Transaction fail");
				
				con.close();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				 }
	
			}
			else
			 {
				try
				{

				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/student";
				con=DriverManager.getConnection(url,"root","root123");
				
			
				
				String qry="delete from stud where id=?";
				pstmt=con.prepareStatement(qry);
				
				int id=Integer.parseInt(t1.getText());
															
				
				
				pstmt.setInt(1,id);

				int n=pstmt.executeUpdate();
				
				if(n>0)
				l8.setText("delete Record......");
				else
				l8.setText("Transaction fail");
				
				con.close();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				 }

			}
				
	}
}