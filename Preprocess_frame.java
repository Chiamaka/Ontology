package ontology;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;

import opennlp.tools.util.InvalidFormatException;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.SwingConstants;

import java.awt.Dimension;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Color;

public class Preprocess_frame extends JFrame {
	private String file;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Preprocess_frame frame = new Preprocess_frame(0.0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Preprocess_frame(final double num) throws IOException {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\ChiAmaka\\Pictures\\g.jpeg"));
		setTitle("Preprocess Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		

		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		
		// Action performed by the Tokenize file button
		JButton btnTokenizeFile = new JButton("Tokenize file");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTokenizeFile, -193, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTokenizeFile, 82,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnTokenizeFile, -65,
				SpringLayout.SOUTH, contentPane);
		btnTokenizeFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				file = "tikaoutput" + num + ".txt";
				tokenize_frame tokenize;
				try {

					tokenize = new tokenize_frame();
					tokenize.setVisible(true);

					String text = Tokenizer.tokenizer(file);
					tokenize.setTextArea(text);
					tokenize.filePath = "tikaoutput" + num;
				} catch (InvalidFormatException e) {

					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnTokenizeFile.setFont(new Font("SansSerif", Font.PLAIN, 12));
		contentPane.add(btnTokenizeFile);

		// POSTagging button
		JButton btnPostagging = new JButton("POSTagging");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnPostagging, -193, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnPostagging, 74, SpringLayout.EAST, btnTokenizeFile);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnPostagging, -65, SpringLayout.SOUTH, contentPane);
		btnPostagging.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				file = "tikaoutput" + num + ".tok.txt";
				POSTagging_frame pos_frame;

				try {
					pos_frame = new POSTagging_frame();
					pos_frame.setVisible(true);
					
					Object text[] = POSTagging.POSTag(file);
					pos_frame.setTextArea(text[0].toString());
					pos_frame.setConcept(text[2]);
					
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		contentPane.add(btnPostagging);

	}
}
