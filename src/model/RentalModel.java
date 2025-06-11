/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;


public class RentalModel {
    private int id;
    private int id_mobil;
    private int id_customer;
    private Date tgl_sewa;
    private Date tgl_balik;
    private int total_bayar;

    public RentalModel(int id, int id_mobil, int id_customer, Date tgl_sewa, Date tgl_balik, int total_bayar) {
        this.id = id;
        this.id_mobil = id_mobil;
        this.id_customer = id_customer;
        this.tgl_sewa = tgl_sewa;
        this.tgl_balik = tgl_balik;
        this.total_bayar = total_bayar;
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

    public Date getTgl_sewa() {
        return tgl_sewa;
    }

    public Date getTgl_balik() {
        return tgl_balik;
    }

    public int getTotal_bayar() {
        return total_bayar;
    }
    
}
