package ontology;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.Color;

public class tokenize_frame extends JFrame {
	private JPanel contentPane;
	public JFrame frame_object;
	private JScrollPane scrollPane;
	public String filePath;
	private JTextArea textArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tokenize_frame frame = new tokenize_frame();
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
	public tokenize_frame() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ChiAmaka\\Pictures\\g.jpeg"));
		setTitle("Tokenize Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		frame_object = this;
		
		// Tokens Label
		JLabel lblTokens = new JLabel("Tokens");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTokens, 169, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTokens, -118, SpringLayout.EAST, contentPane);
		lblTokens.setForeground(Color.WHITE);
		contentPane.add(lblTokens);
		// end of Tokens Label

		// OK button
		JButton btnOk = new JButton("OK");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnOk, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnOk, -162, SpringLayout.EAST, contentPane);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newToken = textArea.getText();
				PrintStream diskwriter;
				try {
					diskwriter = new PrintStream("nlp/" + filePath + ".tok.txt");
					diskwriter.print(newToken);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				frame_object.dispose();
			}
		});
		contentPane.add(btnOk);
		//end of OK Button
		
		scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTokens, -6, SpringLayout.NORTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 38, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -14, SpringLayout.NORTH, btnOk);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 113, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -103, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
	}

	public void setTextArea(String text) {
		textArea.setText(text);
	}

	
}
