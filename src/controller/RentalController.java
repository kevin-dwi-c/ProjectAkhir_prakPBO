/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import model.MobilComboItem;
import model.MobilModel;
import model.RentalModel;
import repository.MobilRepository;
import repository.RentalRepository;
import view.Rental;
import view.TambahMobil;

/**
 *
 * @author Asus
 */
public class RentalController {

    private Rental view;
    private TambahMobil view2;
    private RentalRepository rentalRepo = new RentalRepository();
    private MobilRepository mobilRepo = new MobilRepository();
    private List<MobilModel> data;
    private MobilModel selectedMobil;

    public RentalController(Rental view) {
        this.view = view;
        initController();
    }

    public void loadMobilToComboBox() {
        List<MobilComboItem> listMobil = rentalRepo.getAllMobilComboItems();
        view.setMobilComboBoxItems(listMobil);
    }

    public void loadCustomerName() {
        String idStr = view.getCustID();
        try {
            int id = Integer.parseInt(idStr);
            String nama = rentalRepo.selectCustomerName(id);
            if (nama != null) {
                view.setNamaCustomer(nama);
            } else {
                view.setNamaCustomer("Customer tidak ditemukan");
            }

        } catch (NumberFormatException e) {
            view.setNamaCustomer("ID harus angka");
        }
    }

    public void add(int id_mobil, int id_customer, Date tanggal_sewa, Date tanggal_kembali, int total_bayar) {
        var Rental = new RentalModel(0, id_mobil, id_customer, tanggal_sewa, tanggal_kembali, total_bayar);
        if (rentalRepo.isDuplicate(id_mobil, id_customer)) {
            view.showError("Data Duplikat, Sudah Pernah Dimasukkan");
            return;
        }
        if (rentalRepo.add(Rental)) {
            view.showMessage("Rental Berhasil Ditambahkan");
            rentalRepo.updateKetersediaanMobil(id_mobil, false);
            loadCustomerName();
            view.resetForm();
            loadMobilToComboBox();
        } else {
            view.showMessage("Mobil Gagal Ditambahkan");
        }
    }

    public void initController() {
        view.getcCarID().addActionListener(e -> loadHargaDanHitungTotal());
    }

    public void loadHargaDanHitungTotal() {
        MobilComboItem selectedItem = (MobilComboItem) view.getcCarID().getSelectedItem();
        
        if (selectedItem == null) {
            view.setBiayaRental("Mobil belum dipilih");
            return;
        }

        int hargaPerHari = selectedItem.getHarga_sewa(); // langsung dari item

        Date tglSewa = view.getTanggalSewa();
        Date tglKembali = view.getTanggalBalik();
        
        if (tglSewa == null || tglKembali == null) {
            view.setBiayaRental("Tanggal belum lengkap");
            view.setDateAwal();
            return;
        }

        long selisihMS = tglKembali.getTime() - tglSewa.getTime();
        int hari = (int) (selisihMS / (1000 * 60 * 60 * 24));

        if (hari <= 0) {
            view.setBiayaRental("Tanggal tidak valid");
            return;
        }

        int totalBiaya = hargaPerHari * hari;
        view.setBiayaRental(String.valueOf(totalBiaya));
    }

}
