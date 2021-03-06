package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import models.Employee;
import bll.EmployeeBLL;

public class InsertEmployeeSwing extends JFrame implements ActionListener {
	JLabel jlabelRowsAffected, jlabelBanana, jlabelMessage, jlabelTitle, jlabelDepartmentCode, jlabelFirstName, jlabelLastName, jlabelEmployeID;
	JTextField jtextfieldRowsAffected, jtextfieldTitle, jtextfieldDepartmentCode, jtextfieldFirstName, jtextfieldLastName, jtextfieldEmployeID;
	JButton jbuttonSearch;
	
	InsertEmployeeSwing(){
		
		//Provide a title for the window
		super("Search Employee By ID Window");

		jlabelEmployeID = new JLabel("Employee ID:");
		jlabelEmployeID.setBounds(20,90,100,20);
		jtextfieldEmployeID = new JTextField(20);
		jtextfieldEmployeID.setBounds(130,90,100,20);
		
		jbuttonSearch = new JButton("Insert");
		jbuttonSearch.setBounds(130,240,100,20);
		jbuttonSearch.addActionListener(this);
		
		jlabelMessage = new JLabel("Insert Employee Into Database");
		jlabelMessage.setBounds(30, 20, 450, 30); //(30,80,450,30);
		jlabelMessage.setForeground(Color.red);
		jlabelMessage.setFont(new Font("Serif", Font.BOLD, 20));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		
		jlabelLastName = new JLabel("Last Name:");
		jlabelLastName.setBounds(20,120,100,20);
		jtextfieldLastName = new JTextField(20);
		jtextfieldLastName.setBounds(130,120,200,20);
		
		jlabelFirstName = new JLabel("First Name:");
		jlabelFirstName.setBounds(20,150,100,20);
		jtextfieldFirstName = new JTextField(20);
		jtextfieldFirstName.setBounds(130,150,200,20);
		
		jlabelDepartmentCode = new JLabel("Department:");
		jlabelDepartmentCode.setBounds(20,210,100,20);
		jtextfieldDepartmentCode = new JTextField(20);
		jtextfieldDepartmentCode.setBounds(130,210,100,20);
		
		jlabelTitle = new JLabel("Title:");
		jlabelTitle.setBounds(20,180,100,20);
		jtextfieldTitle = new JTextField(20);
		jtextfieldTitle.setBounds(130,180,200,20);
		
		jlabelRowsAffected = new JLabel("Rows Affected:");
		jlabelRowsAffected.setBounds(20,270,100,20);
		jtextfieldRowsAffected = new JTextField(20);
		jtextfieldRowsAffected.setBounds(130,270,20,20);
		
		// add the image label
		jlabelBanana = new JLabel("Banana");
		jlabelBanana.setBounds(400, 25, 41, 50);
        ImageIcon ii = new ImageIcon(this.getClass().getResource("banana2.gif"));               
		jlabelBanana.setIcon(ii);
        
		setLayout(null);
		
		add(jlabelEmployeID);
		add(jtextfieldEmployeID);
		add(jbuttonSearch);
		add(jlabelMessage);
		add(jlabelLastName);
		add(jtextfieldLastName);
		add(jlabelFirstName);
		add(jtextfieldFirstName);
		add(jlabelDepartmentCode);
		add(jtextfieldDepartmentCode);
		add(jlabelTitle);
		add(jtextfieldTitle);
		add(jlabelBanana);
		add(jlabelRowsAffected);
		add(jtextfieldRowsAffected);

		jtextfieldRowsAffected.setEditable(false);
		validate();
		repaint();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		EmployeeBLL employeeBLL = new EmployeeBLL();
		Employee emp = new Employee();
		emp.setEmployeeID(Integer.parseInt(jtextfieldEmployeID.getText()));
		emp.setLastName(jtextfieldLastName.getText());
		emp.setFirstName(jtextfieldFirstName.getText());
		emp.setTitle(jtextfieldTitle.getText());
		emp.setDepartmentCode(jtextfieldDepartmentCode.getText());
		int rows = employeeBLL.insertNewEmployee(emp);
		
		jtextfieldRowsAffected.setText(Integer.toString(rows));
//				Employee emp = employeeBLL.selectEmployeeByID(Integer.parseInt(jtextfieldEmployeID.getText()));
//		if(emp != null){
//			jtextfieldLastName.setText(emp.getLastName());
//			jtextfieldFirstName.setText(emp.getFirstName());
//			jtextfieldDepartmentCode.setText(emp.getDepartmentCode());
//			jtextfieldTitle.setText(emp.getTitle());
//		}
	}

	public static void main(String[] args){
		new InsertEmployeeSwing();
	}
}
