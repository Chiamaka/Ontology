package ontology;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class about extends JFrame {

	private JPanel contentPane;
	public JFrame frame_object;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					about frame = new about();
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
	public about() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ChiAmaka\\Pictures\\g.jpeg"));
		setResizable(false);
		setTitle("About G Ontology Creator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		frame_object = this;
		
		JButton btnDismiss = new JButton("Dismiss");
		btnDismiss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame_object.dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnDismiss, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnDismiss);
		
		JSeparator separator = new JSeparator();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, separator, -31, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnDismiss, 150, SpringLayout.EAST, separator);
		sl_contentPane.putConstraint(SpringLayout.WEST, separator, 44, SpringLayout.WEST, contentPane);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		sl_contentPane.putConstraint(SpringLayout.NORTH, separator_1, 237, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, separator_1, 0, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, separator_1, -34, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, separator_1, 0, SpringLayout.EAST, contentPane);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 25, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, btnDismiss);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ChiAmaka\\workspace\\Ontology2\\res\\ontology.png"));
		contentPane.add(lblNewLabel);
		
		JLabel lblGOntologyCreator = new JLabel("G ONTOLOGY CREATOR");
		lblGOntologyCreator.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblGOntologyCreator);
		
		JLabel lblNewLabel_1 = new JLabel((String) null);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 68, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGOntologyCreator, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 25, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JTextPane txtpnGOntologyCreator = new JTextPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtpnGOntologyCreator, 62, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtpnGOntologyCreator, 25, SpringLayout.EAST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtpnGOntologyCreator, -20, SpringLayout.NORTH, btnDismiss);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtpnGOntologyCreator, -64, SpringLayout.WEST, separator_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblGOntologyCreator, -6, SpringLayout.NORTH, txtpnGOntologyCreator);
		txtpnGOntologyCreator.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnGOntologyCreator.setBackground(new Color(240,240,240));
		txtpnGOntologyCreator.setText("G Ontology Creator is an application to simplify the work of Ontology Developers.\r\nIt helps in selecting classes without the manual process and automatically creates an OWL file which can be viewed in Protege\r\n\r\nCopyright 2014\r\nCovenant University");
		contentPane.add(txtpnGOntologyCreator);
	}
}
