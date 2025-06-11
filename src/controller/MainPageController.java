/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.MainpageModel;
import model.MobilModel;
import repository.MainPageRepository;
import view.Login;
import view.MainPage;
import view.Pengembalian;
import view.Rental;

public class MainPageController {

    private MainPage view;
    private MainPageRepository mobilRepo = new MainPageRepository();
    private List<MainpageModel> data;

    public MainPageController(MainPage view) {
        this.view = view;
        Refresh();
    }

    private void Refresh() {
        data = mobilRepo.getAllMobil();
        view.setTabel(data);
    }

    public void Logout() {
        view.getBtnLogout().addActionListener(e -> {
            view.dispose();
            new Login().setVisible(true);
        });
    }

    public void Rental() {
        view.getBtnRental().addActionListener(e -> {
            view.dispose();
            new Rental().setVisible(true);
        });
    }

    public void Kembali() {
        view.getBtnKembalian().addActionListener(e -> {
            view.dispose();
            new Pengembalian().setVisible(true);
        });
    }
}
