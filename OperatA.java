import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class OperatA extends JFrame implements ActionListener
{
	JButton Submit,delete;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4;

	MenuBar mb;
	Menu File,About;
	MenuItem Home,About1;
	
	OperatA()
	{
		Container c=getContentPane();
		c.setLayout(null);
		
		Submit=new JButton("Update");
		Submit.setBounds(80,330,100,30);
		delete=new JButton("Delete");
		delete.setBounds(300,330,100,30);
		
		l1=new JLabel("ID");
		l2=new JLabel("Name");
		l3=new JLabel("Email");
		l4=new JLabel("Password");
		l5=new JLabel("");

		l1.setBounds(50,50,200,50);
		l2.setBounds(50,110,200,50);
		l3.setBounds(50,170,200,50);
		l4.setBounds(50,230,200,50);
		l5.setBounds(50,280,200,50);
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		
		t1.setBounds(150,60,150,30);
		t2.setBounds(150,120,150,30);
		t3.setBounds(150,180,150,30);
		t4.setBounds(150,240,150,30);
		
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
		c.add(delete);
	
		
		c.setBackground(Color.BLACK);
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);
		l5.setForeground(Color.WHITE);
		
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
				
			
				
				String qry="update admin set aname=?,email=?,password=?where id=?";
				pstmt=con.prepareStatement(qry);
				
				String aname=t2.getText();
				int id=Integer.parseInt(t1.getText());
				String email=t3.getText();
				String password=t4.getText();
				
				
				pstmt.setInt(4,id);
				pstmt.setString(1,aname);
				pstmt.setString(2,email);
				pstmt.setString(3,password);
				

				int n=pstmt.executeUpdate();
				
				if(n>0)
				l5.setText("Update Record......");
				else
				l5.setText("Transaction fail");
				
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
				
			
				
				String qry="delete from admin where id=?";
				pstmt=con.prepareStatement(qry);
				
				int id=Integer.parseInt(t1.getText());
															
				
				
				pstmt.setInt(1,id);

				int n=pstmt.executeUpdate();
				
				if(n>0)
				l5.setText("delete Record......");
				else
				l5.setText("Transaction fail");
				
				con.close();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				 }

			}
				
	}

		
}