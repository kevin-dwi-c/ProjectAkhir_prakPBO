/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.CustomerModel;
import repository.CustomerRepository;
import repository.CustomerRepository;
import view.Customer;
import view.MainPage;

/**
 *
 * @author Asus
 */
public class CustomerController {
    private Customer view;
    private CustomerRepository customerRepo = new CustomerRepository();
    private List<CustomerModel> data;
    private CustomerModel selectedCustomer;

    public CustomerController(Customer view) {
        this.view = view;
        Refresh();
    }
    
     private void Refresh() {
        data = customerRepo.getAllCustomer();
        view.setTabel(data);
        updateSelected(-1);
    }
     
     public void updateSelected(int index) {
        if (index == -1) {
            selectedCustomer = null;
        } else {
            selectedCustomer = data.get(index);
        }
        view.setSelected(selectedCustomer);
    }
     
    public void add(String nama, String no_ktp, String alamat, String no_telp) {
        var customer = new CustomerModel(0, nama, no_ktp, alamat, no_telp);
         if(customerRepo.isDuplicate(nama, no_ktp)){
            view.showError("Data Duplikat, Sudah Pernah Dimasukkan");
            return;
        }
        if (customerRepo.add(customer)) {
            view.showMessage("customer Berhasil Ditambahkan");
            view.resetForm();
            Refresh();
        } else {
            view.showMessage("customer Gagal Ditambahkan");
        }
    }
    
        public void edit(String nama, String no_ktp, String alamat, String no_telp) {
        if(selectedCustomer == null){
            view.showError("Belum ada Yang Dipilih");
            return;
        }
        var mobil = new CustomerModel(selectedCustomer.getId(),nama, no_ktp, alamat, no_telp);
        if (customerRepo.update(mobil)){           
            Refresh();
        } else {
            view.showError("Mobil Gagal Diedit");
        }
    }
    
    public void delete() {
        if(selectedCustomer == null){
            view.showError("Belum ada Yang Dipilih");
            return;
        }
        if (customerRepo.delete(selectedCustomer.getId())){           
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
    
     public void gotoMainPage() {
        view.getBtnCancel().addActionListener(e -> {
            view.dispose();
            new MainPage().setVisible(true);
        });
    }
}
