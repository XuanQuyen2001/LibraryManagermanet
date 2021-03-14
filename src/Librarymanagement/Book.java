package Librarymanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Book {
	Connection conn;
	private int id;
	private String maSach;
	private String tenSach;
	private String theLoai;
	private String NXB;
	private int soLuong;
	private int soTrang;
	private float giaTien;
	public Book() {
		super();
		
	}
	
	public Book(Connection conn, int id, String maSach, String tenSach, String theLoai, String nXB, int soLuong,
			int soTrang, float giaTien) {
		super();
		this.conn = conn;
		this.id = id;
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.theLoai = theLoai;
		NXB = nXB;
		this.soLuong = soLuong;
		this.soTrang = soTrang;
		this.giaTien = giaTien;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getNXB() {
		return NXB;
	}

	public void setNXB(String nXB) {
		NXB = nXB;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public float getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(float giaTien) {
		this.giaTien = giaTien;
	}

}
