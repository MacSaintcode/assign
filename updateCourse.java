import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class updateCourse extends template {
    // Statement st2 = Practice_Connector.createStatement();
    JButton addCourse;
    JComboBox selectCourse;
    JTextField matrix;

    updateCourse() {
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(bgcolor);
        add(centerPanel);
        centerPanel.setLayout(new GridLayout(2, 2));

        centerPanel.add(createLabel("Matric Number*"));
        matrix = createtextfield();
        centerPanel.add(matrix);

        centerPanel.add(createLabel("Select Course*"));
        selectCourse = createjbox();

        centerPanel.add(selectCourse);

        JPanel southpanel = new JPanel();
        southpanel.setBackground(Color.gray);
        add(southpanel, BorderLayout.SOUTH);

        addCourse = createbutton("Add Course");
        southpanel.add(addCourse);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Update Student Information");
        setVisible(true);
        pack();
        setResizable(false);
        setSize(500, 210);
        setLocationRelativeTo(null);
        matrix.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Insert");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("remove");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("update");
            }
        });
    }

    void generate() {
        String gots;
        selectCourse.setEnabled(true);
        selectCourse.removeAllItems();

        String faculty = String.format("SELECT Facaulty FROM identity WHERE Matric_Number=%s", matrix.getText());

        String selectIntoTable = String.format("SELECT %s FROM department", faculty);
        // try {
        // ResultSet rs = st2.executeQuery(selectIntoTable);
        // while (rs.next()) {
        // gots = rs.getString(faculty);
        // selectCourse.addItem(gots);
        // }
        // System.out.println("Completed");
        // } catch (SQLException sqe) {
        // System.out.println(sqe.getMessage());
        // }
    }

    public static void main(String[] args) {
        new updateCourse();
    }

}
