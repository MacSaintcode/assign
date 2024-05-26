import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class updategrade extends template {
// Statement st2 = Practice_Connector.createStatement();
    JButton grade;
    JComboBox addCourse;
    JTextField matrix;

    updategrade() {
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(bgcolor);
        add(centerPanel);
        centerPanel.setLayout(new GridLayout(2, 2));

        centerPanel.add(createLabel("Matric Number*"));
        matrix = createtextfield();
        centerPanel.add(matrix);

        centerPanel.add(createLabel("Select Course*"));
        addCourse = createjbox();
        centerPanel.add(addCourse);
        

        JPanel southpanel = new JPanel();
        southpanel.setBackground(Color.gray);
        add(southpanel, BorderLayout.SOUTH);

        grade = createbutton("Grade");
        southpanel.add(grade);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Update Student Information");
        setVisible(true);
        pack();
        setResizable(false);
        setSize(500, 210);
        setLocationRelativeTo(null);
    }

    void generate() {
        String gots;
        addCourse.setEnabled(true);
        addCourse.removeAllItems();

         String selectIntoTable=String.format("SELECT CourseCode FROM studentscourseandgrades WHERE Matric_Number=%s",matrix.getText());
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

    public static void main(String[] args) {
        new updategrade();
    }

}