package Librarymanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import Connection.LibraryDAO;

public class AddForm extends JFrame implements ActionListener, MouseListener {
	private ArrayList<Book> listBook;

	JLabel lbId = new JLabel("ID");
	JLabel lbMaSach = new JLabel("Mã sách");
	JLabel lbTenSach = new JLabel("Tên sách");
	JLabel lbTheLoai = new JLabel("Thể loại");

	static JComboBox cbTheLoai = new JComboBox();

	JLabel lbNXB = new JLabel("Nhà XB");
	JLabel lbSoLuong = new JLabel("Số lượng");
	JLabel lbSoTrang = new JLabel("Số trang");
	JLabel lbGiaTien = new JLabel("Giá tiền");

	// Khai báo cục bộ các trường văn bản
	static JTextField txtId = new JTextField();
	static JTextField txtMaSach = new JTextField();
	static JTextField txtTenSach = new JTextField();
	static JTextField txtNXB = new JTextField();
	static JTextField txtSoLuong = new JTextField();
	static JTextField txtSoTrang = new JTextField();
	static JTextField txtGiaTien = new JTextField();

	JButton btnOK = new JButton("OK");
	JButton btnCancel = new JButton("Cancel");

	public AddForm() {
		super("AddForm");
		listBook = new LibraryDAO().getListBook();
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(null);
		inputPanel.setBackground(Color.PINK);

		lbId.setBounds(50, 30, 75, 22);
		inputPanel.add(lbId);

		txtId.setBounds(140, 30, 230, 22);
		inputPanel.add(txtId);

		lbMaSach.setBounds(50, 70, 75, 22);
		inputPanel.add(lbMaSach);

		txtMaSach.setBounds(140, 70, 230, 22);
		inputPanel.add(txtMaSach);

		lbTenSach.setBounds(50, 110, 75, 22);
		inputPanel.add(lbTenSach);

		txtTenSach.setBounds(140, 110, 230, 22);
		inputPanel.add(txtTenSach);

		lbTheLoai.setBounds(50, 150, 70, 22);

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
		cbTheLoai.setBounds(140, 150, 230, 22);

		inputPanel.add(cbTheLoai);
		inputPanel.add(lbTheLoai);

		lbNXB.setBounds(50, 190, 70, 22);
		inputPanel.add(lbNXB);

		txtNXB.setBounds(140, 190, 230, 22);
		inputPanel.add(txtNXB);

		lbSoLuong.setBounds(50, 230, 70, 22);
		inputPanel.add(lbSoLuong);

		txtSoLuong.setBounds(140, 230, 230, 22);
		inputPanel.add(txtSoLuong);

		lbSoTrang.setBounds(50, 270, 70, 22);
		inputPanel.add(lbSoTrang);

		txtSoTrang.setBounds(140, 270, 230, 22);
		inputPanel.add(txtSoTrang);

		lbGiaTien.setBounds(50, 310, 70, 22);
		inputPanel.add(lbGiaTien);

		txtGiaTien.setBounds(140, 310, 230, 22);
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

		Container cont = getContentPane();
		cont.add(inputPanel);
		cont.add(button, BorderLayout.PAGE_END);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(new Dimension(430, 430));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		// this.addForm = addForm;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Cancel")) {
			this.dispose();
		}

		if (e.getActionCommand().equals("OK")) {
			int confirm = 1;
			Book book = new Book();
			Icon warningIcon = new ImageIcon("D:\\VKU-SICT\\Kì 1\\JavaWorkspace\\DuAnCuoiKy\\images\\warning.png");
			try {
				book.setId(Integer.parseInt(txtId.getText()));
			} catch (Exception e2) {
				// TODO: handle exception
				confirm = -1;
				JOptionPane.showMessageDialog(this, "\"ID\" must be a number !!!", "Warning !", JOptionPane.INFORMATION_MESSAGE, warningIcon);
				e2.printStackTrace();

			}

			book.setMaSach(txtMaSach.getText());
			book.setTenSach(txtTenSach.getText());
			book.setTheLoai(cbTheLoai.getSelectedItem().toString());
			book.setNXB(txtNXB.getText());
			
			try {
				book.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
			} catch (Exception e2) {
				// TODO: handle exception
				confirm = -1;
				JOptionPane.showMessageDialog(this, "You entered wrong \"Số lượng\" !!!", "Warning !", JOptionPane.INFORMATION_MESSAGE, warningIcon);
				e2.printStackTrace();

			}
			try {
				book.setSoTrang(Integer.parseInt(txtSoTrang.getText()));
			} catch (Exception e2) {
				// TODO: handle exception
				confirm = -1;
				JOptionPane.showMessageDialog(this, "You entered wrong \"Số trang\" !!!", "Warning !", JOptionPane.INFORMATION_MESSAGE, warningIcon);
				e2.printStackTrace();

			}

			try {
				book.setGiaTien(Float.parseFloat(txtGiaTien.getText()));
			} catch (Exception e2) {
				// TODO: handle exception
				confirm = -1;
				JOptionPane.showMessageDialog(this, "You entered wrong \"Giá tiền\" !!!", "Warning !", JOptionPane.INFORMATION_MESSAGE, warningIcon);
				e2.printStackTrace();

			}
			if (confirm == 1) {
				if (new LibraryDAO().AddBook(book)) {
					listBook.add(book);
					Icon icon = new ImageIcon("D:\\VKU-SICT\\Kì 1\\JavaWorkspace\\DuAnCuoiKy\\images\\success.png");
					JOptionPane.showMessageDialog(this, "\""+ txtTenSach.getText()+"\""+" ADD SUCCESS !!!", "Binggo !", JOptionPane.INFORMATION_MESSAGE, icon);

					LibraryManagement.listBook = new LibraryDAO().getListBook();
					LibraryManagement.setDatatoTabel();
					
					{
						txtId.setText("");
						txtMaSach.setText("");
						txtTenSach.setText("");
						cbTheLoai.setSelectedIndex(0);
						txtNXB.setText("");
						txtSoLuong.setText("");
						txtSoTrang.setText("");
						txtGiaTien.setText("");
					}
					this.dispose();
				}

			} else {
				JOptionPane.showMessageDialog(this, "Please enter again !!!", "Warning !", JOptionPane.INFORMATION_MESSAGE, warningIcon);
			}

		}
	}
}
