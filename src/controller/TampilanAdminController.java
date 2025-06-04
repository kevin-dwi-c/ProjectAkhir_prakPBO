/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.UserModel;
import repository.UserRepository;
import view.TambahMobil;
import view.TampilanAdmin;

public class TampilanAdminController {

    private TampilanAdmin view;
    private UserRepository userRepo = new UserRepository();
    private List<UserModel> data;
    private UserModel selectedUser;
    
    public TampilanAdminController(TampilanAdmin view) {
        this.view = view;
        Refresh();
    }
    
    private void Refresh() {
        data = userRepo.getAllPetugas();
        view.setTabel(data);
        updateSelected(-1);
    }
    
    public void add(String username, String password) {
        var user = new UserModel(0, username, password, UserModel.Role.petugas);
        if (userRepo.add(user)) {
            Refresh();
        } else {
            view.showError("User Gagal Ditambahkan");
        }
    }
    
    public void updateSelected(int index) {
        if (index == -1) {
            selectedUser = null;
        } else {
            selectedUser = data.get(index);
        }
        view.setSelected(selectedUser);
    }
   
    public void edit(String username, String password) {
        if(selectedUser == null){
            view.showError("Belum ada Yang Dipilih");
            return;
        }
        var user = new UserModel(selectedUser.getId(), username, password, UserModel.Role.petugas);
        if (userRepo.update(user)){           
            Refresh();
        } else {
            view.showError("User Gagal Ditambahkan");
        }
    }
    
    public void delete() {
        if(selectedUser == null){
            view.showError("Belum ada Yang Dipilih");
            return;
        }
        if (userRepo.delete(selectedUser.getId())){           
            Refresh();
        } else {
            view.showError("User Gagal Ditambahkan");
        }
    }
    
     public void TambahkanMobil() {
        view.getBtnTambahMobil().addActionListener(e -> {
            view.dispose();
            new TambahMobil().setVisible(true);
        });
    }       
}
