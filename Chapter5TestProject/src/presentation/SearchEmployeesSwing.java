package presentation;


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class SearchEmployeesSwing extends JFrame implements ActionListener {

	JLabel lb, lb1, lb2, lb3, lb4, lb5;
	JTextField tf1, tf2, tf3, tf4, tf5;
	JButton btn;
	
	SearchEmployeesSwing(){
		
		//Provide a title for the window
		super("Search Employee By ID Window");
		lb5 = new JLabel("Enter an ID:");
		lb5.setBounds(20,20,100,20);
		tf5 = new JTextField(20);
		tf5.setBounds(130,20,100,20);
		
		btn = new JButton("Search");
		btn.setBounds(50,50,100,20);
		btn.addActionListener(this);
		
		lb4 = new JLabel("Enter an ID:");
		lb4.setBounds(20,20,100,20);
		tf4 = new JTextField(20);
		tf4.setBounds(130,20,100,20);
		
		lb3 = new JLabel("Enter an ID:");
		lb3.setBounds(20,20,100,20);
		tf3 = new JTextField(20);
		tf3.setBounds(130,20,100,20);
		
		lb2 = new JLabel("Enter an ID:");
		lb2.setBounds(20,20,100,20);
		tf2 = new JTextField(20);
		tf2.setBounds(130,20,100,20);
		
		lb1 = new JLabel("Enter an ID:");
		lb1.setBounds(20,20,100,20);
		tf1 = new JTextField(20);
		tf1.setBounds(130,20,100,20);
				
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args){
		new SearchEmployeesSwing();
	}
	
}
