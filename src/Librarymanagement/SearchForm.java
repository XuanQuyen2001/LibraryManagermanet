package Librarymanagement;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.*;

import javax.swing.*;

import Connection.LibraryDAO;

public class SearchForm extends JFrame	implements ActionListener, MouseListener{

	JLabel lbSearch = new JLabel("Tên sách");
	JTextField txtSearch = new JTextField();

	JButton btnSearch = new JButton("Search");


	public static String key;

	public SearchForm() {
		super("Tìm kiếm theo \"TenSach\"");

		JPanel pnFind = new JPanel();
		pnFind.setLayout(null);
		
		lbSearch .setBounds(10, 20, 100, 25);
		pnFind.add(lbSearch);
		
		txtSearch.setBounds(70, 20, 360, 25);
		pnFind.add(txtSearch);

		btnSearch.setBounds(440, 20, 80, 24);
		btnSearch.addActionListener(this);
		pnFind.add(btnSearch);

		Container cont = getContentPane();
		cont.add(pnFind);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(new Dimension(550, 100));
		this.setLocation(new Point(450,50));
		this.setVisible(true);
		
		txtSearch.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				key = txtSearch.getText();
				LibraryManagement.listBook = new Connection.LibraryDAO().SearchBook(key);
				LibraryManagement.setDatatoTabel();

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Search")) {
		
			LibraryManagement.listBook = new Connection.LibraryDAO().SearchBook(key);
			LibraryManagement.setDatatoTabel();
			this.dispose();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
