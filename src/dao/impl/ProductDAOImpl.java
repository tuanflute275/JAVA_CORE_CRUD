package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.DAOInterface;
import database.JDBCUtil;
import model.Product;

public class ProductDAOImpl implements DAOInterface<Product, String> {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public static ProductDAOImpl getInstance() {
		return new ProductDAOImpl();
	}

	@Override
	public boolean insert(Product t) {
		boolean kq = false;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO product(name, price, sale_price, status, expiration_date) VALUES (?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setFloat(2, t.getPrice());
			ps.setFloat(3, t.getSale_price());
			ps.setInt(4, t.getStatus());
			ps.setDate(5, new Date(t.getExpiration_date().getTime()));
			int i = ps.executeUpdate();
			if(i > 0)
				kq = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public boolean update(Product t, String id) {
		boolean kq = false;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "UPDATE product SET name=?,price=?,sale_price=?,status=?,expiration_date=? WHERE ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setFloat(2, t.getPrice());
			ps.setFloat(3, t.getSale_price());
			ps.setInt(4, t.getStatus());
			ps.setDate(5, new Date(t.getExpiration_date().getTime()));
			ps.setString(6, id);
			int i = ps.executeUpdate();
			if(i > 0)
				kq = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public boolean delete(String id) {
		boolean kq = false;
		try {
			String sql = "DELETE FROM product WHERE ID = ?";
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int i = ps.executeUpdate();
			if(i > 0)
				kq = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM product";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getInt(5),rs.getDate(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product selectById(String id) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM product WHERE ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getInt(5),rs.getDate(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> selectByName(String search) {
		List<Product> list = new ArrayList<Product>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM product WHERE name LIKE ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + search + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getInt(5),rs.getDate(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
