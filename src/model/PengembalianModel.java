/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class PengembalianModel {

    private int id;
    private int id_mobil;
    private int id_customer;
    private int jumlah_telat;
    private int denda;
    private Date tanggal_kembali;

    public PengembalianModel(int id, int id_mobil, int id_customer, Date tanggal_kembali, int jumlah_telat, int denda ) {
        this.id = id;
        this.id_mobil = id_mobil;
        this.id_customer = id_customer;
        this.jumlah_telat = jumlah_telat;
        this.denda = denda;
        this.tanggal_kembali = tanggal_kembali;
    }

    public int getId() {
        return id;
    }

    public int getId_mobil() {
        return id_mobil;
    }

    public int getId_customer() {
        return id_customer;
    }

    public int getJumlah_telat() {
        return jumlah_telat;
    }

    public int getDenda() {
        return denda;
    }

    public Date getTanggal_kembali() {
        return tanggal_kembali;
    }

    
}
