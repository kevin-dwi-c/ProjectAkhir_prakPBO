/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.MobilModel;
import repository.MobilRepository;
import view.TambahMobil;
import view.TampilanAdmin;

/**
 *
 * @author Asus
 */
public class TambahMobilController {

    private TambahMobil view;
    private MobilRepository MobilRepo = new MobilRepository();
    private List<MobilModel> data;
    private MobilModel selectedMobil;

    public TambahMobilController(TambahMobil view) {
        this.view = view;
        initListener();
        Refresh();
    }
    
     private void Refresh() {
        data = MobilRepo.getAllMobil();
        view.setTabel(data);
        updateSelected(-1);
    }
     
     public void updateSelected(int index) {
        if (index == -1) {
            selectedMobil = null;
        } else {
            selectedMobil = data.get(index);
        }
        view.setSelected(selectedMobil);
    }

    public void add(String merk, String tipe, int harga_sewa, boolean ketersediaan, String no_polisi) {
        var mobil = new MobilModel(0, merk, tipe, harga_sewa, ketersediaan, no_polisi);
         if(MobilRepo.isDuplicate(merk, no_polisi)){
            view.showError("Data Duplikat, Sudah Pernah Dimasukkan");
            return;
        }
        if (MobilRepo.add(mobil)) {
            view.showMessage("Mobil Berhasil Ditambahkan");
            view.resetForm();
            Refresh();
        } else {
            view.showMessage("Mobil Gagal Ditambahkan");
        }
    }
    
    public void edit(String merk,String tipe, int harga_sewa, boolean ketersediaan, String no_polisi) {
        if(selectedMobil == null){
            view.showError("Belum ada Yang Dipilih");
            return;
        }
        var mobil = new MobilModel(selectedMobil.getId(), merk, tipe, harga_sewa, ketersediaan, no_polisi);
        if (MobilRepo.update(mobil)){           
            Refresh();
        } else {
            view.showError("Mobil Gagal Diedit");
        }
    }
    
    public void delete() {
        if(selectedMobil == null){
            view.showError("Belum ada Yang Dipilih");
            return;
        }
        if (MobilRepo.delete(selectedMobil.getId())){           
            Refresh();
        } else {
            view.showError("User Gagal Ditambahkan");
        }
    }
    
    public void initListener() {
        view.getBtnRefresh().addActionListener(e -> {
            view.resetForm();
        });
    }
    
     public void gotoAdmin() {
        view.getBtnCancel().addActionListener(e -> {
            view.dispose();
            new TampilanAdmin().setVisible(true);
        });
    }
}
