/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.SQLException;
import model.DBConnection;
import model.MobilModel;

public class MobilRepository {
     public boolean add(MobilModel mobil){
        var conn = DBConnection.getConnection();
        try(var statement = conn.prepareStatement("INSERT INTO mobil (merk, tipe, harga_sewa, ketersediaan, no_polisi) values (?,?,?)")){
            statement.setString(1, mobil.getMerk());
            statement.setString(2, mobil.getTipe());
            statement.setInt(3, mobil.getHarga_sewa());
            statement.setBoolean(4, mobil.isKetersediaan());
            statement.setString(5, mobil.getNo_polisi());
            return statement.executeUpdate() >0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
