
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import java.sql.Connection;

public class login extends template {

	JTextField userNameField;
	JPasswordField passwordField;
	JRadioButton show, hide;
	JButton submit, clear;
	String tick = "";
	// Statement st2 = Practice_Connector.createStatement();

	public login() {
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(bgcolor);
		add(centerPanel);

		centerPanel.setLayout(new GridLayout(5, 1));

		centerPanel.add(createLabel("User Name"));
		userNameField = createtextfield();
		centerPanel.add(userNameField);

		JPanel combines = new JPanel();
		combines.setBackground(bgcolor);

		show = checkButton("Show");
		combines.add(show);

		hide = checkButton("Hide");
		combines.add(hide);

		ButtonGroup groupie = new ButtonGroup();
		groupie.add(hide);
		groupie.add(show);

		hide.addItemListener(this);
		show.addItemListener(this);

		centerPanel.add(createLabel("Password"));
		passwordField = createPasswordField();
		centerPanel.add(passwordField);
		centerPanel.add(combines);
		hide.setSelected(true);

		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.BLUE);
		add(southPanel, BorderLayout.SOUTH);

		clear = createbutton("Reset");
		southPanel.add(clear);

		submit = createbutton("Submit");
		southPanel.add(submit);

		addWindowListener(this);
		setDefaultCloseOperation(0);
		setTitle("ADMINISTRATIVE LOGIN");
		setVisible(true);
		pack();
		setResizable(false);
		setSize(500, 450);
		setLocationRelativeTo(null);

	}

	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clear) {
			userNameField.setText("");
			passwordField.setText("");
			return;

		}
		if (e.getSource() == submit) {
			new AdminMenu();
			JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL");
			dispose();
		// if (userNameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
		// JOptionPane.showMessageDialog(null, "Field Cannot Be Blank!!");
		// userNameField.setText("");
		// passwordField.setText("");
		// return;
		// }
		// String uname = userNameField.getText();
		// String password = passwordField.getText();

		// String query = String.format(
		// "SELECT username, password FROM administrative where Username = '%s' and
		// password = '%s'", uname,
		// password);
		// try {
		// ResultSet rs = st2.executeQuery(query);
		// if (rs.next()) {
		// String un = rs.getString("username");
		// String pwFromDB = rs.getString("Password");
		// if (password.equals(pwFromDB) && uname.equals(un)) {
		// tick = "done";
		// dispose();
		// } else {
		// JOptionPane.showMessageDialog(null, "Invalid Login!");
		// userNameField.setText("");
		// passwordField.setText("");
		// return;
		// }

		// } else {

		// JOptionPane.showMessageDialog(null, "User Does Not Exist!");
		// userNameField.setText("");
		// passwordField.setText("");
		// return;

		// }

		// } catch (SQLException se) {
		// System.out.println("Error occured: " + se.getMessage());
		// }
		}

	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure",
                "Confirmation!", 0, 3);
        if (result == JOptionPane.YES_OPTION) {
            dispose();
        }
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (show.isSelected()) {
			passwordField.setEchoChar((char) 0);
		}
		if (hide.isSelected()) {
			passwordField.setEchoChar('*');
		}
	}

	public static void main(String[] args) {
		new login();
	}

}
