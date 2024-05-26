import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class updateui extends template {
    JButton enroll, updateStudentGrades, updateStudentInfo;

    // Statement st2 = Practice_Connector.createStatement();
    updateui() {
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(bgcolor);
        add(centerPanel);
        centerPanel.setLayout(new GridLayout(3, 1));
        enroll = createbutton("Register Student Courses");
        centerPanel.add(enroll);

        updateStudentGrades = createbutton("Update Students Course Grade");
        centerPanel.add(updateStudentGrades);

        updateStudentInfo = createbutton("Update Student Information");
        centerPanel.add(updateStudentInfo);

        

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Update Student Information");
        setVisible(true);
        pack();

        setSize(500, 450);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enroll) {
            new updateCourse();
            dispose();
        } else if (e.getSource() == updateStudentGrades) {
            new updategrade();
            dispose();
        } else {
            new Register1("only");
            dispose();
        }

    }

    public static void main(String[] args) {
        new updateui();
    }
}
