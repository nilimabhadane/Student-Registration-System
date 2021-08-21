import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class ShowA extends JFrame implements ActionListener
{
	JButton Submit;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4;

	MenuBar mb;
	Menu File,About;
	MenuItem Home,About1;
	
	ShowA()
	{
		Container c=getContentPane();
		c.setLayout(null);
		
		Submit=new JButton("Show");
		Submit.setBounds(150,300,100,30);
		
		l1=new JLabel("Name");
		l2=new JLabel("Email");
		l3=new JLabel("Password");
		l4=new JLabel("Id");
		l5=new JLabel("");

		l1.setBounds(50,50,200,50);
		l2.setBounds(50,110,200,50);
		l3.setBounds(50,170,200,50);
		l4.setBounds(50,10,200,50);
		l5.setBounds(50,230,200,50);
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		
		t1.setBounds(150,60,150,30);
		t2.setBounds(150,120,150,30);
		t3.setBounds(150,180,150,30);
		t4.setBounds(150,10,150,30);
		
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
		c.add(Submit);
		
		c.setBackground(Color.BLACK);
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);
		l5.setForeground(Color.WHITE);

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
				
				int id=Integer.parseInt(t4.getText());
				String qry="select * from admin where id=id";
				rs=stmt.executeQuery(qry);
				 
				while(rs.next())
				{
				String a=rs.getString("aname");
				String e=rs.getString("email");
				String p=rs.getString("password");
				
				t1.setText(a);
				t2.setText(e);
				t3.setText(p);
				}	
				con.close();
			}catch(Exception e){
					System.out.println(e.getMessage());
					 }


	

		
	}
	
}