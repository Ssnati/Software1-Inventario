package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexion.Connexion;
import model.User;

public class DaoUser {
    private final Connexion cx;

    public DaoUser() {
        cx = new Connexion();
    }

    public void insertDefaultUser() {
        executeUpdate("INSERT INTO Users VALUES(null,?,?,?,?,?)", true, "", "", "", "");
    }

    public boolean updateUser(User user) {
        return executeUpdate("UPDATE Users SET enableRegister=?, username=?, password=?, securityQuestion=?, answerQuestion=? WHERE id=1",
                user.isEnableRegister(), user.getUsername(), user.getPassword(), user.getSecurityQuestion(), user.getAnswerQuestion());
    }

    public User updateUser() {
        ArrayList<User> users = new ArrayList<>();
        try (PreparedStatement ps = cx.connect().prepareStatement("SELECT * FROM Users");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                users.add(new User(rs.getBoolean("enableRegister"), rs.getString("username"), rs.getString("password"), rs.getString("securityQuestion"), rs.getString("answerQuestion")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users.isEmpty() ? null : users.get(0);
    }

    private boolean executeUpdate(String query, Object... params) {
        try (PreparedStatement ps = cx.connect().prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            cx.desconectar();
        }
    }
}