import java.awt.*;

import javax.swing.border.EmptyBorder;

import javax.swing.*;

public class SleepCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBirthDay;
	private JTextField textFieldBirthMonth;
	private JTextField textFieldBirthYear;
	private JTextField textFieldPresentDay;
	private JTextField textFieldPresentMonth;
	private JTextField textFieldPresentYear;
	private int pastDay, pastMonth, pastYear, presentDay, presentMonth, presentYear;
	private boolean robust;
	private JLabel lblAliveDays, lblSleptHours;
	public int totalDays, totalHours;


	public static void main(String[] args) {
		System.out.println("hello wrld");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SleepCalculator frame = new SleepCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void btnCalculate(java.awt.event.ActionEvent evt){
		totalDays=0;
		totalHours=0;
		robust=true;
		
		try {
			pastDay = Integer.parseInt(textFieldBirthDay.getText());
			pastMonth = Integer.parseInt(textFieldBirthMonth.getText());
			pastYear = Integer.parseInt(textFieldBirthYear.getText());
			presentDay = Integer.parseInt(textFieldPresentDay.getText());
			presentMonth = Integer.parseInt(textFieldPresentMonth.getText());
			presentYear = Integer.parseInt(textFieldPresentYear.getText()); 
			
		}
		catch(NumberFormatException e) {
			robust = false;
		}
		
		if(pastDay < 1 || pastDay > 30 || presentDay < 1 || presentDay > 30) {
			robust = false;
		}
		
		if(pastMonth < 1 || pastMonth > 12 || presentMonth < 1 || presentMonth > 12) {
			robust = false;
		}
		if(pastYear < 0 || presentYear <0) {
			robust = false;
		}
		if(presentYear < pastYear) {
			robust = false;
		}
		if(presentYear == pastYear) {
			if(presentMonth < pastMonth)
				robust = false;
			else if(presentMonth == pastMonth) {
				if(presentDay < pastDay)
					robust=false;
			}
		}
	
		
		totalDays += presentDay;
		totalDays += presentMonth*30;
		totalDays += presentYear*365;
		totalDays -= pastDay;
		totalDays -= pastMonth *30;
		totalDays -= pastYear*365;
		totalHours+= totalDays*8;
	
		
		}
	public SleepCalculator() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAliveDays = new JLabel(""); 
		lblSleptHours = new JLabel("");
		
		JLabel lblTitle = new JLabel("Sleep Calculator");
		lblTitle.setBounds(224, 11, 86, 14);
		contentPane.add(lblTitle);
		
		JLabel lblBirthdate = new JLabel("Enter Your Birthdate");
		lblBirthdate.setBounds(23, 64, 128, 14);
		contentPane.add(lblBirthdate);
		
		JLabel lblPresentDate = new JLabel("Enter Today's Date");
		lblPresentDate.setBounds(298, 64, 128, 14);
		contentPane.add(lblPresentDate);
		
		JLabel lblBirthDay = new JLabel("Day");
		lblBirthDay.setBounds(23, 121, 46, 14);
		contentPane.add(lblBirthDay);
		
		JLabel lblBirthMonth = new JLabel("Month");
		lblBirthMonth.setBounds(23, 166, 46, 14);
		contentPane.add(lblBirthMonth);
		
		JLabel lblBirthYear = new JLabel("Year");
		lblBirthYear.setBounds(23, 213, 46, 14);
		contentPane.add(lblBirthYear);
		
		JLabel lblPresentDay = new JLabel("Day");
		lblPresentDay.setBounds(298, 121, 46, 14);
		contentPane.add(lblPresentDay);
		
		JLabel lblPresentMonth = new JLabel("Month");
		lblPresentMonth.setBounds(298, 166, 46, 14);
		contentPane.add(lblPresentMonth);
		
		JLabel lblPresentYear = new JLabel("Year");
		lblPresentYear.setBounds(298, 213, 46, 14);
		contentPane.add(lblPresentYear);
		
		
		
		JButton btnCalculateTitle = new JButton("Calculate");
		btnCalculateTitle.setBounds(23, 311, 89, 23);
		contentPane.add(btnCalculateTitle);
		btnCalculateTitle.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCalculate(evt);
				
				if(robust) {
					lblAliveDays.setBounds(173, 325, 280, 44);
					contentPane.add(lblAliveDays);
					lblAliveDays.setText(Integer.toString(totalDays));
				}
				else {
					lblAliveDays.setBounds(173, 325, 280, 44);
					contentPane.add(lblAliveDays);
					lblAliveDays.setText("IMPROPER INPUT");
				}
				
				if(robust) {
					lblSleptHours.setBounds(173, 409, 290, 29);
					contentPane.add(lblSleptHours);
					lblSleptHours.setText(Integer.toString(totalHours));
				}
				else {
					lblSleptHours.setBounds(173, 409, 290, 29);
					contentPane.add(lblSleptHours);
					lblSleptHours.setText("IMPROPER INPUT");
				}
				
			}
		});
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(23, 364, 89, 23);
		contentPane.add(btnExit);
		btnExit.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});
		
		
		
		textFieldBirthDay = new JTextField();
		textFieldBirthDay.setBounds(79, 118, 86, 20);
		contentPane.add(textFieldBirthDay);
		textFieldBirthDay.setColumns(10);

		
		textFieldBirthMonth = new JTextField();
		textFieldBirthMonth.setColumns(10);
		textFieldBirthMonth.setBounds(79, 163, 86, 20);
		contentPane.add(textFieldBirthMonth);
		
		
		textFieldBirthYear = new JTextField();
		textFieldBirthYear.setColumns(10);
		textFieldBirthYear.setBounds(79, 210, 86, 20);
		contentPane.add(textFieldBirthYear);
		
		
		textFieldPresentDay = new JTextField();
		textFieldPresentDay.setColumns(10);
		textFieldPresentDay.setBounds(337, 118, 86, 20);
		contentPane.add(textFieldPresentDay);
		
		
		textFieldPresentMonth = new JTextField();
		textFieldPresentMonth.setColumns(10);
		textFieldPresentMonth.setBounds(337, 163, 86, 20);
		contentPane.add(textFieldPresentMonth);
		
		
		textFieldPresentYear = new JTextField();
		textFieldPresentYear.setColumns(10);
		textFieldPresentYear.setBounds(337, 210, 86, 20);
		contentPane.add(textFieldPresentYear);

		
		
	}
}
