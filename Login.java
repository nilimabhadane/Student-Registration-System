import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Login extends JFrame implements ActionListener
{
	JButton b1,b2;
	JLabel l1,l2,l3,l4;
	JTextField jt;
	JPasswordField jp;
	
	Login()
	{
		Container c=getContentPane();
		c.setLayout(null);
		
		l1=new JLabel("Email");
		jt=new JTextField(10);
		jt.setBounds(150,125,150,30);
	
		l1.setBounds(30,100,200,80);
		
		l2=new JLabel("Password");
		jp=new JPasswordField(10);
		jp.setBounds(150,170,150,30);
	
		l2.setBounds(30,150,200,80);
	
		b1=new JButton("Login");
		b1.setBounds(50,240,80,30);
	
		b2=new JButton("Cancel");
		b2.setBounds(200,240,80,30);
		 
		ImageIcon img1=new ImageIcon("Login.PNG");
		l3=new JLabel("",img1,JLabel.CENTER);
		l3.setBounds(150,20,100,80);

		c.setBackground(Color.BLACK);
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		

		c.add(l3);
		c.add(l1);
		c.add(jt);
		c.add(l2);
		c.add(jp);
		c.add(b1);
		c.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
			
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
		if (ae.getSource()==b1)
		{
			HomePage n=new HomePage();
			n.setVisible(true);
			n.setSize(820,720);
		}
		else
		{
			jt.setText("");
			jp.setText("");
		}
	}
	
	public static void main(String arg[])
	{
		Login g;
		g=new Login();
		
		g.setVisible(true);
		g.setSize(400,400);
	

	}
}
	