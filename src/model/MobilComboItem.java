/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class MobilComboItem extends MobilModel {

    public MobilComboItem(int id, String merk, String tipe, int harga_sewa, boolean ketersediaan, String no_polisi) {
        super(id, merk, tipe, harga_sewa, ketersediaan, no_polisi);
    }

    @Override
    public String toString() {
        return getId() + " - " + getMerk() + " " + getTipe();
    }
}
