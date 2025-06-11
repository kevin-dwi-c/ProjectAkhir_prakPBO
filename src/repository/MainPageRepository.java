/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DBConnection;
import model.MainpageModel;
import model.MobilModel;

/**
 *
 * @author Asus
 */
public class MainPageRepository {
    
     public List<MainpageModel> getAllMobil(){
         var conn = DBConnection.getConnection();
         var result = new ArrayList<MainpageModel>();
         try(var statement = conn.prepareStatement("select rental.*, customer.*, mobil.* from rental JOIN customer ON rental.id_customer = customer.id JOIN mobil ON rental.id_mobil = mobil.id");){
            statement.execute();
            var rs = statement.getResultSet();
            while(rs.next()){
                result.add(new MainpageModel(rs.getInt("rental.id"), 
                rs.getString("mobil.tipe"), 
                rs.getString("customer.nama"),
                rs.getDate("rental.tanggal_sewa"),
                rs.getDate("rental.tanggal_kembali")));
            }
         }catch(SQLException e){
               e.printStackTrace();
         }
         return result;
    }
}
