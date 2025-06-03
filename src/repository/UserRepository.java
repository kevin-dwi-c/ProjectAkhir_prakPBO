package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DBConnection;
import model.UserModel;

public class UserRepository {

    public UserModel getByUsername(String username) {
        var conn = DBConnection.getConnection();
        try (var statement = conn.prepareStatement("SELECT * FROM user WHERE username = ?");) {   
            statement.setString(1, username);
            statement.execute();
            var rs = statement.getResultSet();
            if (rs.next()) {
                return new UserModel(rs.getInt("id"), 
                rs.getString("username"), 
                rs.getString("password"), 
                UserModel.Role.valueOf(rs.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
    }
    
    public List<UserModel> getAllPetugas(){
         var conn = DBConnection.getConnection();
         var result = new ArrayList<UserModel>();
         try(var statement = conn.prepareStatement("SELECT * FROM user WHERE role = 'petugas'");){
            statement.execute();
            var rs = statement.getResultSet();
            while(rs.next()){
                result.add(new UserModel(rs.getInt("id"), 
                rs.getString("username"), 
                rs.getString("password"), 
                UserModel.Role.valueOf(rs.getString("role"))));
            }
         }catch(SQLException e){
               e.printStackTrace();
         }
         return result;
    }
    
    public boolean add(UserModel user){
        var conn = DBConnection.getConnection();
        try(var statement = conn.prepareStatement("INSERT INTO user (username,password,role) values (?,?,?)")){
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole().name());
            return statement.executeUpdate() >0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
     public boolean delete(int id){
        var conn = DBConnection.getConnection();
        try(var statement = conn.prepareStatement("DELETE FROM user WHERE id = ?")){
            statement.setInt(1, id);
            return statement.executeUpdate() >0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
     
    public boolean update(UserModel user){
        var conn = DBConnection.getConnection();
        try(var statement = conn.prepareStatement("UPDATE user set username = ?, password = ?, role = ? WHERE id = ? ")){
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole().name());
            statement.setInt(4, user.getId());
            return statement.executeUpdate() >0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
