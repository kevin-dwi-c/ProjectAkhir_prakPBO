/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.MobilModel;
import repository.MobilRepository;
import view.TambahMobil;

/**
 *
 * @author Asus
 */
public class TambahMobilController {

    private TambahMobil view;
    private MobilRepository MobilRepo = new MobilRepository();
    private List<MobilModel> data;

    public TambahMobilController(TambahMobil view) {
        this.view = view;
        initListener();
    }

    public void add(String merk, String tipe, int harga_sewa, boolean ketersediaan, String no_polisi) {
        var mobil = new MobilModel(0, merk, tipe, harga_sewa, ketersediaan, no_polisi);
        if (MobilRepo.add(mobil)) {
            view.showMessage("Mobil Berhasil Ditambahkan");
        } else {
            view.showMessage("Mobil Gagal Ditambahkan");
        }
    }
    
    public void initListener() {
        view.getBtnRefresh().addActionListener(e -> {
            view.resetForm();
        });
    }
}
