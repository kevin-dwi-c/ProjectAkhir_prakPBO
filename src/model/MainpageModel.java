/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class MainpageModel {
    private int id;
    private String NamaMobil;
    private String NamaCustomer;
    private Date tgl_sewa;
    private Date tgl_balik;

    public MainpageModel(int id, String NamaMobil, String NamaCustomer, Date tgl_sewa, Date tgl_balik) {
        this.id = id;
        this.NamaMobil = NamaMobil;
        this.NamaCustomer = NamaCustomer;
        this.tgl_sewa = tgl_sewa;
        this.tgl_balik = tgl_balik;
    }

    public int getId() {
        return id;
    }

    public String getNamaMobil() {
        return NamaMobil;
    }

    public String getNamaCustomer() {
        return NamaCustomer;
    }

    public Date getTgl_sewa() {
        return tgl_sewa;
    }

    public Date getTgl_balik() {
        return tgl_balik;
    }
    
    
}
