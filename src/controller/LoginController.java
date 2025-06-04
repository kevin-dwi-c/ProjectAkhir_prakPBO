/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.UserModel;
import repository.UserRepository;
import view.Login;

public class LoginController {
    private Login view;

    public LoginController(Login view) {
        this.view = view;
    }
    
    private UserRepository userRepo = new UserRepository();
    public void login(String username, String password){
        var user = userRepo.getByUsername(username);
        if(user == null){
            view.showError("Username Tidak Ditemukan");
            return;
        }
        if(!password.equals(user.getPassword())){
            view.showError("Password Salah");
            return;
        }
        if(user.getRole() == UserModel.Role.admin){
            view.GotoAdmin();
        } else if(user.getRole() == UserModel.Role.petugas){
            view.GotoPetugas(); 
        }
    }
 
}
