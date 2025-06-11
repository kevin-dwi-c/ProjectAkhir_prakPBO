/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DBConnection;
import model.CustomerModel;

public class CustomerRepository {
     public boolean add(CustomerModel customer) {
        var conn = DBConnection.getConnection();
        try (var statement = conn.prepareStatement("INSERT INTO customer (nama, no_ktp, alamat, no_telp) values (?,?,?,?)")) {
            statement.setString(1, customer.getNama());
            statement.setString(2, customer.getNo_ktp());
            statement.setString(3, customer.getAlamat());
            statement.setString(4, customer.getNo_telp());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
     
    public List<CustomerModel> getAllCustomer() {
        var conn = DBConnection.getConnection();
        var result = new ArrayList<CustomerModel>();
        try (var statement = conn.prepareStatement("SELECT * FROM customer");) {
            statement.execute();
            var rs = statement.getResultSet();
            while (rs.next()) {
                result.add(new CustomerModel(rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("no_ktp"),
                        rs.getString("alamat"),
                        rs.getString("no_telp")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean delete(int id) {
        var conn = DBConnection.getConnection();
        try (var statement = conn.prepareStatement("DELETE FROM customer WHERE id = ?")) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(CustomerModel customer) {
        var conn = DBConnection.getConnection();
        try (var statement = conn.prepareStatement("UPDATE customer set nama = ?, no_ktp = ?, alamat = ?, no_telp = ? WHERE id = ? ")) {
            statement.setString(1, customer.getNama());
            statement.setString(2, customer.getNo_ktp());
            statement.setString(3, customer.getAlamat());
            statement.setString(4, customer.getNo_telp());
            statement.setInt(5, customer.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean isDuplicate(String nama, String noKtp){
        var conn = DBConnection.getConnection();
        try(var stmt = conn.prepareStatement("SELECT COUNT(*) FROM customer WHERE nama = ? AND no_ktp=?");){
            stmt.setString(1, nama);
            stmt.setString(2, noKtp);
            var rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getInt(1) > 0;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    
    public CustomerModel getByCustomerID(int customer_id) {
        var conn = DBConnection.getConnection();
        try (var statement = conn.prepareStatement("SELECT * FROM customer WHERE id=?");) {
            statement.setInt(1, customer_id);
            statement.execute();
            var rs = statement.getResultSet();
            while (rs.next()) {
                return new CustomerModel(rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("no_ktp"),
                        rs.getString("alamat"),
                        rs.getString("no_telp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
