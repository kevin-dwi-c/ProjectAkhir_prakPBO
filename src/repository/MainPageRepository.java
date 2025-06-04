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

/**
 *
 * @author Asus
 */
public class MainPageRepository {
    
     public List<MobilModel> getAllMobil(){
         var conn = DBConnection.getConnection();
         var result = new ArrayList<MobilModel>();
         try(var statement = conn.prepareStatement("SELECT * FROM mobil");){
            statement.execute();
            var rs = statement.getResultSet();
            while(rs.next()){
                result.add(new MobilModel(rs.getInt("id"), 
                rs.getString("merk"), 
                rs.getString("tipe"),
                rs.getInt("harga_sewa"),
                rs.getBoolean("ketersediaan"),  
                rs.getString("no_polisi")));
            }
         }catch(SQLException e){
               e.printStackTrace();
         }
         return result;
    }
}
