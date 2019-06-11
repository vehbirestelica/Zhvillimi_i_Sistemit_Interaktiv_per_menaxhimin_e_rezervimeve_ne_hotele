

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.awt.Choice;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Checkbox;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;
import javax.swing.JMenu;
import javax.swing.JList;
import java.awt.Canvas;
import javax.swing.JToolBar;

public class Register1 extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register1 frame = new Register1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(null);
		
		TextField textField = new TextField();
		textField.setBackground(new Color(0, 0, 51));
		textField.setFont(new Font("Dialog", Font.ITALIC, 30));
		textField.setForeground(new Color(0, 255, 102));
		textField.setText("Outdoor && Indoor");
		textField.setBounds(182, 35, 270, 61);
		getContentPane().add(textField);
		
		Label label = new Label("Check In Date:");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(32, 134, 94, 22);
		getContentPane().add(label);
		
		Label label_1 = new Label("Check Out Date:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setBounds(158, 134, 94, 22);
		getContentPane().add(label_1);
		
		Label label_2 = new Label("Room Type:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_2.setBounds(319, 134, 94, 22);
		getContentPane().add(label_2);
		
		Checkbox checkbox = new Checkbox("Couple");
		checkbox.setBackground(new Color(153, 153, 153));
		checkbox.setBounds(319, 162, 78, 22);
		getContentPane().add(checkbox);
		
		Checkbox checkbox_1 = new Checkbox("Family");
		checkbox_1.setBackground(new Color(153, 153, 153));
		checkbox_1.setBounds(319, 190, 78, 22);
		getContentPane().add(checkbox_1);
		
		Checkbox checkbox_2 = new Checkbox("Solo");
		checkbox_2.setBackground(new Color(153, 153, 153));
		checkbox_2.setBounds(319, 218, 78, 22);
		getContentPane().add(checkbox_2);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setText("/   /          /");
		editorPane.setBounds(20, 162, 106, 20);
		getContentPane().add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setText("/   /          /");
		editorPane_1.setBounds(158, 162, 106, 20);
		getContentPane().add(editorPane_1);
		
		Button button_5 = new Button("Book Your Room Now");
		button_5.setForeground(new Color(255, 255, 255));
		button_5.setBackground(new Color(255, 102, 0));
		button_5.setBounds(449, 173, 134, 22);
		getContentPane().add(button_5);
		
		Component glue = Box.createGlue();
		glue.setBackground(new Color(204, 0, 0));
		glue.setForeground(new Color(204, 0, 0));
		glue.setBounds(10, 102, 638, 22);
		getContentPane().add(glue);
		
		Component glue_1 = Box.createGlue();
		glue_1.setBounds(10, 258, 638, 22);
		getContentPane().add(glue_1);
		
		Label label_3 = new Label("Location:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_3.setBounds(32, 286, 94, 22);
		getContentPane().add(label_3);
		
		Label label_4 = new Label("Members:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_4.setBounds(170, 286, 94, 22);
		getContentPane().add(label_4);
		
		Label label_5 = new Label("Room Type:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_5.setBounds(303, 286, 94, 22);
		getContentPane().add(label_5);
		
		Checkbox checkbox_3 = new Checkbox("Luxury");
		checkbox_3.setBackground(new Color(153, 153, 153));
		checkbox_3.setBounds(303, 314, 78, 22);
		getContentPane().add(checkbox_3);
		
		Checkbox checkbox_4 = new Checkbox("Normal");
		checkbox_4.setBackground(new Color(153, 153, 153));
		checkbox_4.setBounds(303, 342, 78, 22);
		getContentPane().add(checkbox_4);
		
		JList list = new JList();
		list.setForeground(new Color(255, 255, 255));
		list.setBackground(new Color(255, 255, 255));
		list.setBounds(32, 335, 63, -23);
		getContentPane().add(list);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(20, 0, 630, 21);
		getContentPane().add(menuBar_1);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(20, 29, 663, 16);
		getContentPane().add(toolBar);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		Button button = new Button("Home");
		button.setForeground(new Color(102, 102, 153));
		button.setEnabled(false);
		button.setBackground(new Color(102, 102, 153));
		menuBar.add(button);
		
		Button button_1 = new Button("Gallery");
		menuBar.add(button_1);
		
		Button button_2 = new Button("Contact");
		menuBar.add(button_2);
		
		Button button_3 = new Button("Register");
		menuBar.add(button_3);
		
		Button button_4 = new Button("About ");
		menuBar.add(button_4);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
