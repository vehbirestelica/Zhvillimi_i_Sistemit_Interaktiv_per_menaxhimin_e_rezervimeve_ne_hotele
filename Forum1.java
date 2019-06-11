

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Label;
import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Forum1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forum1 window = new Forum1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Forum1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.getContentPane().setLayout(null);
		
		Label label = new Label("Username:");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(10, 29, 62, 22);
		frame.getContentPane().add(label);
		
		TextField Username = new TextField();
		Username.setBounds(92, 29, 146, 22);
		frame.getContentPane().add(Username);
		
		Label label_1 = new Label("Email:");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(10, 67, 62, 22);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("Phone:");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setBounds(10, 111, 62, 22);
		frame.getContentPane().add(label_2);
		
		TextField Email = new TextField();
		Email.setBounds(92, 67, 146, 22);
		frame.getContentPane().add(Email);
		
		TextField Phone = new TextField();
		Phone.setBounds(92, 111, 146, 22);
		frame.getContentPane().add(Phone);
		
		Button button = new Button("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=Username.getText();
				String psd=Email.getText();
				String nmb=Phone.getText();
				if(uname.equals("name") && psd.equals("tahir1temaj@gmail.com") && nmb.equals("12345678")) {
					JOptionPane.showMessageDialog(frame, " You are sucessfully loged In ");
					
					Register1 reg=new Register1();
					reg.setVisible(true);
				
				}
				else {
					JOptionPane.showMessageDialog(frame, " INVALID USERNAME,EMAIL OR PHONE ");
				}
				
				
			}
		});
		button.setBackground(new Color(255, 51, 0));
		button.setFont(new Font("Dialog", Font.PLAIN, 12));
		button.setForeground(new Color(0, 0, 0));
		button.setBounds(92, 175, 70, 22);
		frame.getContentPane().add(button);
		frame.setBackground(new Color(0, 0, 51));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(102, 102, 153));
		menuBar.setBackground(new Color(0, 0, 51));
		frame.setJMenuBar(menuBar);
		
		Button button_1 = new Button("Home");
		button_1.setBackground(new Color(102, 102, 153));
		button_1.setForeground(new Color(102, 102, 153));
		button_1.setEnabled(false);
		menuBar.add(button_1);
		
		Button button_2 = new Button("Gallery");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menuBar.add(button_2);
		
		Button button_3 = new Button("Contact");
		menuBar.add(button_3);
		
		Button button_4 = new Button("Register");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register1().setVisible(true);
			}
		});
		menuBar.add(button_4);
		
		Button button_5 = new Button("About ");
		menuBar.add(button_5);
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
