import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	JButton num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
	JButton Mr, Mc, Ms, Mminus, Mplus, Back, Cle, C, Com, Sqrt;
	JButton sum, sub, mul, div, mod, equ, dot, inv;
	JButton pi, E, Sin, Cos, Tan, Cot, Log, Ln, Squar, Pow, Abs, Fact;
	JTextField cal;
	static JLabel status, pstatus;
	JLabel pos, ads;
	static JProgressBar compute;
	JMenuBar menubar;
	JMenu file, edit, view, font, help;
	JMenuItem open, save, exit, select, copy, cut, paste, show, about;
	JRadioButtonMenuItem standard, scien;
	JCheckBoxMenuItem  f8, f10, f12, f14, f16, f18, f20, f22, f24, f26, f28, showIn, showMo;
	String memory = "0", history = "" , cp = "";
	JFileChooser fc = new JFileChooser();
	static Timer time;
	
	MainFrame() {
		
		ButtonClick bc = new ButtonClick();
		NumberClick nc = new NumberClick();
		MenuClick mc = new MenuClick();
		
		pos = new JLabel("Mouse position[0,0]");
		pos.setBounds(10, 362, 200, 24);
		
		ads = new JLabel("Programmer: Sayyid abbas aghaei, Version 1.0(Build 3/8/2017), Contact us: @abba5aghaei");
		ads.setBounds(0, 0, 520, 24);
		
		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent arg0) {
				
			}
			public void mouseMoved(MouseEvent me) {
				
				pos.setText("Mouse position["+me.getX()+","+me.getY()+"]");
			}
		});
		
		Container pane = getContentPane();
		pane.setLayout(null);
		pane.setBackground(SystemColor.inactiveCaption);
		pane.add(pos);
		pane.add(ads);
		
		cal = new JTextField();
		cal.setText("0");
		cal.setBounds(10, 21, 290, 35);
		cal.setColumns(10);
		cal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		menubar = new JMenuBar();
		
		setJMenuBar(menubar);
		
		file = new JMenu("File");
		file.setMnemonic('F');
		
		menubar.add(file);
		
		open = new JMenuItem("Open History");
		open.addActionListener(mc);
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		save = new JMenuItem("Save History");
		save.addActionListener(mc);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		JSeparator sep = new JSeparator();
		JSeparator sep2 = new JSeparator();
		JSeparator sep3 = new JSeparator();
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(mc);
		
		file.add(open);
		file.add(save);
		file.add(sep);
		file.add(exit);
		
		edit = new JMenu("Edit");
		edit.setMnemonic('E');
		
		menubar.add(edit);
		
		select = new JMenuItem("Select All");
		select.addActionListener(mc);
		
		copy = new JMenuItem("Copy");
		copy.addActionListener(mc);
		
		cut = new JMenuItem("Cut");
		cut.addActionListener(mc);
		
		paste = new JMenuItem("Paste");
		paste.addActionListener(mc);
		
		edit.add(select);
		edit.add(copy);
		edit.add(cut);
		edit.add(paste);
		
		view = new JMenu("View");
		view.setMnemonic('V');
		
		menubar.add(view);
		
		standard = new JRadioButtonMenuItem("Standard");
		standard.setSelected(true);
		standard.addActionListener(mc);
		
		scien = new JRadioButtonMenuItem("Scientific");
		scien.addActionListener(mc);
		
		ButtonGroup type = new ButtonGroup();
		
		type.add(standard);
		type.add(scien);
		
		font = new JMenu("Font Size");
		
		f8 = new JCheckBoxMenuItem("8");
		f8.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				cal.setFont(new Font("Times New Roman", Font.PLAIN, 8));
			}
		});
		
		f10 = new JCheckBoxMenuItem("10");
		f10.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				cal.setFont(new Font("Times New Roman", Font.PLAIN, 10));
			}
		});
		
		f12 = new JCheckBoxMenuItem("12");
		f12.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				cal.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			}
		});
		
		f14 = new JCheckBoxMenuItem("14");
		f14.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				cal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			}
		});
		
		f16 = new JCheckBoxMenuItem("16");
		f16.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				cal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			}
		});
		
		f18 = new JCheckBoxMenuItem("18");
		f18.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				cal.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			}
		});
		
		f20 = new JCheckBoxMenuItem("20");
		f20.setSelected(true);
		f20.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				cal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			}
		});
		
		f22 = new JCheckBoxMenuItem("22");
		f22.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				cal.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			}
		});
		
		f24 = new JCheckBoxMenuItem("24");
		f24.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				cal.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			}
		});
		
		f26 = new JCheckBoxMenuItem("26");
		f26.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				cal.setFont(new Font("Times New Roman", Font.PLAIN, 26));
			}
		});
		
		f28 = new JCheckBoxMenuItem("28");
		f28.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				cal.setFont(new Font("Times New Roman", Font.PLAIN, 28));
			}
		});
		
		ButtonGroup size = new ButtonGroup();
		
		size.add(f8);
		size.add(f10);
		size.add(f12);
		size.add(f14);
		size.add(f16);
		size.add(f18);
		size.add(f20);
		size.add(f22);
		size.add(f24);
		size.add(f26);
		size.add(f28);
		
		font.add(f8);
		font.add(f10);
		font.add(f12);
		font.add(f14);
		font.add(f16);
		font.add(f18);
		font.add(f20);
		font.add(f22);
		font.add(f24);
		font.add(f26);
		font.add(f28);
		
		showIn = new JCheckBoxMenuItem("Show Information");
		showIn.setSelected(true);
		showIn.addActionListener(mc);
		
		showMo = new JCheckBoxMenuItem("Show Mouse Position");
		showMo.setSelected(true);
		showMo.addActionListener(mc);
		
		view.add(standard);
		view.add(scien);
		view.add(sep2);
		view.add(showIn);
		view.add(showMo);
		view.add(sep3);
		view.add(font);
		
		help = new JMenu("Help");
		help.setMnemonic('H');
		
		menubar.add(help);
		
		about = new JMenuItem("About Calculator");
		about.addActionListener(mc);
		
		show = new JMenuItem("Show History");
		show.addActionListener(mc);
		
		help.add(show);
		help.add(about);
		
		compute = new JProgressBar();
		compute.setBounds(10, 55, 289, 14);
		
		status = new JLabel("Status: ");
		status.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		status.setBounds(11, 68, 300, 24);
		status.setVisible(true);
		
		pstatus = new JLabel("Status: ");
		pstatus.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pstatus.setBounds(11, 68, 429, 24);
		pstatus.setVisible(false);
		
		pane.add(cal);
		pane.add(compute);
		pane.add(status);
		pane.add(pstatus);
		
		JPanel panel = new JPanel();
		panel.setBounds(312, 90, 129, 277);
		panel.setLayout(null);
		
		pi = new JButton("pi");
		pi.setBounds(10, 11, 50, 40);
		panel.add(pi);
		pi.setBackground(SystemColor.inactiveCaption);
		pi.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pi.addActionListener(bc);
		
		E = new JButton("e");
		E.setBounds(65, 11, 50, 40);
		panel.add(E);
		E.setBackground(SystemColor.inactiveCaption);
		E.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		E.addActionListener(bc);
		
		Sin = new JButton("sin");
		Sin.setBounds(10, 56, 50, 40);
		panel.add(Sin);
		Sin.setBackground(SystemColor.inactiveCaption);
		Sin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Sin.addActionListener(bc);
		
		Cos = new JButton("cos");
		Cos.setBounds(65, 56, 50, 40);
		panel.add(Cos);
		Cos.setBackground(SystemColor.inactiveCaption);
		Cos.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Cos.addActionListener(bc);
		
		Tan = new JButton("tan");
		Tan.setBounds(10, 100, 50, 40);
		panel.add(Tan);
		Tan.setBackground(SystemColor.inactiveCaption);
		Tan.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Tan.addActionListener(bc);
		
		Cot = new JButton("cot");
		Cot.setBounds(65, 100, 50, 40);
		panel.add(Cot);
		Cot.setBackground(SystemColor.inactiveCaption);
		Cot.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Cot.addActionListener(bc);
		
		Log = new JButton("log");
		Log.setBounds(10, 144, 50, 40);
		panel.add(Log);
		Log.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Log.setBackground(SystemColor.inactiveCaption);
		Log.addActionListener(bc);
		
		Ln = new JButton("ln");
		Ln.setBounds(65, 144, 50, 40);
		panel.add(Ln);
		Ln.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Ln.setBackground(SystemColor.inactiveCaption);
		Ln.addActionListener(bc);
		
		Squar = new JButton("x2");
		Squar.setBounds(10, 187, 50, 40);
		panel.add(Squar);
		Squar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Squar.setBackground(SystemColor.inactiveCaption);
		Squar.addActionListener(bc);
		
		Pow = new JButton("pow");
		Pow.setBounds(65, 187, 50, 40);
		panel.add(Pow);
		Pow.setBackground(SystemColor.inactiveCaption);
		Pow.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		Pow.addActionListener(bc);
		
		Abs = new JButton("|x|");
		Abs.setBounds(10, 230, 50, 40);
		panel.add(Abs);
		Abs.setBackground(SystemColor.inactiveCaption);
		Abs.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Abs.addActionListener(bc);
		
		Fact = new JButton("n!");
		Fact.setBounds(65, 230, 50, 40);
		panel.add(Fact);
		Fact.setBackground(SystemColor.inactiveCaption);
		Fact.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Fact.addActionListener(bc);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(10, 90, 292, 277);
		panel2.setLayout(null);
		
		Mminus = new JButton("M-");
		Mminus.setBounds(230, 11, 50, 40);
		panel2.add(Mminus);
		Mminus.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		Mminus.setBackground(SystemColor.inactiveCaption);
		Mminus.addActionListener(bc);
		
		Mr = new JButton("MR");
		Mr.setBounds(10, 11, 50, 40);
		panel2.add(Mr);
		Mr.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		Mr.setBackground(SystemColor.inactiveCaption);
		Mr.addActionListener(bc);
		
		Mc = new JButton("MC");
		Mc.setBounds(65, 11, 50, 40);
		panel2.add(Mc);
		Mc.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		Mc.setBackground(SystemColor.inactiveCaption);
		Mc.addActionListener(bc);
		
		Ms = new JButton("MS");
		Ms.setBounds(120, 11, 50, 40);
		panel2.add(Ms);
		Ms.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		Ms.setBackground(SystemColor.inactiveCaption);
		Ms.addActionListener(bc);
		
		Mplus = new JButton("M+");
		Mplus.setBounds(175, 11, 50, 40);
		panel2.add(Mplus);
		Mplus.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		Mplus.setBackground(SystemColor.inactiveCaption);
		Mplus.addActionListener(bc);
		
		Back = new JButton("Back");
		Back.setBounds(10, 56, 50, 40);
		panel2.add(Back);
		Back.setBackground(SystemColor.inactiveCaption);
		Back.setFont(new Font("Times New Roman", Font.PLAIN, 6));
		Back.addActionListener(bc);
		
		Cle = new JButton("CLE");
		Cle.setBounds(65, 56, 50, 40);
		panel2.add(Cle);
		Cle.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		Cle.setBackground(SystemColor.inactiveCaption);
		Cle.addActionListener(bc);
		
		C = new JButton("C");
		C.setBounds(120, 56, 50, 40);
		panel2.add(C);
		C.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		C.setBackground(SystemColor.inactiveCaption);
		C.addActionListener(bc);
		
		Com = new JButton("-/+");
		Com.setBounds(175, 56, 50, 40);
		panel2.add(Com);
		Com.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Com.setBackground(SystemColor.inactiveCaption);
		Com.addActionListener(bc);
		
		Sqrt = new JButton("sqrt");
		Sqrt.setBounds(230, 56, 50, 40);
		panel2.add(Sqrt);
		Sqrt.setBackground(SystemColor.inactiveCaption);
		Sqrt.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		Sqrt.addActionListener(bc);
		
		div = new JButton("\u00F7");
		div.setBounds(175, 99, 50, 40);
		panel2.add(div);
		div.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		div.setBackground(SystemColor.inactiveCaption);
		div.addActionListener(bc);
		
		mod = new JButton("Mod");
		mod.setBounds(230, 99, 50, 40);
		panel2.add(mod);
		mod.setBackground(SystemColor.inactiveCaption);
		mod.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		mod.addActionListener(bc);
		
		inv = new JButton("1/x");
		inv.setBounds(230, 144, 50, 40);
		panel2.add(inv);
		inv.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inv.setBackground(SystemColor.inactiveCaption);
		inv.addActionListener(bc);
		
		mul = new JButton("\u00D7");
		mul.setBounds(175, 144, 50, 40);
		panel2.add(mul);
		mul.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mul.setBackground(SystemColor.inactiveCaption);
		mul.addActionListener(bc);
		
		sub = new JButton("-");
		sub.setBounds(175, 187, 50, 40);
		panel2.add(sub);
		sub.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sub.setBackground(SystemColor.inactiveCaption);
		sub.addActionListener(bc);
		
		sum = new JButton("+");
		sum.setBounds(175, 229, 50, 40);
		panel2.add(sum);
		sum.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sum.setBackground(SystemColor.inactiveCaption);
		sum.addActionListener(bc);
		
		equ = new JButton("=");
		equ.setBounds(230, 186, 50, 83);
		panel2.add(equ);
		equ.setBackground(SystemColor.inactiveCaption);
		equ.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		equ.addActionListener(bc);
		
		dot = new JButton(".");
		dot.setBounds(120, 229, 50, 40);
		panel2.add(dot);
		dot.setFont(new Font("Times New Roman", Font.BOLD, 16));
		dot.setBackground(SystemColor.inactiveCaption);
		dot.addActionListener(nc);
		
		num3 = new JButton("3");
		num3.setBounds(120, 187, 50, 40);
		panel2.add(num3);
		num3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		num3.setBackground(SystemColor.inactiveCaption);
		num3.addActionListener(nc);
		
		num6 = new JButton("6");
		num6.setBounds(120, 144, 50, 40);
		panel2.add(num6);
		num6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		num6.setBackground(SystemColor.inactiveCaption);
		num6.addActionListener(nc);
		
		num9 = new JButton("9");
		num9.setBounds(120, 99, 50, 40);
		panel2.add(num9);
		num9.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		num9.setBackground(SystemColor.inactiveCaption);
		num9.addActionListener(nc);
		
		num8 = new JButton("8");
		num8.setBounds(65, 99, 50, 40);
		panel2.add(num8);
		num8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		num8.setBackground(SystemColor.inactiveCaption);
		num8.addActionListener(nc);
		
		num7 = new JButton("7");
		num7.setBounds(10, 99, 50, 40);
		panel2.add(num7);
		num7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		num7.setBackground(SystemColor.inactiveCaption);
		num7.addActionListener(nc);
		
		num4 = new JButton("4");
		num4.setBounds(10, 144, 50, 40);
		panel2.add(num4);
		num4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		num4.setBackground(SystemColor.inactiveCaption);
		num4.addActionListener(nc);
		
		num5 = new JButton("5");
		num5.setBounds(65, 144, 50, 40);
		panel2.add(num5);
		num5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		num5.setBackground(SystemColor.inactiveCaption);
		num5.addActionListener(nc);
		
		num2 = new JButton("2");
		num2.setBounds(65, 186, 50, 40);
		panel2.add(num2);
		num2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		num2.setBackground(SystemColor.inactiveCaption);
		num2.addActionListener(nc);
		
		num0 = new JButton("0");
		num0.setBounds(10, 229, 105, 40);
		panel2.add(num0);
		num0.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		num0.setBackground(SystemColor.inactiveCaption);
		num0.addActionListener(nc);
		
		num1 = new JButton("1");
		num1.setBounds(10, 186, 50, 40);
		panel2.add(num1);
		num1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		num1.setBackground(SystemColor.inactiveCaption);
		num1.addActionListener(nc);
		
		pane.add(panel);
		pane.add(panel2);
	}
	public class ButtonClick implements ActionListener {
		
		String cs = "", ss = "";
		
		double one = 0, two = 0, three;
		
		char op = ' ';
		
		public void actionPerformed(ActionEvent e) {
			
			Object o = e.getSource();
			
			try
			{
				ss = "";
				
			if(o==sum)
			{
				one = Double.parseDouble(cal.getText());
				
				cal.setText("");
				
				op = '+';
				
				ss += one + "+";
			}
			else if(o==sub)
			{
				one = Double.parseDouble(cal.getText());
				
				cal.setText("");
				
				op = '-';
				
				ss += one + "-";
			}
			else if(o==mul)
			{
				one = Double.parseDouble(cal.getText());
				
				cal.setText("");
				
				op = '*';
				
				ss += one + "×";
			}
			else if(o==div)
			{
				one = Double.parseDouble(cal.getText());
				
				cal.setText("");
				
				op = '/';
				
				ss += one + "÷";
			}
			else if(o==mod)
			{
				one = Double.parseDouble(cal.getText());
				
				cal.setText("");
				
				op = '%';
				
				ss += one + "mod";
			}
			else if(o==equ)
			{
				progress();
				
				two = Double.parseDouble(cal.getText());
				
				switch(op)
				{
				case '+' : three = one + two; break;
				
				case '-' : three = one - two; break;
				
				case '*' : three = one * two; break;
				
				case '/' : three = one / two; break;
				
				case '%' : three = one % two; break;
				
				case '^' : three = Math.pow(one, two);
				}
				cs = three+"";
				
				cal.setText(cs);
				
				ss += one + "" + op + "" + two + "=" + three;
				
				history += "\n" + ss;
			}
			else if(o==inv)
			{
				one = Double.parseDouble(cal.getText());
				
				cs = (1/one) + "";
				
				cal.setText(cs);
				
				ss += "Inverse(" + one + ") = " + cs;
				
				history += "\n" + ss;
			}
			else if(o==Sqrt)
			{
				one = Double.parseDouble(cal.getText());
				
				cs = Math.sqrt(one) + "";
				
				cal.setText(cs);
				
				ss += "Sqrt(" + one + ") = " + cs;
				
				history += "\n" + ss;
			}
			else if(o==Com)
			{
				one = Double.parseDouble(cal.getText());
				
				if(one<=0)
					cs = Math.abs(one) + "";
				else
					cs = "-" + one;
					
				cal.setText(cs);
				
				ss += "Negative(" + one + ") = " + cs;
				
				history += "\n" + ss;
			}
			else if(o==C)
			{
				cal.setText("");
				
				ss += "Cleared";
			}
			else if(o==Cle)
			{
				cal.setText("");
				
				history = "";
				
				ss = "History is cleared";
			}
			else if(o==Back)
			{
				cs = cal.getText();
				
				if(!cs.isEmpty())
				{
				cs = cs.substring(0, cs.length()-1);
				
				cal.setText(cs);
				}
				ss += "A number removed";
			}
			else if(o==Mr)
			{
				cal.setText(memory);
				
				ss += "Memory is loaded";
			}
			else if(o==Mc)
			{
				memory = "0";
				
				ss += "Memory is cleared";
			}
			else if(o==Ms)
			{
				memory = cal.getText();
				
				ss += memory + " is saved in Memory";
			}
			else if(o==Mplus)
			{
				one = Double.parseDouble(cal.getText());
				
				two = Double.parseDouble(memory);
				
				three = one + two;
				
				memory = three + "";
				
				ss += "Memory increased";
			}
			else if(o==Mminus)
			{
				one = Double.parseDouble(cal.getText());
				
				two = Double.parseDouble(memory);
				
				three = one - two;
				
				memory = three + "";
				
				ss += "Memory decreased";
			}
			else if(o==pi)
			{
				cal.setText(Math.PI+"");
				
				ss += "PI loaded";
			}
			else if(o==E)
			{
				cal.setText(Math.E+"");
				
				ss += "e loaded";
			}
			else if(o==Sin)
			{
				one = Double.parseDouble(cal.getText());
				
				cs = Math.sin(one) + "";
				
				cal.setText(cs);
				
				ss += "Sin(" + one + ") = " + cs;
				
				history += "\n" + ss;
			}
			else if(o==Cos)
			{
				one = Double.parseDouble(cal.getText());
				
				cs = Math.cos(one) + "";
				
				cal.setText(cs);
				
				ss += "Cos(" + one + ") = " + cs;
				
				history += "\n" + ss;
			}
			else if(o==Tan)
			{
				one = Double.parseDouble(cal.getText());
				
				cs = Math.tan(one) + "";
				
				cal.setText(cs);
				
				ss += "tan(" + one + ") = " + cs;
				
				history += "\n" + ss;
			}
			else if(o==Cot)
			{
				one = Double.parseDouble(cal.getText());
				
				cs = Math.atan(one) + "";
				
				cal.setText(cs);
				
				ss += "Cot(" + one + ") = " + cs;
				
				history += "\n" + ss;
			}
			else if(o==Log)
			{
				one = Double.parseDouble(cal.getText());
				
				cs = Math.log10(one) + "";
				
				cal.setText(cs);
				
				ss += "Log(" + one + ") = " + cs;
				
				history += "\n" + ss;
			}
			else if(o==Ln)
			{
				one = Double.parseDouble(cal.getText());
				
				cs = Math.log(one) + "";
				
				cal.setText(cs);
				
				ss += "ln(" + one + ") = " + cs;
				
				history += "\n" + ss;
			}
			else if(o==Squar)
			{
				one = Double.parseDouble(cal.getText());
				
				cs = (one*one) + "";
				
				cal.setText(cs);
				
				ss += one + "power to 2 = " + cs;
				
				history += "\n" + ss;
			}
			else if(o==Pow)
			{
				one = Double.parseDouble(cal.getText());
				
				cal.setText("");
				
				op = '^';
				
				ss += one + "^";
			}
			else if(o==Abs)
			{
				one = Double.parseDouble(cal.getText());
				
				cs = Math.abs(one) + "";
				
				cal.setText(cs);
				
				ss += "|" + one + "| = " + cs;
				
				history += "\n" + ss;
			}
			else if(o==Fact)
			{
				one = Double.parseDouble(cal.getText());
				
				two = 1;
				
				for(int i=2 ; i<= one ; i++)
					two = two * i;
				
				cs = two + "";
				
				cal.setText(cs);
				
				ss += one + "! = " + cs;
				
				history += "\n" + ss;
			}
			status.setText("Status: "+ss);
			}
			catch (NumberFormatException nf)
			{
				JOptionPane.showMessageDialog(null, "Invalid number entered!", "Eror", JOptionPane.ERROR_MESSAGE);
			}
		}

		private void progress() {
			
			time = new Timer();
			
			compute.setValue(0);
			
			status.setVisible(false);
			
			pstatus.setVisible(true);
			
			time.schedule(new Computerunner(), 0, 3);
		}
	}
	public class NumberClick implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			Object o = e.getSource();
			
			if(o==dot)
			{
				cal.setText(cal.getText()+".");
			}
			if(o==num0)
			{
				cal.setText(cal.getText()+"0");
			}
			if(o==num1)
			{
				cal.setText(cal.getText()+"1");
			}
			if(o==num2)
			{
				cal.setText(cal.getText()+"2");
			}
			if(o==num3)
			{
				cal.setText(cal.getText()+"3");
			}
			if(o==num4)
			{
				cal.setText(cal.getText()+"4");
			}
			if(o==num5)
			{
				cal.setText(cal.getText()+"5");
			}
			if(o==num6)
			{
				cal.setText(cal.getText()+"6");
			}
			if(o==num7)
			{
				cal.setText(cal.getText()+"7");
			}
			if(o==num8)
			{
				cal.setText(cal.getText()+"8");
			}
			if(o==num9)
			{
				cal.setText(cal.getText()+"9");
			}
		}
	}
	public class MenuClick implements ActionListener {
		
		String cs = "", ss = "";
		
		public void actionPerformed(ActionEvent e) {
			
			Object o = e.getSource();
			
			ss = "";
			
			if(o==open)
			{
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				int result = fc.showOpenDialog(null);
				
				if(result == JFileChooser.CANCEL_OPTION)
					fc.cancelSelection();
					
				if(result == JFileChooser.APPROVE_OPTION)
				{
					try {
						
						File f = fc.getSelectedFile();
						
						if(!f.isFile())
							JOptionPane.showMessageDialog(null, "Invalid file name", "Eror", JOptionPane.ERROR);
						
						Scanner in = new Scanner(new FileReader(f));
						
						String s, text = "";
						
						while(in.hasNext())
						{
							s = in.nextLine();
							
							text = text + "\n" + s;
						}
						history = text;
						
						in.close();
						
						JOptionPane.showMessageDialog(null, "Calculating history is Loaded:\n"+history, "Calculating History", JOptionPane.PLAIN_MESSAGE);
						
						ss += "File is loaded";
					}
					catch (Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Eror occured in opening file", "Eror", JOptionPane.ERROR);
					}
				}
			}
			else if(o==save)
			{
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				int result = fc.showSaveDialog(null);
				
				if(result == JFileChooser.CANCEL_OPTION)
					fc.cancelSelection();
				
				if(result == JFileChooser.APPROVE_OPTION)
				{
					try {
						
						File f = fc.getSelectedFile();
						
						PrintWriter out = new PrintWriter(f);
						
						out.print(history);
						
						out.close();
						
						ss += "File seved succesfully";
					}
					catch (Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Eror occured in saving file", "Eror", JOptionPane.ERROR);
					}
				}
			}
			else if(o==exit)
			{
				System.exit(0);
			}
			else if(o==select)
			{
				cal.selectAll();
				
				ss += "All text is selected";
			}
			else if(o==copy)
			{
				cp = cal.getSelectedText();
				
				ss += "Copied";
			}
			else if(o==cut)
			{
				cp = cal.getSelectedText();
				
				cal.replaceSelection("");
				
				ss += "Cuted";
			}
			else if(o==paste)
			{
			    cal.setText(cal.getText()+cp);
			    
			    ss += "Pasted";
			}
			else if(o==standard)
			{
				setBounds(450, 100, 320, 445);
				
				compute.setBounds(10, 55, 289, 14);
				
				cal.setBounds(10, 21, 290, 35);
				
				ss += "Switched to standard calculator";
			}
			else if(o==scien)
			{
				setBounds(450, 100, 465, 445);
				
				compute.setBounds(10, 55, 430, 14);
				
				cal.setBounds(10, 21, 431, 35);
				
				ss += "Switched to scientific calculator";
			}
			else if(o==showMo)
			{
				if(!showMo.isSelected()) {
					
					pos.setVisible(false);
					
					ss += "Mouse Position Disabled";
				}
				else if(showMo.isSelected()) {
					
					pos.setVisible(true);
					
					ss += "Mouse Position Enabled";
				}
			}
			else if(o==showIn)
			{
				if(!showIn.isSelected()) {
					
					ads.setVisible(false);
					
					ss += "Information Disabled";
				}
				else if(showIn.isSelected()) {
					
					ads.setVisible(true);
					
					ss += "Information Enabled";
				}
			}
			else if(o==show)
			{
				JOptionPane.showMessageDialog(null, "Your calculating history:\n"+history, "Calculating History", JOptionPane.PLAIN_MESSAGE);
			}
			else if(o==about)
			{
				JOptionPane.showMessageDialog(null, "Programmer: Sayyid abbas aghaei\nVersion 1.0(Build 3/8/2017)\nContact us: @abba5aghaei", "About", JOptionPane.PLAIN_MESSAGE);
			}
			status.setText("Status: "+ss);
		}
	}
	public static class Computerunner extends TimerTask {

		public void run() {
			
			pstatus.setText("Status: Computing...("+compute.getValue()+"%)");
			
			compute.setValue(compute.getValue()+1);
			
			if(compute.getValue() == 100)
			{
				time.cancel();
				
				status.setVisible(true);
				
				pstatus.setVisible(false);
			}
		}
	}
}
