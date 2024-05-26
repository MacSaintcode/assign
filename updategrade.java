import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

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

        addCourse.setEnabled(false);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Update Student Information");
        setVisible(true);
        pack();
        setResizable(false);
        setSize(500, 210);
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
        if (matrix.getText().length()==8) {
            String selectIntoTable=String.format("SELECT Matric_Number FROM identity");
            matrix.setEnabled(false);
        // try {
        // ResultSet rs = st2.executeQuery(selectIntoTable);
        // while (rs.next()) {
        // gots = rs.getString("Matric_Number");
        // addCourse.addItem(gots);
        // }
        // System.out.println("Completed");
        // } catch (SQLException sqe) {
        // System.out.println(sqe.getMessage());
        // }
        matrix.setEnabled(false);
            JOptionPane.showMessageDialog(null,"INVALID MATRIC NUMBER","iNFORMATION",2);
            generate();
        }else{ 
            addCourse.setEnabled(false);
        }
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