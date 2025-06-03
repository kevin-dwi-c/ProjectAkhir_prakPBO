/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class CustomerModel {
   private int id;
   private String nama;
   private String no_ktp;
   private String alamat;
   private String no_telp;

    public CustomerModel(int id, String nama, String no_ktp, String alamat, String no_telp) {
        this.id = id;
        this.nama = nama;
        this.no_ktp = no_ktp;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNo_ktp() {
        return no_ktp;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }
   
}
