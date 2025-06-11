/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DBConnection;
import model.MobilComboItem;
import model.PengembalianModel;
import model.RentalModel;

public class RentalRepository {

    public List<MobilComboItem> getAllMobilComboItems() {
        var conn = DBConnection.getConnection();
        var result = new ArrayList<MobilComboItem>();
        try (var statement = conn.prepareStatement("SELECT * FROM mobil WHERE ketersediaan = '1'")) {
            var rs = statement.executeQuery();
            while (rs.next()) {
                result.add(new MobilComboItem(
                        rs.getInt("id"),
                        rs.getString("merk"),
                        rs.getString("tipe"),
                        rs.getInt("harga_sewa"),
                        rs.getBoolean("ketersediaan"),
                        rs.getString("no_polisi")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean add(RentalModel rental) {
        var conn = DBConnection.getConnection();
        try (var statement = conn.prepareStatement("INSERT INTO rental (id_mobil, id_customer, tanggal_sewa, tanggal_kembali, total_bayar) values (?,?,?,?,?)")) {
            statement.setInt(1, rental.getId_mobil());
            statement.setInt(2, rental.getId_customer());
            statement.setDate(3, new java.sql.Date(rental.getTgl_sewa().getTime()));
            statement.setDate(4, new java.sql.Date(rental.getTgl_balik().getTime()));
            statement.setInt(5, rental.getTotal_bayar());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String selectCustomerName(int id) {
        var conn = DBConnection.getConnection();
        String nama = null;

        try (var statement = conn.prepareStatement("SELECT nama FROM customer WHERE id = ?")) {
            statement.setInt(1, id);
            var rs = statement.executeQuery();
            if (rs.next()) {
                nama = rs.getString("nama"); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nama;
    }
    
    public int selectCarID(int id) {
        var conn = DBConnection.getConnection();
        int harga = 0;
        try (var statement = conn.prepareStatement("SELECT harga_sewa FROM mobil WHERE id = ?")) {
            statement.setInt(1, id);
            var rs = statement.executeQuery();
            if (rs.next()) {
                harga = rs.getInt("harga_sewa"); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return harga;
    }
    
    public boolean isDuplicate(int id_mobil, int id_customer){
        var conn = DBConnection.getConnection();
        try(var stmt = conn.prepareStatement("SELECT COUNT(*) FROM rental WHERE id_mobil= ? AND id_customer=?");){
            stmt.setInt(1, id_mobil);
            stmt.setInt(2, id_customer);
            var rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getInt(1) > 0;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean updateKetersediaanMobil(int mobilId, boolean tersedia){
        var conn = DBConnection.getConnection();
        try(var stmt = conn.prepareStatement("UPDATE mobil set ketersediaan = ? WHERE id = ?");){
            stmt.setBoolean(1, tersedia);
            stmt.setInt(2, mobilId);
        return stmt.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean delete(int id){
        var conn = DBConnection.getConnection();
        try (var statement = conn.prepareStatement("DELETE FROM rental WHERE id = ?")) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public RentalModel getByMobilID(int id_mobil) {
        var conn = DBConnection.getConnection();
        try (var statement = conn.prepareStatement("Select * FROM rental WHERE id_mobil = ?");) {
            statement.setInt(1,id_mobil);
            statement.execute();
            var rs = statement.getResultSet();
            while (rs.next()) {
                return new RentalModel(rs.getInt("id"),
                        rs.getInt("id_mobil"),
                        rs.getInt("id_customer"),
                        rs.getDate("tanggal_sewa"),
                        rs.getDate("tanggal_kembali"),
                        rs.getInt("total_bayar"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
