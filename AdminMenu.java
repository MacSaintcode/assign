import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminMenu extends template {
    Font font = new Font("Comic Sans", Font.BOLD, 30);
    JButton addStudent, updateStudent,viewStudnts;

    AdminMenu() {
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(bgcolor);
        add(centerPanel);
        centerPanel.setLayout(new GridLayout(3, 1));

        addStudent = createbutton("+ Register New Student");
		centerPanel.add(addStudent);

		updateStudent = createbutton("+  Update Student Details");
		centerPanel.add(updateStudent);

        viewStudnts = createbutton("View Sudents Details");
		centerPanel.add(viewStudnts);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("ADMINISTRATIVE MENU");
		setVisible(true);
		pack();
        
		setSize(500, 450);
		setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addStudent){
            new Register1("");
            dispose();
        }
        else if(e.getSource()==updateStudent){
            new updateui();
            dispose();
        }else{
            new StudTable();
            dispose();
        }

    }

}
