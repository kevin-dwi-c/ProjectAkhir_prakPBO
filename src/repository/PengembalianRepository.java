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
import model.PengembalianModel;

public class PengembalianRepository {

    public List<PengembalianModel> getAllItems() {
        var conn = DBConnection.getConnection();
        var result = new ArrayList<PengembalianModel>();
        try (var statement = conn.prepareStatement("Select * FROM pengembalian");) {
            statement.execute();
            var rs = statement.getResultSet();
            while (rs.next()) {
                result.add(new PengembalianModel(rs.getInt("id"),
                        rs.getInt("mobil_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("tanggal_kembali"),
                        rs.getInt("jumlah_telat"),
                        rs.getInt("total_setelah_denda")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean add(PengembalianModel kembali) {
        var conn = DBConnection.getConnection();
        try (var statement = conn.prepareStatement("INSERT INTO pengembalian (customer_id, mobil_id, tanggal_kembali, jumlah_telat, total_setelah_denda) values (?,?,?,?,?)")) {
            statement.setInt(1, kembali.getId_customer());
            statement.setInt(2, kembali.getId_mobil());
            statement.setDate(3, new java.sql.Date(kembali.getTanggal_kembali().getTime()));
            statement.setInt(4, kembali.getJumlah_telat());
            statement.setInt(5, kembali.getDenda());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
    
     public int getIdCustomerByName(String namaCustomer){
         int id = -1;
        var conn = DBConnection.getConnection();
        try(var stmt = conn.prepareStatement("SELECT id FROM customer WHERE nama = ?");){
           stmt.setString(1, namaCustomer);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                 id = rs.getInt("id"); 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }
    
    public List<MobilComboItem> getAllMobilComboItems() {
        var conn = DBConnection.getConnection();
        var result = new ArrayList<MobilComboItem>();
        try (var statement = conn.prepareStatement("SELECT * FROM mobil WHERE ketersediaan = '0'")) {
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
    
    
    
    
}
