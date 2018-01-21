import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class StationeryShop {

	private JFrame frame;
	private JTextPane textPaneA;
	private JTextPane textPaneB;
	private JTextPane textPaneC;
	private JLabel lblTotal;
	public final double PENCILS = 5.00; //Rand cost of pencils
	public final double PENS = 7.00;    //Rand cost of pens
	public final double RULERS = 10.00; //Rand cost of rules
	private JTextField textBoxReceived;
	private JLabel lblChangeGiven;
	public double total;
	public double payment;
	public double change;
	
	//Calculates the total cost of the items
	public double Calculate(int A, int B, int C) {
		int QtyPencils = A;
		double PencilTotal = PENCILS * QtyPencils;
		int QtyPens = B;
		double PenTotal = PENS * QtyPens;
		int QtyRuler = C;
		double RulerTotal = RULERS * QtyRuler;
		double total = PencilTotal+PenTotal+RulerTotal;
		return total;
		
	}
	
	public double CalculateChange(double tempTotal, double tempPayment) {
		total = tempTotal;
		payment = tempPayment;
		change = payment - total;
        return change;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StationeryShop window = new StationeryShop();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StationeryShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 857, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	    textPaneA = new JTextPane();
	    textPaneA.setText("0");
		textPaneA.setBounds(53, 182, 27, 20);
		frame.getContentPane().add(textPaneA);
		
		textPaneB = new JTextPane();
		textPaneB.setText("0");
		textPaneB.setBounds(53, 221, 27, 20);
		frame.getContentPane().add(textPaneB);
		
		textPaneC = new JTextPane();
		textPaneC.setText("0");
		textPaneC.setBounds(53, 262, 27, 20);
		frame.getContentPane().add(textPaneC);
		
		JLabel lblA = new JLabel("Pencil R5,00");
		lblA.setBounds(110, 182, 84, 14);
		frame.getContentPane().add(lblA);
		
		JLabel lblB = new JLabel("Pen R7,00");
		lblB.setBounds(110, 221, 76, 14);
		frame.getContentPane().add(lblB);
		
		JLabel lblC = new JLabel("Ruler R10,00");
		lblC.setBounds(110, 262, 76, 14);
		frame.getContentPane().add(lblC);
		
		JLabel lblR = new JLabel("Total   R");
		lblR.setBounds(471, 479, 48, 14);
		frame.getContentPane().add(lblR);
		
		lblTotal = new JLabel("0.0");
		lblTotal.setBounds(566, 479, 76, 14);
		frame.getContentPane().add(lblTotal);
		
		JLabel lblQty = new JLabel("QTY");
		lblQty.setBounds(53, 157, 27, 14);
		frame.getContentPane().add(lblQty);
		
		//Displays the total cost
		JButton btnCalculate = new JButton("Calculate Total");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StationeryShop obj1 = new StationeryShop();
				int A = Integer.parseInt(textPaneA.getText());
				int B = Integer.parseInt(textPaneB.getText());
				int C = Integer.parseInt(textPaneC.getText());
				String s1= Double.toString(obj1.Calculate(A,B,C));
				lblTotal.setText(s1);
				
			}
		});
		btnCalculate.setBounds(25, 464, 169, 34);
		frame.getContentPane().add(btnCalculate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPaneA.setText("0");
				textPaneB.setText("0");
				textPaneC.setText("0");
				lblTotal.setText("0.0");
				textBoxReceived.setText("0.0");
				lblChangeGiven.setText("0.0");
			}
		});
		btnReset.setBounds(690, 503, 141, 34);
		frame.getContentPane().add(btnReset);
		
		JButton btnCalculateChange = new JButton("Calculate Change");
		btnCalculateChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StationeryShop obj2 = new StationeryShop();
				double A = Double.parseDouble(lblTotal.getText());
				double B = Double.parseDouble(textBoxReceived.getText());
				String s1 = Double.toString(obj2.CalculateChange(A, B));
				lblChangeGiven.setText(s1);
				String s2 = Double.toString(obj2.CalculateChange(B,A));
//				double stillOwe = (obj2.CalculateChange(B,A));
				if (A>B) {
					JOptionPane.showMessageDialog(null, "Payment incorrect. They still owe R " + s2);
				}
				
				
			}
		});
		btnCalculateChange.setBounds(25, 519, 175, 34);
		frame.getContentPane().add(btnCalculateChange);
		
		JLabel lblMoneyReceived = new JLabel("Money Received   R");
		lblMoneyReceived.setBounds(409, 504, 120, 14);
		frame.getContentPane().add(lblMoneyReceived);
		
		textBoxReceived = new JTextField();
		textBoxReceived.setText("0.0");
		textBoxReceived.setBounds(564, 500, 86, 20);
		frame.getContentPane().add(textBoxReceived);
		textBoxReceived.setColumns(10);
		
		JLabel lblChange = new JLabel("Change   R");
		lblChange.setBounds(459, 529, 60, 14);
		frame.getContentPane().add(lblChange);
		
		lblChangeGiven = new JLabel("0.0");
		lblChangeGiven.setBounds(566, 530, 46, 14);
		frame.getContentPane().add(lblChangeGiven);
	}
}
