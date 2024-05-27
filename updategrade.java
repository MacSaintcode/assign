import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

public class updategrade extends template {
    // Statement st2 = Practice_Connector.createStatement();
    JButton grade;
    JComboBox<String> addCourse;
    JTextField matrix,score;
    String gots;

    updategrade() {
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(bgcolor);
        add(centerPanel);
        GridLayout ri=new GridLayout(3, 3);
        ri.setVgap(7);
        centerPanel.setLayout(ri);

        centerPanel.add(createLabel("Matric Number*"));
        matrix = createtextfield();
        centerPanel.add(matrix);

        centerPanel.add(createLabel("Select Course*"));
        addCourse = createjbox();
        centerPanel.add(addCourse);

        centerPanel.add(createLabel("Student Score*"));
        score = createtextfield();
        centerPanel.add(score);

        JPanel southpanel = new JPanel();
        southpanel.setBackground(Color.gray);
        add(southpanel, BorderLayout.SOUTH);

        grade = createbutton("Grade");
        southpanel.add(grade);

        addCourse.setEnabled(false);
        addWindowsListener(this)
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Update Grades");
        setVisible(true);
        pack();
        setResizable(false);
        setSize(500, 250);
        setLocationRelativeTo(null);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        inputchecker();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        inputchecker();
    }

    void inputchecker() {
        // Boolean check = false;
        if (matrix.getText().length() == 8) {
            String selectIntoTable = String.format("SELECT Matric_Number FROM identity");
            matrix.setEnabled(false);
            // try {
            // ResultSet rs = st2.executeQuery(selectIntoTable);
            // while (rs.next()) {
            // gots = rs.getString("Matric_Number");
            // if (gots.equalsIgnoreCase(matrix.getText())) {
            // check = true;
            // break;
            // }
            // }
            // System.out.println("Completed");
            // } catch (SQLException sqe) {
            // System.out.println(sqe.getMessage());
            // }
            // if (!check) {
            // JOptionPane.showMessageDialog(null, "INVALID MATRIC NUMBER", "INFORMATION",
            // 2);
            // } else {

            generate();
            // }
        } else {
            addCourse.setEnabled(false);
        }
    }

    void generate() {
        String gots;
        addCourse.setEnabled(true);
        addCourse.removeAllItems();

        String selectIntoTable = String.format("SELECT CourseCode FROM studentscourseandgrades WHERE Matric_Number=%s",
                matrix.getText());
        // try {
        // ResultSet rs = st2.executeQuery(selectIntoTable);
        // while (rs.next()) {
        // gots = rs.getString("CourseCode");
        // addCourse.addItem(gots);
        // }
        // System.out.println("Completed");
        // } catch (SQLException sqe) {
        // System.out.println(sqe.getMessage());
        // }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(score.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "ENTER STUDENT SCORE", "INFORMATION",
            2);
        }

        String InputQuery = String.format(
                "UPDATE studentscourseandgrades SET Grades = '%s' WHERE Matric_Number = '%s' AND CourseCode = '%s' ", 2,
                matrix.getText(), (String) addCourse.getSelectedItem());
        // try {
        // st2.execute(InputQuery);
        // System.out.println("Query Executed Sucessfully");
        matrix.setText("");
        return;

        // } catch (SQLException sq) {
        // System.out.println("Error occured....." + sq.getMessage() + "\tQuery has been
        // terminated");
        // }
    }

    public static void main(String[] args) {
        new updategrade();
    }

    @Override
    public void windowClosing(WindowEvent e) {
            new updateui();
            dispose();
    }
}