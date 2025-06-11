/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DBConnection;
import model.MobilModel;

public class MobilRepository {

    public boolean add(MobilModel mobil) {
        var conn = DBConnection.getConnection();
        try (var statement = conn.prepareStatement("INSERT INTO mobil (merk, tipe, harga_sewa, ketersediaan, no_polisi) values (?,?,?,?,?)")) {
            statement.setString(1, mobil.getMerk());
            statement.setString(2, mobil.getTipe());
            statement.setInt(3, mobil.getHarga_sewa());
            statement.setBoolean(4, mobil.isKetersediaan());
            statement.setString(5, mobil.getNo_polisi());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<MobilModel> getAllMobil() {
        var conn = DBConnection.getConnection();
        var result = new ArrayList<MobilModel>();
        try (var statement = conn.prepareStatement("SELECT * FROM mobil");) {
            statement.execute();
            var rs = statement.getResultSet();
            while (rs.next()) {
                result.add(new MobilModel(rs.getInt("id"),
                        rs.getString("merk"),
                        rs.getString("tipe"),
                        rs.getInt("harga_sewa"),
                        rs.getBoolean("ketersediaan"),
                        rs.getString("no_polisi")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(int id) {
        var conn = DBConnection.getConnection();
        try (var statement = conn.prepareStatement("DELETE FROM mobil WHERE id = ?")) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(MobilModel mobil) {
        var conn = DBConnection.getConnection();
        try (var statement = conn.prepareStatement("UPDATE mobil set merk = ?, tipe = ?, harga_sewa = ?, ketersediaan = ?, no_polisi = ? WHERE id = ? ")) {
            statement.setString(1, mobil.getMerk());
            statement.setString(2, mobil.getTipe());
            statement.setInt(3, mobil.getHarga_sewa());
            statement.setBoolean(4, mobil.isKetersediaan());
            statement.setString(5, mobil.getNo_polisi());
            statement.setInt(6, mobil.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean isDuplicate(String merk, String platNomor){
        var conn = DBConnection.getConnection();
        try(var stmt = conn.prepareStatement("SELECT COUNT(*) FROM mobil WHERE merk = ? AND no_polisi=?");){
            stmt.setString(1, merk);
            stmt.setString(2, platNomor);
            var rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getInt(1) > 0;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
