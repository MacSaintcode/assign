
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class registerstudent extends template {

    JButton reset, submit;
    JTextField Reg_num;
    JComboBox<String> department, faculty;
    String tick = "", reg;
    public Statement st2;

    // registerstudent(String regnum, Statement st) {
    // st2 = st;
    // reg = regnum;
    registerstudent() {

        JPanel centerpanel = new JPanel();
        centerpanel.setBackground(bgcolor);
        add(centerpanel);

        GridLayout gl = new GridLayout(2, 2);
        gl.setVgap(10);
        centerpanel.setLayout(gl);

        centerpanel.add(createlabel("Facaulty"));
        faculty = createjbox();
        centerpanel.add(faculty);
        faculty.addItemListener(this);

        centerpanel.add(createlabel("Department"));
        department = createjbox();
        centerpanel.add(department);

        JPanel southpanel = new JPanel();
        southpanel.setBackground(Color.gray);
        add(southpanel, BorderLayout.SOUTH);

        reset = createbutton("Reset");
        southpanel.add(reset);

        submit = createbutton("Submit");
        southpanel.add(submit);

        addWindowListener(this);

        generate();
        setDefaultCloseOperation(0);
        setTitle("Registeration cont.");
        pack();
        setResizable(false);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {
            faculty.setSelectedItem("CHOOSE A FACULTY");
            return;

        } else if (e.getSource() == submit) {
            if (faculty.getSelectedItem().equals("CHOOSE A FACULTY")) {
                JOptionPane.showMessageDialog(null, "Field cannot be Blank!");
                return;

            }
            // if (!(Reg_num.getText().length() == 8)) {
            // JOptionPane.showMessageDialog(null, "Invalid Registration Number!");
            // Reg_num.setText("");
            // return;
            // }

            String selectIntoTable1 = String.format("SELECT Registration_Number FROM Identity");
            String selectIntoTable = String.format("SELECT Registration_Number FROM studdetails");
            String match, matches;
            Boolean got = false;
            ResultSet rs;
            // try {
            // rs = st2.executeQuery(selectIntoTable);
            // while (rs.next()) {
            // matches = rs.getString("Registration_Number");
            // if (reg.equalsIgnoreCase(matches)) {
            // got = true;
            // break;
            // }
            // }
            // if (got.equals(false)) {
            // JOptionPane.showMessageDialog(null, "THIS REGISTRATION NUMBER HAS NOT BEEN
            // REGISTERED!");
            // // Reg_num.setText("");
            // department.setSelectedItem("");
            // faculty.setSelectedItem("CHOOSE A FACAULTY");
            // return;

            // }
            // rs = st2.executeQuery(selectIntoTable1);
            // while (rs.next()) {
            // match = rs.getString("Registration_Number");

            // if (reg.equalsIgnoreCase(match)) {
            // JOptionPane.showMessageDialog(null,
            // "THIS REGISTRATION NUMBER OWNER HAS COMPLETED THE REGISTRATION PROCESS!");
            // // Reg_num.setText("");
            // faculty.setSelectedItem("CHOOSE A FACAULTY");
            // return;
            // }

            // }
            // } catch (SQLException ex) {
            // System.out.println("Error occured....." + ex.getMessage() + "\tQuery has been
            // terminated");
            // }

            String InputQuery = String.format("INSERT INTO identity VALUES('%s','%s','%s','%s')",
                    reg, null, (String) faculty.getSelectedItem(), (String) department.getSelectedItem());

            selectIntoTable = String.format("SELECT Matric_Number FROM Identity");

            String matric = null;
            String matrics = null;

            // try {
            // String fa = (String) faculty.getSelectedItem();
            // String da = (String) department.getSelectedItem();

            // rs = st2.executeQuery(selectIntoTable);
            // while (true) {
            // boolean res = false;
            // Random num = new Random();

            // String fl = fa.substring(0, 2).toUpperCase();
            // String ll = da.substring(0, 2).toUpperCase();
            // int fg = num.nextInt(100000);

            // matric = fl + String.valueOf(fg) + ll;

            // while (rs.next()) {
            // matrics = rs.getString("Matric_Number");

            // if (matrics.equalsIgnoreCase(matric)) {
            // res = true;
            // break;
            // }

            // }
            // if (res = true) {
            // break;
            // } else {
            // continue;
            // }
            // }

            // } catch (SQLException sq) {
            // System.out.println("Error occured....." + sq.getMessage() + "\tQuery has been
            // terminated");
            // }

            String InputQuery2 = String.format(
                    "UPDATE identity SET Matric_Number = '%s' WHERE Registration_Number = '%s' ", (String) matric,
                    reg);
            // try {
            // st2.execute(InputQuery);
            // System.out.println("Query Executed Sucessfully");
            // st2.execute(InputQuery2);
            // JOptionPane.showMessageDialog(null, "Registered Sucessfully!! ");
            // JOptionPane.showMessageDialog(null, "Your Matric Number is" + matric);
            // System.out.println("Query Executed Sucessfully");
            // // Reg_num.setText("");
            // faculty.setSelectedItem("CHOOSE A FACAULTY");
            // dispose();
            // return;

            // } catch (SQLException sq) {
            // System.out.println("Error occured....." + sq.getMessage() + "\tQuery has been
            // terminated");
            // }
            dispose();
        }
        
    }

    void generate() {
        String gots;
        department.setEnabled(false);
        faculty.removeAllItems();
        faculty.addItem("CHOOSE A FACULTY");
        faculty.addItem("Science");

        String selectIntoTable = String.format("SELECT Facaultyname FROM Facaulty");
        // try {
        // ResultSet rs = st2.executeQuery(selectIntoTable);
        // while (rs.next()) {
        // gots = rs.getString("Facaultyname");
        // faculty.addItem(gots);
        // }
        // System.out.println("Completed");
        // } catch (SQLException sqe) {
        // System.out.println(sqe.getMessage());
        // }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        String select = (String) faculty.getSelectedItem();
        // JComboBox comboBox = (JComboBox) e.getSource();
        String got;

        department.removeAllItems();
        if (select.equalsIgnoreCase("CHOOSE A FACULTY")) {
            department.setEnabled(false);
        } else {
            department.setEnabled(true);
            department.removeAllItems();
            department.addItem("Science");
            department.addItem("Science");
            department.addItem("Science");
            String selectIntoTable = String.format("SELECT %s FROM department", select);
            // try {
            // ResultSet rs = st2.executeQuery(selectIntoTable);
            // while (rs.next()) {
            // got = rs.getString(select);
            // department.addItem(got);
            // }
            // } catch (SQLException sqe) {
            // System.out.println(sqe.getMessage());
            // }
        }
    }

    @Override
    public void windowActivated(WindowEvent arg0) {

    }

    @Override
    public void windowClosed(WindowEvent args) {
        new AdminMenu();
    }

    @Override
    public void windowClosing(WindowEvent arg0) {
        int result = JOptionPane.showConfirmDialog(null, "Do You Want To Terminate Your Registration",
                "Confirmation!", 0, 3);
        if (result == JOptionPane.YES_OPTION) {
            ResultSet rs;
            // String gotpin, gotten = "";
            // String getpin = String.format("select * from identity");
            String deletefromTable = String.format(
                    "delete from studdetails where Registration_Number='%s'", reg);
            // try {
            // // rs = st2.executeQuery(getpin);
            // // while (rs.next()) {
            // // gotpin = rs.getString("Registration_Number");
            // // if (gotpin.equals(reg)) {
            // // gotten = "found";
            // // }
            // // }
            // // if (gotten.equals("found")) {
            // // } else {
            // st2.execute(deletefromTable);
            JOptionPane.showMessageDialog(null, "Registration Rolledback and Terminated!", "Termination!", 2);
            // // }
            // } catch (SQLException ea) {
            // System.err.println("Query Terminated " + ea.getMessage());
            // }
            this.dispose();

        }

    }

    public static void main(String[] args) {
        // Input_Practice call = new Input_Practice();
        new registerstudent();
    }

}