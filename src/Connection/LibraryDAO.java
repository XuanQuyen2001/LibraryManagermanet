package Connection;

import java.sql.*;
import java.util.*;

import Librarymanagement.Book;

public class LibraryDAO {
	private Connection conn;
	
	public LibraryDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","thanhxuan2701");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
		public ArrayList<Book> getListBook(){
			ArrayList<Book> listBook = new ArrayList<Book>();
			String sql = "SELECT * FROM thuviensach";
			try {
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					Book book = new Book();
					book.setTheLoai(rs.getString("TheLoai"));
					book.setMaSach(rs.getString("MaSach"));
					book.setTenSach(rs.getString("TenSach"));
					book.setId(rs.getInt("ID"));
					book.setNXB(rs.getString("NXB"));
					book.setSoLuong(rs.getInt("SoLuong"));
					book.setSoTrang(rs.getInt("SoTrang"));
					book.setGiaTien(rs.getFloat("GiaTien"));
					listBook.add(book);
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			 
			return listBook;
		}
		
		public boolean AddBook(Book b) {
			
			String sql = "INSERT INTO thuviensach (ID, MaSach, TenSach, TheLoai, NXB, SoLuong, SoTrang, GiaTien)"
					+ " VALUES (?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, b.getId());
				pst.setString(2, b.getMaSach());
				pst.setString(3, b.getTenSach());
				pst.setString(4, b.getTheLoai());
				pst.setString(5, b.getNXB());
				pst.setInt(6, b.getSoLuong());
				pst.setInt(7, b.getSoTrang());
				pst.setFloat(8, b.getGiaTien());
				
				return pst.executeUpdate() > 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
		}
		
		public boolean EditBook(Book b) {
			
			String sql = "UPDATE thuviensach SET MaSach = ?, TenSach = ?, TheLoai = ?, NXB = ?, SoLuong = ?, SoTrang = ?, GiaTien = ? "
					+ "WHERE ID = ?";
			try {
				PreparedStatement pst = conn.prepareStatement(sql);
				
				pst.setString(1, b.getMaSach());
				pst.setString(2, b.getTenSach());
				pst.setString(3, b.getTheLoai());
				pst.setString(4, b.getNXB());
				pst.setInt(5, b.getSoLuong());
				pst.setInt(6, b.getSoTrang());
				pst.setFloat(7, b.getGiaTien());
				pst.setInt(8, b.getId());
				
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return true;
		}
		
		public boolean DeleteBook(Book b) {
			
			String sql = "DELETE FROM thuviensach WHERE ID = ?";
			try {
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, b.getId());
				
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LibraryDAO();
	}
	public ArrayList<Book> SearchBook(String key) {
		ArrayList<Book> listBook = new ArrayList<Book>();
		
		String sql = "SELECT * FROM thuviensach WHERE TenSach LIKE '%"+key+"%'";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setTenSach(rs.getString("TenSach"));
				book.setId(rs.getInt("ID"));
				book.setMaSach(rs.getString("MaSach"));
				book.setTheLoai(rs.getString("TheLoai"));
				book.setNXB(rs.getString("NXB"));
				book.setSoLuong(rs.getInt("SoLuong"));
				book.setSoTrang(rs.getInt("SoTrang"));
				book.setGiaTien(rs.getFloat("GiaTien"));
				listBook.add(book);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listBook;
	}

}
