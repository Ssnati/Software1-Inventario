package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import conexion.Connexion;
import model.Product;

public class DaoProduct {
	Connexion cx;
	
	public DaoProduct() {
		cx= new Connexion();
	}
	
	public boolean insertProduct(Product product){
		PreparedStatement ps = null;
		try {
			ps=cx.connect().prepareStatement("INSERT INTO Products VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, product.getId());
			ps.setString(2, product.getName());
			ps.setString(3, ""+product.getProfitPercentage());
			ps.setString(4, product.getBrand());
			ps.setString(5, product.getDescription());
			ps.setString(6, ""+product.getQuantity());
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
	
	public boolean actualizarProduct(Product product){
		PreparedStatement ps = null;
		try {
			ps=cx.connect().prepareStatement("UPDATE Products SET 	id=?, name=?, profitPercentage=?, brand=?, description=?, quantity=?, saleDate=?, salePrice=?, purchasePrice=?, rangoStock=? WHERE id=?");
			ps.setString(1, product.getId());
			ps.setString(2, product.getName());
			ps.setString(3, ""+product.getProfitPercentage());
			ps.setString(4, product.getBrand());
			ps.setString(5, product.getDescription());
			ps.setString(6, ""+product.getQuantity());
			ps.setString(7, ""+product.getSaleDate());
			ps.setString(8, ""+product.getSalePrice());
			ps.setString(9, ""+product.getPurchasePrice());
			ps.setString(10, ""+product.getRangoStock());
			ps.setString(11, ""+product.getId());
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean actualizarBuyProduct(String id,int quant, double saleP){
		PreparedStatement ps = null;
		try {
			ps=cx.connect().prepareStatement("UPDATE Products SET 	quantity=?, salePrice=? WHERE id=?");
			ps.setInt(1, quant);
			ps.setDouble(2, saleP);
			ps.setString(3, id);
			
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean actualizarSellProduct(String id,int quant, String saleDate){
		PreparedStatement ps = null;
		try {
			ps=cx.connect().prepareStatement("UPDATE Products SET 	quantity=?, saleDate=? WHERE id=?");
			ps.setInt(1, quant);
			ps.setString(2, saleDate);
			ps.setString(3, id);
			
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean eliminarProducto(int id) {
		PreparedStatement ps = null;
		try {
			ps=cx.connect().prepareStatement("DELETE FROM Products WHERE id=?");
			ps.setInt(1, id);
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
			ps = cx.connect().prepareStatement("SELECT * FROM Products");
			rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product(rs.getString("id"), rs.getString("name"), rs.getDouble("profitPercentage"),
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
