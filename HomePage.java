import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class HomePage extends JFrame implements ActionListener
{
	JButton adds,operats,shows,adda,operata,showa;
	JLabel Title,Sadd,Soperat,Sshow,Aadd,Aoperat,Ashow,label;
	ImageIcon a,o,s,d,p,h,t;
	
	MenuBar mb;
	Menu File,About;
	MenuItem Home,About1;
	
	HomePage()
	{
		Container c=getContentPane();
		c.setLayout(null);
		
		t=new ImageIcon("student (1).PNG");
		a=new ImageIcon("student.PNG");
		o=new ImageIcon("class.PNG");
		s=new ImageIcon("discussion.PNG");
		d=new ImageIcon("admin.PNG");
		p=new ImageIcon("class.PNG");
		h=new ImageIcon("admin (2).PNG");
		
		adds=new JButton(a);
		operats=new JButton(o);
		shows=new JButton(s);
		adda=new JButton(d);
		operata=new JButton(p);
		showa=new JButton(h);
		
		adds.setBounds(50,200,200,180);
		operats.setBounds(300,200,200,180);
		shows.setBounds(550,200,200,180);
		adda.setBounds(50,450,200,180);
		operata.setBounds(300,450,200,180);
		showa.setBounds(550,450,200,180);
	
		
		Title=new JLabel("Student Registration System",t,JLabel.CENTER);
		Sadd=new JLabel("Add Students");
		Soperat=new JLabel("Operation");
		Sshow=new JLabel("Show Students");
		Aadd=new JLabel("Add Admin");
		Aoperat=new JLabel("Operation");
		Ashow=new JLabel("Show Admin");
		
		Title.setBounds(100,10,550,170);
		Sadd.setBounds(110,300,200,180);
		Soperat.setBounds(370,300,200,180);
		Sshow.setBounds(600,300,200,180);
		Aadd.setBounds(110,550,200,180);
		Aoperat.setBounds(370,550,200,180);
		Ashow.setBounds(600,550,200,180);
		

		adds.setRolloverIcon(a);
		operats.setRolloverIcon(o);
		shows.setRolloverIcon(s);
		adda.setRolloverIcon(d);
		operata.setRolloverIcon(p);
		showa.setRolloverIcon(h);
		
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
		
		c.add(Title);
		c.add(Sadd);
		c.add(Soperat);
		c.add(Sshow);
		c.add(Aadd);
		c.add(Aoperat);
		c.add(Ashow);

		c.add(adds);
		c.add(operats);
		c.add(shows);
		c.add(adda);
		c.add(operata);
		c.add(showa);
		
		Font f=new Font("Arial",Font.BOLD,30);
		Title.setFont(f);

		c.setBackground(Color.BLACK);
		Title.setForeground(Color.WHITE);
		Sadd.setForeground(Color.WHITE);
		Soperat.setForeground(Color.WHITE);
		Sshow.setForeground(Color.WHITE);
		Aadd.setForeground(Color.WHITE);
		Aoperat.setForeground(Color.WHITE);
		Ashow.setForeground(Color.WHITE);
		
		adds.addActionListener(this);
		operats.addActionListener(this);
		shows.addActionListener(this);
		adda.addActionListener(this);
		operata.addActionListener(this);
		showa.addActionListener(this);
		
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
		if (ae.getSource()==adds)
		{					
			InsertDataS n=new InsertDataS();
			n.setVisible(true);
			n.setSize(400,550);
		}
		else if(ae.getSource()==operats)
		{
			Operat n=new Operat();
			n.setVisible(true);
			n.setSize(500,650);
		}
		else if(ae.getSource()==shows)
		{
			Show n=new Show();
			n.setVisible(true);
			n.setSize(700,500);
		}
		else if(ae.getSource()==adda)
		{
			InsertDataA n=new InsertDataA();
			n.setVisible(true);
			n.setSize(400,500);		
		}
		else if(ae.getSource()==operata)
		{
			OperatA n=new OperatA();
			n.setVisible(true);
			n.setSize(500,500);
		}
		else
		{
			ShowA n=new ShowA();
			n.setVisible(true);
			n.setSize(600,400);	
		}
		
		
		
	}
	
	public static void main(String arg[])
	{
		HomePage n=new HomePage();
		n.setVisible(true);
		n.setSize(820,720);
		

	}
}


		

		

		