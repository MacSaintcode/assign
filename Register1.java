
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
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Register1 extends template {

    JTextField firstnamefield, lastnamefield, Other_Names, Date_Of_Birth, Reg_num, Phone_Number;
    JButton submit, reset;
    JRadioButton male, female;
    String tick = "", Gender = "Male", regnum;
    boolean result;

    // public Statement st2 = Practice_Connector.createStatement();

    public Register1(String got) {
        tick = got;

        JPanel centerpanel = new JPanel();
        centerpanel.setBackground(bgcolor);
        add(centerpanel);

        GridLayout gl = new GridLayout(6, 2);
        gl.setVgap(10);
        centerpanel.setLayout(gl);

        centerpanel.add(createLabel("Firstname*"));
        firstnamefield = createtextfield();
        centerpanel.add(firstnamefield);

        centerpanel.add(createLabel("Lastname*"));
        lastnamefield = createtextfield();
        centerpanel.add(lastnamefield);

        centerpanel.add(createLabel(" Other Names"));
        Other_Names = createtextfield();
        centerpanel.add(Other_Names);

        centerpanel.add(createLabel("Date Of Birth*"));
        Date_Of_Birth = createtextfield();
        Date_Of_Birth.setText("YYYY-MM-DD");

        centerpanel.add(Date_Of_Birth);

        centerpanel.add(createLabel("Reg Number*"));
        Reg_num = createtextfield();
        centerpanel.add(Reg_num);

        JPanel genderpane = new JPanel();
        genderpane.setBackground(bgcolor);

        male = checkButton("Male");
        female = checkButton("Female");

        male.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        genderpane.add(male);
        genderpane.add(female);

        centerpanel.add(createLabel("Gender*"));
        centerpanel.add(genderpane);

        male.addItemListener(this);
        female.addItemListener(this);
        addWindowListener(this);

        JPanel southpanel = new JPanel();
        southpanel.setBackground(Color.DARK_GRAY);

        add(southpanel, BorderLayout.SOUTH);

        reset = createbutton("RESET");
        southpanel.add(reset);

        submit = createbutton("SUBMIT");
        southpanel.add(submit);
        Date_Of_Birth.addFocusListener(this);
        setDefaultCloseOperation(0);
        setTitle("Registration Menu");
        pack();
        setResizable(false);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    boolean checkpass(String word) {
        for (char letter : word.toCharArray()) {
            boolean got = Pattern.matches("[0-9]", letter + "");
            System.out.println(got);
            if (got) {
                return result = false;

            } else {
                result = true;
            }
            System.out.println(result);
        }

        System.out.println("\n");

        String vowel = "_@&~!@#$%^&*()_+=-/.,><|[{}]";
        for (char letter : word.toCharArray()) {
            if (vowel.contains(letter + "")) {
                return result = false;
            } else {
                result = true;
            }
            System.out.println(result);
        }
        return result;
    }

    @Override
    public void itemStateChanged(ItemEvent ea) {
        if (male.isSelected()) {
            Gender = "Male";
        } else if (female.isSelected()) {
            Gender = "Female";
        } else {
            Gender = null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent eo) {
        if (eo.getSource() == reset) {

            firstnamefield.setText("");
            lastnamefield.setText("");
            Other_Names.setText("");
            Date_Of_Birth.setText("YYYY-MM-DD");
            Reg_num.setText("");
            male.setSelected(true);
            Gender = null;

        } else {

            if (firstnamefield.getText().isEmpty() || lastnamefield.getText()
                    .isEmpty() || Date_Of_Birth.getText().isEmpty() || Gender == null ||
                    Reg_num.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "FIELD CANNOT BE EMPTY!");
                return;
            }

            // // CHECK IF NAME FIELDS CONTAINS SYMBOLS
            // if (checkpass(firstnamefield.getText()) && checkpass(lastnamefield.getText())) {
            //     JOptionPane.showMessageDialog(null, "Names Must Contains Only Letters!");
            //     return;
            // }

            // CHECK IF OTHE NAMES IS EMPTY
            if (Other_Names.getText().isEmpty()) {
                Other_Names.setText(null);

                // CHECK IF NAME FIELDS CONTAINS SYMBOLS
            } else if (checkpass(Other_Names.getText())) {
                JOptionPane.showMessageDialog(null, "Names Contains Only Letters!");
                return;
            }

            // check phone number pattern
            Boolean res = Pattern.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}",
                    Date_Of_Birth.getText());
            if (res == false) {
                JOptionPane.showMessageDialog(null, "INCORRECT DATE FORMAT");
                Date_Of_Birth.setText("YYYY-MM-DD");
                return;
            }

            // registration number must be 8
            if (!(Reg_num.getText().length() == 8)) {
                JOptionPane.showMessageDialog(null, "Invalid Registration Number!");
                Reg_num.setText("");
                return;
            }

            // registeration number pattern
            Boolean resu = Pattern.matches("[0-9]{8}", Reg_num.getText());
            if (resu == false) {
                JOptionPane.showMessageDialog(null, "Invalid Registration Number!");
                Reg_num.setText("");
                return;
            }

            if (tick.equalsIgnoreCase("only")) {
                // Boolean finding = false;
                // String selectIntoTable1 = String.format("SELECT Registration_Number FROM
                // studdetails");
                // String match, matches;
                // ResultSet rs;
                // try {
                // rs = st2.executeQuery(selectIntoTable1);
                // while (rs.next()) {
                // match = rs.getString("Registration_Number");
                // if (((String) Reg_num.getText()).equalsIgnoreCase(match)) {
                // finding=true;
                // break;
                // }
                // }
                // if(!finding){
                // JOptionPane.showMessageDialog(null,
                // "THIS REGISTRATION NUMBER DOES NOT EXIST!");
                // Reg_num.setText("");
                // return;
                // }
                // } catch (SQLException ex) {
                // System.out.println("Error occured....." + ex.getMessage() + "\tQuery has been
                // terminated");
                // }

            } else {
                // String selectIntoTable1 = String.format("SELECT Registration_Number FROM
                // studdetails");
                // String match, matches;
                // ResultSet rs;
                // try {
                // rs = st2.executeQuery(selectIntoTable1);
                // while (rs.next()) {
                // match = rs.getString("Registration_Number");
                // if (((String) Reg_num.getText()).equalsIgnoreCase(match)) {
                // JOptionPane.showMessageDialog(null,
                // "THIS REGISTRATION NUMBER HAS BEEN ASSIGNED TO ANOTHER STUDENT!");
                // Reg_num.setText("");
                // return;
                // }
                // }
                // } catch (SQLException ex) {
                // System.out.println("Error occured....." + ex.getMessage() + "\tQuery has been
                // terminated");
                // }
            }
            String InputQuery;
            if (tick.equalsIgnoreCase("only")) {
                InputQuery = String.format(
                        "UPDATE studdetails SET Firstname = '%s' , Matric_Number = '%s' , Lastname = '%s' , Other_names = '%s' , Date_Of_Birth = '%s',Gender = '%s' WHERE Registration_Number = '%s' ",
                        firstnamefield.getText(), lastnamefield.getText(), Other_Names.getText(),
                        Date_Of_Birth.getText(),
                        Gender,
                        Reg_num.getText());

            } else {
                InputQuery = String.format("INSERT INTO studdetails VALUES('%s','%s','%s','%s','%s','%s')",
                        firstnamefield.getText(), lastnamefield.getText(), Other_Names.getText(),
                        Date_Of_Birth.getText(),
                        Gender,
                        Reg_num.getText());
            }

            // empty fields after executing query

            // try {
            // st2.execute(InputQuery);
            // System.out.println("Query Executed Sucessfully");
            // regnum = Reg_num.getText();
            // firstnamefield.setText("");
            // lastnamefield.setText("");
            // Date_Of_Birth.setText("YYYY-MM-DD");
            // Other_Names.setText("");
            // male.setSelected(true);
            // Reg_num.setText("");

            if (tick.equalsIgnoreCase("only")) {
                JOptionPane.showMessageDialog(null, "STUDENT DETAILS UPDATED", "Information", 1);
                new updateui();
                dispose();
            } else {
                new registerstudent();
                // new registerstudent(regnum,st2);
                dispose();
            }
            // } catch (SQLException sq) {
            // System.out.println("Error occured....." + sq.getMessage() + "\tQuery has been
            // terminated");
            // JOptionPane.showMessageDialog(null, "Software Crashed!", "Error Occured!",
            // 0);

            // } catch (NullPointerException po) {
            // JOptionPane.showMessageDialog(null, "Server Not Online Please Rectify it!",
            // "Error Occured!", 0);
            // return;
            // }

        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Registration portal Opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "Do You Want To Terminate Your Registration",
                "Confirmation!", 0, 3);
        if (result == JOptionPane.YES_OPTION) {
            new AdminMenu();
            dispose();
        }

    }

    @Override
    public void focusGained(FocusEvent e) {
        if (Date_Of_Birth.getText().equalsIgnoreCase("YYYY-MM-DD")) {
            Date_Of_Birth.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (Date_Of_Birth.getText().isBlank()) {
            Date_Of_Birth.setText("YYYY-MM-DD");
        }

    }

    public static void main(String[] args) {
        new Register1("");

    }
}
