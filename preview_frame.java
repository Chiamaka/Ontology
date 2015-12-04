package ontology;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JEditorPane;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.Color;

public class preview_frame extends JFrame {

	private JPanel contentPane;
	private TextExtractor textextractor = new TextExtractor();
	public JFrame frame_object;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					preview_frame frame = new preview_frame("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Constructor Class
	public preview_frame(String Path) throws Exception {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ChiAmaka\\Pictures\\g.jpeg"));
		setTitle("Preview Tab");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 748, 477);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		frame_object = this;

		// OK button
		JButton btnOk = new JButton("OK");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnOk, -335, SpringLayout.EAST, contentPane);
		contentPane.add(btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 21, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -43, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnOk, 5, SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 49, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -47, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		//end of OK Button
		
		//Action performed by the OK button
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_object.dispose();
			}
		});
		

		// call textextrator process method
		textextractor.process(Path);

		// get the output of the parsed file into a string
		String output = textextractor.getString();
		textArea.setText(output);
	}

	public void setText(String file) throws IOException {
		ReadFile loadfile = new ReadFile(file);
		String[] aryLines = loadfile.OpenFile();

		for (int i = 0; i < aryLines.length; i++) {
			// JOptionPane.showMessageDialog(null, aryLines[i]);
			// System.out.println(aryLines[i]);
			// textArea.setText(aryLines[i] + "\n");
		}
	}
}
