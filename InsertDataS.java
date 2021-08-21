import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class InsertDataS extends JFrame implements ActionListener 
{
	JButton Submit;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6,t7;

	MenuBar mb;
	Menu File,About;
	MenuItem Home,About1;
	
	InsertDataS()
	{
		Container c=getContentPane();
		c.setLayout(null);
		
		Submit=new JButton("Submit");
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
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/student";
				con=DriverManager.getConnection(url,"root","root123");
				
			
				
				String qry="insert into stud values(?,?,?,?,?,?,?)";
				pstmt=con.prepareStatement(qry);
				
				String sname=t1.getText();
				int id=Integer.parseInt(t7.getText());
				String fname=t2.getText();
				int age=Integer.parseInt(t3.getText());
				String city=t4.getText();
				String  phno=t5.getText();
				String class1=t6.getText();												
				
				
				pstmt.setInt(1,id);
				pstmt.setString(2,sname);

				pstmt.setString(3,fname);
				pstmt.setInt(4,age);
				pstmt.setString(5,city);
				pstmt.setString(6,phno);
				pstmt.setString(7,class1);

				int n=pstmt.executeUpdate();
				
				if(n>0)
				l7.setText("Record inserted....");
				else
				l7.setText("Transaction fail");
				
				con.close();
			}catch(Exception e){
					System.out.println(e.getMessage());
 }


		
	}
	
}