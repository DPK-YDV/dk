import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class abc implements ActionListener
{
	Frame f;
	Label l1,l2;
	TextField t1,t2;
	Button b1;
	Connection co;
	ResultSet rs;
    PreparedStatement st;
	abc()
	{
		Frame f=new Frame("login");
		Label l1=new Label("UserId");
		Label l2=new Label("pass");
		TextField t1=new TextField();
		TextField t2=new TextField();
		Button b1=new Button("Login");
		
		f.setVisible(true);
		f.setSize(400,400);
		f.setLayout(null);
		
		l1.setBounds(50,70,80,50);
		l2.setBounds(50,170,80,50);
		t1.setBounds(180,70,120,50);
		t2.setBounds(180,170,120,50);
		b1.setBounds(180,260,70,50);
		
		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(t2);
		f.add(b1);
		
		b1.addActionListener(this);
		
		try{
 Class.forName("com.mysql.cj.jdbc.Driver");
 co = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
 }
 catch(ClassNotFoundException e){
 System.out.println(e);
 }
 catch(SQLException e){
 System.out.println(e);
 }
 }
 
 public void actionPerformed(ActionEvent ae)
 {
	 if(ae.getSource()==b1)
	 {
	String s1=t1.getText();
	String s2=t2.getText();
	
	try{
	  st=co.prepareStatement("insert into dk values (?,?)");
	  st.setString(1,s1);
	  st.setInt(2,Integer.parseInt(s2));
	  
	  rs=st.executeQuery();
	  st.close();
	  JOptionPane.showMessageDialog(b1,"Data has been saved.");
	  t1.setText("");
	  t2.setText("");
	
	  
		
	}catch(SQLException e)
	{System.out.print("in err"+e);}
	 
 }
 }

	public static void main(String[] ar)
	{
		abc a=new abc();
	}
}
			
			