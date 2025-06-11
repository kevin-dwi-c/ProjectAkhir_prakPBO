/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Date;
import java.util.List;
import model.MobilComboItem;
import model.PengembalianModel;
import model.RentalModel;
import repository.CustomerRepository;
import repository.PengembalianRepository;
import repository.RentalRepository;
import view.Pengembalian;

public class PengembalianController {

    private Pengembalian view;
    private PengembalianRepository kembaliRepo = new PengembalianRepository();
    private RentalRepository rentalRepo = new RentalRepository();
    private CustomerRepository customerRepo = new CustomerRepository();
    private List<PengembalianModel> data;
    private PengembalianModel selectedKembali;
    private MobilComboItem selectedMobil;
    private RentalModel selectedRental;
    private int total;
    private int denda;
    private Date tgl_kembali;
    private int hari_telat;

    public PengembalianController(Pengembalian view) {
        this.view = view;
        Refresh();
    }

    private void Refresh() {
        data = kembaliRepo.getAllItems();
        loadMobilToComboBox();
    }

    public void add() {
        var kembali = new PengembalianModel(0, selectedRental.getId_mobil(), selectedRental.getId_customer(), tgl_kembali, hari_telat, total);
        if (kembaliRepo.add(kembali)) {
            rentalRepo.delete(selectedRental.getId());
            view.showMessage("Mobil Berhasil DiKembalikan");
            kembaliRepo.updateKetersediaanMobil(selectedRental.getId_mobil(), true);
            view.resetForm();
            Refresh();
        } else {
            view.showMessage("Mobil Gagal Dikembalikan");
        }
    }

    public void loadMobilToComboBox() {
        List<MobilComboItem> listMobil = kembaliRepo.getAllMobilComboItems();
        view.setMobilComboBoxItems(listMobil);
    }

    public void setSelectedMobil(MobilComboItem item) {
        selectedMobil = item;
        selectedRental = rentalRepo.getByMobilID(item.getId());
        var customer = customerRepo.getByCustomerID(selectedRental.getId_customer());
        view.setCustomerName(customer.getNama());
    }

    public void setTanggalKembali(Date tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
        if (selectedMobil != null && selectedRental != null) {
                denda = 0;
                hari_telat = 0;
            if (tgl_kembali.after(selectedRental.getTgl_balik())) {
                long selisihMS = tgl_kembali.getTime() - selectedRental.getTgl_balik().getTime();
                 hari_telat = (int) (selisihMS / (1000 * 60 * 60 * 24));
                denda = 100000 * hari_telat;
            }
             total = selectedRental.getTotal_bayar() + denda;
            view.setHarga(denda, total);
        }
    }
    
    public void submit(){
        if(selectedRental != null){
            add();
        }
    }
}
