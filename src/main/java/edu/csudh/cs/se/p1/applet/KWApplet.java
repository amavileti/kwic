package edu.csudh.cs.se.p1.applet;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class KWApplet extends JApplet implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String INVALID_INPUT = "invalid user input provided";
	
	JLabel inp, out;
	JTextArea in,op;
	JButton b1, b2;

	private KWRotator rotator;

	public void init() {
		rotator = new KWRotator();

		Container content = getContentPane();
		content.setBackground(new Color(201,211,224));
		content.setLayout(null);
		content.setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		inp = new JLabel("INPUT");
		inp.setFont(new Font("Serif", Font.BOLD, 14));
		inp.setForeground(Color.BLUE);
		inp.setLocation(200,100);
		inp.setSize(100,50);
		content.add(inp);
		in = new JTextArea();
		JScrollPane scrollfield = new JScrollPane(in);
		 in.setBorder(border);
		in.setFont(new Font("Cambria", Font.PLAIN, 14));
		in.setLocation(310,100);
		in.setSize(900,50);
		content.add(in);
		content.add(scrollfield);
		out = new JLabel("OUTPUT");
		out.setFont(new Font("Serif", Font.BOLD, 14));
		out.setForeground(Color.BLUE);
		out.setLocation(200,200);
		out.setSize(100,50);
		content.add(out);
		op = new JTextArea();
		JScrollPane scrollArea = new JScrollPane(op);
		op.setFont(new Font("Cambria", Font.PLAIN, 14));
		op.setBorder(border);
		op.setLocation(310,200);
		op.setSize(900,300);
		content.add(op);
		content.add (scrollArea);
		op.setEditable(false);
		b1 = new JButton("Shift");
		b1.setLocation(50,150);
		b1.setSize(80,20);
		content.add(b1);
		b2 = new JButton("Reset");
		b2.setLocation(50,200);
		b2.setSize(80,20);
		content.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			try {
				String input = in.getText();
				if(!KWUtils.isAlpha(input)){
					op.setText(INVALID_INPUT);
				}else{
					List<String> output = rotator.rotate(input);
					op.setText(KWUtils.joinList(output, true));
				}
			} catch (IllegalArgumentException iie) {
				op.setText(INVALID_INPUT);
			}
		} else if (e.getSource() == b2) {
			in.setText(KWUtils.EMPTY);
			op.setText(KWUtils.EMPTY);
		}
			}


}