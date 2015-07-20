package com.capgemini.taxi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserGui {

	private JFrame frame;
	private JTextField xCoordinate;
	private JTextField yCoordinate;
	private JTextField maxRadius;
	private JTextField maxTaxiNumber;
	private JTable avilableTaxitable;

	private boolean isUserAdded = false;
	private DefaultTableModel taxiTabModel;

	private User u;

	/**
	 * Launch the application.
	 */
	public static void createGui(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGui window = new UserGui();
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
	public UserGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 652, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		xCoordinate = new JTextField();
		xCoordinate.setText("500");
		xCoordinate.setBounds(12, 38, 76, 22);
		frame.getContentPane().add(xCoordinate);
		xCoordinate.setColumns(10);

		yCoordinate = new JTextField();
		yCoordinate.setText("500");
		yCoordinate.setColumns(10);
		yCoordinate.setBounds(138, 38, 76, 22);
		frame.getContentPane().add(yCoordinate);

		maxRadius = new JTextField();
		maxRadius.setText("1000");
		maxRadius.setColumns(10);
		maxRadius.setBounds(277, 38, 76, 22);
		frame.getContentPane().add(maxRadius);

		maxTaxiNumber = new JTextField();
		maxTaxiNumber.setText("10");
		maxTaxiNumber.setColumns(10);
		maxTaxiNumber.setBounds(422, 38, 76, 22);
		frame.getContentPane().add(maxTaxiNumber);

		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(!isUserAdded){
						isUserAdded = true;
						u = new User(Integer.parseInt(xCoordinate.getText()), Integer.parseInt(yCoordinate.getText()),
								Integer.parseInt(maxRadius.getText()), Integer.parseInt(maxTaxiNumber.getText()));
						u.setTaxiTabModel(taxiTabModel);				
						Server.addUser(u);
						return;
					}
					u.updateUserData(Integer.parseInt(xCoordinate.getText()), Integer.parseInt(yCoordinate.getText()),
								Integer.parseInt(maxRadius.getText()), Integer.parseInt(maxTaxiNumber.getText()));

				} catch (NumberFormatException e) {
					System.out.println("Bledna dane wejsciowe!");
				}
			}
		});
		btnFind.setBounds(525, 37, 97, 25);
		frame.getContentPane().add(btnFind);

		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 9, 76, 25);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblY = new JLabel("Y");
		lblY.setHorizontalAlignment(SwingConstants.CENTER);
		lblY.setBounds(138, 9, 76, 25);
		frame.getContentPane().add(lblY);

		JLabel lblRadius = new JLabel("Radius [m]");
		lblRadius.setHorizontalAlignment(SwingConstants.CENTER);
		lblRadius.setBounds(277, 9, 76, 25);
		frame.getContentPane().add(lblRadius);

		JLabel lblTaxiNumber = new JLabel("Taxi number");
		lblTaxiNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaxiNumber.setBounds(422, 9, 76, 25);
		frame.getContentPane().add(lblTaxiNumber);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 86, 610, 329);
		frame.getContentPane().add(scrollPane);

		avilableTaxitable = new JTable();
		avilableTaxitable.setModel(taxiTabModel = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Nr", "Taxi ID", "xCoordinate", "yCoordinate", "Distance"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		avilableTaxitable.getColumnModel().getColumn(0).setResizable(false);
		avilableTaxitable.getColumnModel().getColumn(0).setPreferredWidth(24);
		avilableTaxitable.getColumnModel().getColumn(1).setResizable(false);
		avilableTaxitable.getColumnModel().getColumn(2).setResizable(false);
		avilableTaxitable.getColumnModel().getColumn(3).setResizable(false);
		avilableTaxitable.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(avilableTaxitable);

	}
}
