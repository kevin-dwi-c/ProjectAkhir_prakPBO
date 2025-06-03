/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class MobilModel {
    private int id;
    private String merk;
    private String tipe;
    private int harga_sewa;
    private boolean ketersediaan;
    private String no_polisi;
        
        public MobilModel(int id, String merk, String tipe, int harga_sewa, boolean ketersediaan, String no_polisi) {
            this.id = id;
            this.merk = merk;
            this.tipe = tipe;
            this.harga_sewa = harga_sewa;
            this.ketersediaan = ketersediaan;
            this.no_polisi = no_polisi;
        }

    public int getId() {
        return id;
    }

    public String getMerk() {
        return merk;
    }

    public String getTipe() {
        return tipe;
    }

    public int getHarga_sewa() {
        return harga_sewa;
    }

    public boolean isKetersediaan() {
        return ketersediaan;
    }

    public String getNo_polisi() {
        return no_polisi;
    }
       
}
