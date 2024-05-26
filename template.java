
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class template extends JFrame implements ActionListener, ItemListener, WindowListener, FocusListener,DocumentListener {
    Color fgcolor = Color.YELLOW, bgcolor = Color.BLACK;
    Font font = new Font("Comic sans", Font.BOLD, 20);

     JRadioButton checkButton(String txt) {
        JRadioButton btn = new JRadioButton(txt);
        btn.setForeground(fgcolor);
        btn.setBackground(bgcolor);
        btn.setFont(font);
        btn.setFont(font);
        return btn;
    }

    JButton createbutton(String txt) {
        JButton btn = new JButton(txt);
        btn.setFont(font);
        btn.setFocusable(false);
        btn.setBackground(bgcolor);
        btn.setForeground(fgcolor);
        btn.addActionListener(this);
        return btn;
    }

    JLabel createLabel(String txt) {
        JLabel label = new JLabel(txt);
        label.setFont(font);
        label.setForeground(fgcolor);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    JLabel createlabel(String txt) {
        JLabel label = new JLabel(txt);
        label.setFont(font);
        label.setForeground(fgcolor);
        label.setHorizontalAlignment(JLabel.CENTER);

        return label;
    }

    JPasswordField createPasswordField() {
        JPasswordField txtField = new JPasswordField(50);
        txtField.setFont(font);
        txtField.setForeground(fgcolor);
        txtField.setBackground(bgcolor);
        txtField.setCaretColor(Color.CYAN);
        txtField.setEchoChar('*');

        return txtField;
    }

    JComboBox<String> createjbox() {
        JComboBox<String> box = new JComboBox<String>();
        box.setBackground(bgcolor);
        box.setForeground(fgcolor);
        box.setFont(font);

        return box;
    }

    JTextField createtextfield() {
        JTextField field = new JTextField();
        field.setBackground(bgcolor);
        field.setForeground(fgcolor);
        field.setFont(font);
        field.getDocument().addDocumentListener(this);
        return field;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent arg0) {

    }

    @Override
    public void windowClosed(WindowEvent args) {
    }

    @Override
    public void windowClosing(WindowEvent arg0) {

    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {
    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {
    }

    @Override
    public void windowIconified(WindowEvent arg0) {
    }

    @Override
    public void windowOpened(WindowEvent arg0) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

	@Override
	public void insertUpdate(DocumentEvent e) {
		}

	@Override
	public void removeUpdate(DocumentEvent e) {
		}

	@Override
	public void changedUpdate(DocumentEvent e) {
		}

}
