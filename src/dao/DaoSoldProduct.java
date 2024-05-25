package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import conexion.Conexion;
import model.Product;

public class DaoSoldProduct {
Conexion cx;
	
	public DaoSoldProduct() {
		cx= new Conexion();
	}
	
	public boolean insertProduct(Product product, int quantity){
		PreparedStatement ps = null;
		try {
			ps=cx.conectar().prepareStatement("INSERT INTO SoldProducts VALUES(null,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, product.getId());
			ps.setString(2, product.getName());
			ps.setString(3, ""+product.getProfitPercentage());
			ps.setString(4, product.getBrand());
			ps.setString(5, product.getDescription());
			ps.setString(6, ""+quantity);
			ps.setString(7, ""+product.getSaleDate());
			ps.setString(8, ""+product.getSalePrice());
			ps.setString(9, ""+product.getPurchasePrice());
			ps.setString(10, ""+product.getRangoStock());
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Product> consultaProductos(){
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM SoldProducts");
			rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product(rs.getString("id"), rs.getString("name"), rs.getInt("profitPercentage"), 
						rs.getString("brand"), rs.getString("description"), rs.getInt("quantity"), 
						LocalDate.parse(rs.getString("saleDate")), rs.getDouble("salePrice"), rs.getDouble("purchasePrice"),rs.getInt("rangoStock"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
