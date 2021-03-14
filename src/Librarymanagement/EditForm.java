package Librarymanagement;

import java.awt.*;
import java.awt.event.*;
import java.beans.Statement;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import Connection.LibraryDAO;

public class EditForm extends JFrame implements ActionListener {
	Connection conn;
	private ArrayList<Book> listBook;
	
	LibraryManagement editForm;
	JLabel lbId = new JLabel("ID");
	JLabel lbMaSach = new JLabel("Mã sách");
	JLabel lbTenSach = new JLabel("Tên sách");
	JLabel lbTheLoai = new JLabel("Thể loại");

	static JComboBox cbTheLoai = new JComboBox();

	JLabel lbNXB = new JLabel("Nhà XB");
	JLabel lbSoLuong = new JLabel("Số lượng");
	JLabel lbSoTrang = new JLabel("Số trang");
	JLabel lbGiaTien = new JLabel("Giá tiền");

	static JTextField txtId = new JTextField();
	static JTextField txtMaSach = new JTextField();
	static JTextField txtTenSach = new JTextField();
	static JTextField txtNXB = new JTextField();
	static JTextField txtSoLuong = new JTextField();
	static JTextField txtSoTrang = new JTextField();
	static JTextField txtGiaTien = new JTextField();

	JButton btnOK = new JButton("OK");
	JButton btnCancel = new JButton("Cancel");

	public EditForm() {
		super("EditForm");

		listBook = new LibraryDAO().getListBook();
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(null);
		inputPanel.setBackground(Color.PINK);

		lbId.setBounds(50, 30, 75, 22);

		txtId.setEditable(false);
		txtId.setBounds(140, 30, 230, 22);

		lbMaSach.setBounds(50, 70, 75, 22);

		txtMaSach.setBounds(140, 70, 230, 22);

		lbTenSach.setBounds(50, 110, 75, 22);

		txtTenSach.setBounds(140, 110, 230, 22);

		lbTheLoai.setBounds(50, 150, 70, 22);

		cbTheLoai.setBounds(140, 150, 230, 22);
		cbTheLoai.addItem("Truyện ngắn");
		cbTheLoai.addItem("Truyện dài");
		cbTheLoai.addItem("Truyện kinh dị");
		cbTheLoai.addItem("Sách tham khảo");
		cbTheLoai.addItem("Truyện hài");
		cbTheLoai.addItem("SGK");
		cbTheLoai.addItem("SBT");
		cbTheLoai.addItem("Triết học");
		cbTheLoai.addItem("Khoa học");
		cbTheLoai.addItem("Giá dục ký năng sống");
		cbTheLoai.addItem("Truyện thiếu nhi");
		cbTheLoai.addItem("Kịch");
		cbTheLoai.addItem("Tiểu thuyết");

		lbNXB.setBounds(50, 190, 70, 22);

		txtNXB.setBounds(140, 190, 230, 22);

		lbSoLuong.setBounds(50, 230, 70, 22);

		txtSoLuong.setBounds(140, 230, 230, 22);

		lbSoTrang.setBounds(50, 270, 70, 22);

		txtSoTrang.setBounds(140, 270, 230, 22);

		lbGiaTien.setBounds(50, 310, 70, 22);

		txtGiaTien.setBounds(140, 310, 230, 22);

		inputPanel.add(lbId);
		inputPanel.add(txtId);
		inputPanel.add(lbMaSach);
		inputPanel.add(txtMaSach);
		inputPanel.add(lbTenSach);
		inputPanel.add(txtTenSach);
		inputPanel.add(cbTheLoai);
		inputPanel.add(lbTheLoai);
		inputPanel.add(lbNXB);
		inputPanel.add(txtNXB);
		inputPanel.add(lbSoLuong);
		inputPanel.add(txtSoLuong);
		inputPanel.add(lbSoTrang);
		inputPanel.add(txtSoTrang);
		inputPanel.add(lbGiaTien);
		inputPanel.add(txtGiaTien);

		// Thêm nút
		JPanel button = new JPanel();
		button.setBackground(Color.PINK);
		button.setLayout(new FlowLayout());

		btnOK.setForeground(Color.BLUE);
		btnOK.setMnemonic('O');
		button.add(btnOK);

		btnCancel.setForeground(Color.BLUE);
		btnCancel.setMnemonic('C');
		button.add(btnCancel);

		btnOK.addActionListener(this);
		btnCancel.addActionListener(this);

		// SET TEXT
		txtId.setText(String.valueOf(LibraryManagement.id));
		txtMaSach.setText(String.valueOf(LibraryManagement.ms));
		txtTenSach.setText(String.valueOf(LibraryManagement.ts));
		cbTheLoai.setSelectedItem(String.valueOf(LibraryManagement.tl));
		txtNXB.setText(String.valueOf(LibraryManagement.nxb));
		txtSoLuong.setText(String.valueOf(LibraryManagement.sl));
		txtSoTrang.setText(String.valueOf(LibraryManagement.st));
		txtGiaTien.setText(String.valueOf(LibraryManagement.gt));

		Container cont = getContentPane();
		cont.add(inputPanel);
		cont.add(button, BorderLayout.PAGE_END);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(new Dimension(430, 430));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.editForm = editForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Cancel")) {
			this.dispose();
		}

		if (e.getActionCommand().equals("OK")) {
			
			Book book = new Book();
			book.setId(Integer.parseInt(txtId.getText()));
			book.setMaSach(txtMaSach.getText());
			book.setTenSach(txtTenSach.getText());
			book.setTheLoai(cbTheLoai.getSelectedItem().toString());
			book.setNXB(txtNXB.getText());
			book.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
			book.setSoTrang(Integer.parseInt(txtSoTrang.getText()));
			book.setGiaTien(Float.parseFloat(txtGiaTien.getText()));
			if (new LibraryDAO().EditBook(book)) {
				listBook.add(book);
				Icon icon = new ImageIcon("D:\\VKU-SICT\\Kì 1\\JavaWorkspace\\DuAnCuoiKy\\images\\success.png");
				JOptionPane.showMessageDialog(this, "\""+ txtTenSach.getText()+"\""+" EDIT SUCCESS !!!", "Binggo !", JOptionPane.INFORMATION_MESSAGE, icon);
				LibraryManagement.listBook = new LibraryDAO().getListBook();
				LibraryManagement.setDatatoTabel();
				this.dispose();
			}
			
		}

	}

}
