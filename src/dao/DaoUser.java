package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import model.User;

public class DaoUser {
	Conexion cx;
	
	public DaoUser() {
		cx= new Conexion();
	}
	
	public void insertDefaultUser(){
		PreparedStatement ps = null;
		try {
			ps=cx.conectar().prepareStatement("INSERT INTO Users VALUES(null,?,?,?,?,?)");
			ps.setBoolean(1, true);
			ps.setString(2, "");
			ps.setString(3, "");
			ps.setString(4, "");
			ps.setString(5, "");
			ps.executeUpdate();
			cx.desconectar();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public boolean actualizarUser(User user){
		PreparedStatement ps = null;
		try {
			ps=cx.conectar().prepareStatement("UPDATE Users SET enableRegister=?, username=?, password=?, securityQuestion=?, answerQuestion=? WHERE id=1");
			ps.setBoolean(1, user.isEnableRegister());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getSecurityQuestion());
			ps.setString(5, user.getAnswerQuestion());
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public User consultaUsuario(){
		ArrayList<User> users = new ArrayList<User>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM Users");
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User(rs.getBoolean("enableRegister"),rs.getString("username"),rs.getString("password"),rs.getString("securityQuestion"),rs.getString("answerQuestion"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(users.size()==0) {
			return null;
		}
		return users.get(0);
	}
	
	
}
