package Librarymanagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import Connection.LibraryDAO;

public class LibraryManagement extends JFrame implements ActionListener, MouseListener {
	Connection con;
	Statement stm;
	ResultSet rs;

	public static ArrayList<Book> listBook;
	final static String[] columns = { "ID", "MaSach","TenSach" , "TheLoai", "NXB", "SoLuong", "SoTrang", "GiaTien" };
	static DefaultTableModel model;
	JTable table;
	JScrollPane sc;
	int selectedRow = 0;
	
	static int id;
	static String ms;
	static String ts;
	static String tl;
	static String nxb;
	static int sl;
	static int st;
	static float gt;
	
	JButton btnAdd, btnEdit, btnDelete, btnSearch;
	private JLabel lbIconAdd;

	public LibraryManagement() {
		super("LibraryManagement");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\VKU-SICT\\Kì 1\\JavaWorkspace\\DuAnCuoiKy\\images\\icon.png"));

		listBook = new LibraryDAO().getListBook();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		setDatatoTabel();
		
		table = new JTable(model);
		table.setFont(UIManager.getFont("CheckBoxMenuItem.font"));
		table.setForeground(new Color(220, 20, 60));
		table.setRowHeight(25);
		table.addMouseListener(this);
		sc = new JScrollPane(table);
		sc.setBorder(new TitledBorder("THÔNG TIN SÁCH TRONG THƯ VIỆN"));

		JPanel controll = new JPanel();
		controll.setPreferredSize(new Dimension(350, 600));
		controll.setLayout(null);

		JLabel lbLibrary = new JLabel("Library Management");
		lbLibrary.setBackground(UIManager.getColor("Button.background"));
		lbLibrary.setForeground(new Color(255, 0, 51));
		lbLibrary.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 35));
		lbLibrary.setBounds(10, 0, 330, 40);

		JLabel title = new JLabel(new ImageIcon("D:\\VKU-SICT\\Kì 1\\JavaWorkspace\\DuAnCuoiKy\\images\\backGround.jpg"));
		title.setBounds(0, 0, 350, 550);
		// title.setIcon(icon);
//		sc.add(title);
 
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		Icon iconAdd = new ImageIcon("D:\\VKU-SICT\\Kì 1\\JavaWorkspace\\DuAnCuoiKy\\images\\icon-Add.png");
		btnAdd.setBounds(143, 382, 88, 30);
		btnAdd.setIcon(iconAdd);
		btnAdd.addActionListener(this);
		btnAdd.setMnemonic('A');
		btnAdd.setForeground(Color.RED);

		btnEdit = new JButton("Edit");
		btnEdit.setHorizontalAlignment(SwingConstants.LEFT);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 13));
		Icon iconEdit = new ImageIcon("D:\\VKU-SICT\\Kì 1\\JavaWorkspace\\DuAnCuoiKy\\images\\icon-Edit.png");
		btnEdit.setBounds(143, 422, 88, 30);
		btnEdit.setIcon(iconEdit);
		btnEdit.addActionListener(this);
		btnEdit.setMnemonic('E');
		btnEdit.setForeground(Color.RED);

		btnDelete = new JButton("Delete");
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		Icon iconDelete = new ImageIcon("D:\\VKU-SICT\\Kì 1\\JavaWorkspace\\DuAnCuoiKy\\images\\icon-Delete.png");
		btnDelete.setBounds(134, 462, 110, 30);
		btnDelete.setIcon(iconDelete);
		btnDelete.addActionListener(this);
		btnDelete.setMnemonic('D');
		btnDelete.setForeground(Color.RED);

		btnSearch = new JButton("Search");
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		Icon iconSearch = new ImageIcon("D:\\VKU-SICT\\Kì 1\\JavaWorkspace\\DuAnCuoiKy\\images\\icon-Search.png");
		btnSearch.setBounds(134, 502, 110, 30);
		btnSearch.setIcon(iconSearch);
		btnSearch.addActionListener(this);
		btnSearch.setMnemonic('S');
		btnSearch.setForeground(Color.RED);

		controll.add(btnAdd);
		controll.add(btnDelete);
		controll.add(btnEdit);
		controll.add(btnSearch);
		controll.add(lbLibrary);
		controll.add(title);

		Container cont = getContentPane();
		cont.add(sc, BorderLayout.CENTER);
		cont.add(controll, BorderLayout.WEST);
		
	
		

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(new Dimension(1362, 577));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
	
				id = (int) table.getValueAt(row, 0);
				ms = (String) table.getValueAt(row, 1);
				ts = (String) table.getValueAt(row, 2);
				tl = (String) table.getValueAt(row, 3);
				nxb = (String) table.getValueAt(row, 4);
				sl = (int) table.getValueAt(row, 5);
				st = (int) table.getValueAt(row, 6);
				gt = (float) table.getValueAt(row, 7);
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

	}
	

	public static void setDatatoTabel() {
		model.setRowCount(0);
		
		for (Book b : listBook) {
			model.addRow(new Object[] {
					 b.getId(), b.getMaSach(),b.getTenSach(), b.getTheLoai(), b.getNXB(), b.getSoLuong(), b.getSoTrang()
					, b.getGiaTien()
					});
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LibraryManagement();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		selectedRow = table.getSelectedRow();

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
		if (e.getActionCommand().equals("Add")) {

			new AddForm();
		}

		if (e.getActionCommand().equals("Edit")) {
			Book b = (Book) listBook.get(selectedRow);
			new EditForm();
		}
		
		if (e.getActionCommand().equals("Delete")) {
			Icon noti = new ImageIcon("D:\\VKU-SICT\\Kì 1\\JavaWorkspace\\DuAnCuoiKy\\images\\noti.png");
			int action = JOptionPane.showConfirmDialog(null, " Do you want to delete this book !", noti.toString(), JOptionPane.YES_NO_OPTION);
			if(action == 0) {
				Icon icon = new ImageIcon("D:\\VKU-SICT\\Kì 1\\JavaWorkspace\\DuAnCuoiKy\\images\\success.png");
				JOptionPane.showMessageDialog(this," DELETE SUCCESS !!!", "Success !", JOptionPane.INFORMATION_MESSAGE, icon);
				Book A = (Book) listBook.get(selectedRow);
				new LibraryDAO().DeleteBook(A);
				listBook = new LibraryDAO().getListBook();
				setDatatoTabel();
				model.fireTableDataChanged();
			}
			

		}

		if (e.getActionCommand().equals("Search")) {
			new SearchForm();
		}
	}

}
