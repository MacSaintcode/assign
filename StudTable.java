
import java.awt.BorderLayout;
import java.awt.Color;
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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudTable extends template {

    // Statement st2 = Practice_Connector.createStatement();
    String Reg_num, FirstName, LastName, Others, DOB, Gender, Facaulty, Department, Matric_Number;
    JTextField Search;
    JComboBox colname;
    JButton Searching, Refresh;

    Font font = new Font("Comic sans", Font.BOLD, 12);
    String[] Columns = { " FirstName ", " LastName ", " Other Name", " Date Of Birth ", "Gender",
            "Registeration Number", "Facaulty", "Department", "Matric Number" };
    String[] col = { "Registration_Number", "Matric_Number", " Firstname ", " Lastname " };
    DefaultTableModel DM = new DefaultTableModel(Columns, 0);

    StudTable() {

        setTitle("Students Details");
        addWindowListener(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1400, 700);
        setLocationRelativeTo(null);
        GridLayout gl = new GridLayout(0, 6);
        gl.setVgap(20);

        JPanel northpanel = new JPanel();
        add(northpanel, BorderLayout.NORTH);
        northpanel.setBackground(Color.DARK_GRAY);

        northpanel.setLayout(gl);
        Refresh = createbutton("Refresh");
        northpanel.add(Refresh);

        northpanel.add(createlabel("Search By >"));
        colname = createbox(col);
        northpanel.add(colname);

        northpanel.add(createlabel("Search Box>"));
        Search = creattextField();
        northpanel.add(Search);

        Searching = createbutton(".Search.");
        northpanel.add(Searching);

        JTable JT = new JTable(DM);
        JT.setBackground(Color.white);
        JT.setForeground(Color.black);
        JT.setFont(font);
        JScrollPane scroll = new JScrollPane(JT);
        add(scroll);
        setVisible(true);

        // String selectIntoTable = "SELECT studdetails.Firstname,studdetails.lastname,studdetails.Other_names,studdetails.Date_of_Birth,studdetails.Gender,studdetails.Registration_Number,identity.facaulty,identity.department,identity.Matric_Number FROM studdetails inner join identity on studdetails.Registration_Number=identity.Registration_Number order by studdetails.FirstName asc";
        // try {
        //     ResultSet rs = st2.executeQuery(selectIntoTable);
        //     while (rs.next()) {
        //         FirstName = rs.getString("FirstName");
        //         LastName = rs.getString("LastName");
        //         Others = rs.getString("Other_names");
        //         DOB = rs.getString("Date_of_Birth");
        //         Gender = rs.getString("Gender");
        //         Reg_num = rs.getString("Registration_Number");
        //         Facaulty = rs.getString("Facaulty");
        //         Department = rs.getString("Department");
        //         Matric_Number = rs.getString("Matric_Number");

        //         String[] tablearr = { FirstName, LastName, Others, DOB, Gender, Reg_num, Facaulty, Department,
        //                 Matric_Number };

        //         DM.addRow(tablearr);
        //     }
        // } catch (SQLException sqe) {
        //     System.out.println(sqe.getMessage());
        // }

    }

    JLabel createlabel(String txt) {
        JLabel label = new JLabel(txt);
        label.setAlignmentX(20);
        label.setFont(font);
        label.setForeground(Color.yellow);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    JTextField creattextField() {
        JTextField text = new JTextField();
        text.setCaretColor(Color.blue);
        text.setFont(font);
        text.setBackground(Color.white);
        text.setForeground(Color.black);
        return text;
    }

    JComboBox createbox(String arr[]) {
        JComboBox box = new JComboBox(arr);
        box.setBackground(Color.gray);
        box.setForeground(Color.yellow);
        box.setFont(font);

        return box;

    }

    JButton createbutton(String txt) {
        JButton btn = new JButton(txt);
        btn.setFont(font);
        btn.setFocusable(false);
        btn.setBackground(Color.black);
        btn.setForeground(Color.yellow);
        btn.addActionListener(this);
        return btn;
    }

    void callall() {
        int count = DM.getRowCount();
        int i = count - 1;
        while (i >= 0) {
            DM.removeRow(i);
            i--;
        }

        String selectIntoTable = "SELECT studdetails.Firstname,studdetails.lastname,studdetails.Other_names,studdetails.Date_of_Birth,studdetails.Gender,studdetails.Registration_Number,identity.facaulty,identity.department,identity.Matric_Number FROM studdetails inner join identity on studdetails.Registration_Number=identity.Registration_Number order by studdetails.FirstName asc ";

        // try {
        //     ResultSet rs = st2.executeQuery(selectIntoTable);

        //     while (rs.next()) {
        //         FirstName = rs.getString("FirstName");
        //         LastName = rs.getString("LastName");
        //         Others = rs.getString("Other_names");
        //         DOB = rs.getString("Date_of_Birth");
        //         Gender = rs.getString("Gender");
        //         Reg_num = rs.getString("Registration_Number");
        //         Facaulty = rs.getString("Facaulty");
        //         Department = rs.getString("Department");
        //         Matric_Number = rs.getString("Matric_Number");

        //         String[] tablearr = { FirstName, LastName, Others, DOB, Gender, Reg_num, Facaulty, Department,
        //                 Matric_Number };

        //         DM.addRow(tablearr);

        //         Search.setText("");
        //     }
        // } catch (SQLException sqe) {
        //     System.out.println(sqe.getMessage());
        // }
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        if (click.getSource() == Refresh) {
            // callall();
        }
        String select = (String) colname.getSelectedItem();
        if (click.getSource() == Searching) {
            if (select.equals("") || Search.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "COMPLETE THE SEARCH REQUIREMENT!");
                return;

            }
            int count = DM.getRowCount();
            int i = count - 1;
            while (i >= 0) {
                DM.removeRow(i);
                i--;
            }
            String selectIntoTable = String.format(
                    "SELECT studdetails.Firstname,studdetails.lastname,studdetails.Other_names,studdetails.Date_of_Birth,studdetails.Gender,studdetails.Registration_Number,`identity`.facaulty,`identity`.department,`identity`.Matric_Number FROM studdetails inner join `identity` on studdetails.Registration_Number=`identity`.Registration_Number where studdetails.%s like '%s' ",
                    (String) colname.getSelectedItem(), "%" + Search.getText() + "%");

            String selectIntoTable2 = String.format(
                    "SELECT studdetails.Firstname,studdetails.lastname,studdetails.Other_names,studdetails.Date_of_Birth,studdetails.Gender,studdetails.Registration_Number,`identity`.facaulty,`identity`.department,`identity`.Matric_Number FROM studdetails inner join `identity` on studdetails.Registration_Number=`identity`.Registration_Number where identity.%s like '%s' ",
                    (String) colname.getSelectedItem(), "%" + Search.getText() + "%");

            if ((colname.getSelectedItem()).equals("Matric_Number")) {

                // try {
                //     ResultSet rs = st2.executeQuery(selectIntoTable2);

                //     while (rs.next()) {
                //         FirstName = rs.getString("FirstName");
                //         LastName = rs.getString("LastName");
                //         Others = rs.getString("Other_names");
                //         DOB = rs.getString("Date_of_Birth");
                //         Gender = rs.getString("Gender");
                //         Reg_num = rs.getString("Registration_Number");
                //         Facaulty = rs.getString("Facaulty");
                //         Department = rs.getString("Department");
                //         Matric_Number = rs.getString("Matric_Number");

                //         String[] tablearr = { FirstName, LastName, Others, DOB, Gender, Reg_num, Facaulty, Department,
                //                 Matric_Number };
                //         DM.addRow(tablearr);
                //         Search.setText("");

                //     }
                //     if (DM.getRowCount() == 0) {
                //         JOptionPane.showMessageDialog(null, "No Matching Result!");
                //         Search.setText("");
                //         // callall();
                //     }
                // } catch (SQLException sqe) {
                //     System.out.println(sqe.getMessage());
                // }
            } else {
                // try {
                //     ResultSet rs = st2.executeQuery(selectIntoTable);

                //     while (rs.next()) {
                //         FirstName = rs.getString("FirstName");
                //         LastName = rs.getString("LastName");
                //         Others = rs.getString("Other_names");
                //         DOB = rs.getString("Date_of_Birth");
                //         Gender = rs.getString("Gender");
                //         Reg_num = rs.getString("Registration_Number");
                //         Facaulty = rs.getString("Facaulty");
                //         Department = rs.getString("Department");
                //         Matric_Number = rs.getString("Matric_Number");

                //         String[] tablearr = { FirstName, LastName, Others, DOB, Gender, Reg_num, Facaulty, Department,
                //                 Matric_Number };
                //         DM.addRow(tablearr);
                //         Search.setText("");

                //     }
                //     if (DM.getRowCount() == 0) {
                //         JOptionPane.showMessageDialog(null, "No Matching Result!");
                //         Search.setText("");
                //         // callall();
                //     }
                // } catch (SQLException sqe) {
                //     System.out.println(sqe.getMessage());
                // }
            }

        }
    }

    public static void main(String[] args) {
        new StudTable();
    }
	@Override
	public void windowClosed(WindowEvent e) {
        new AdminMenu();

	}

}
