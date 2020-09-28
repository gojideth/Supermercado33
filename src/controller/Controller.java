package controller;

import model.supermarket.Manager;
import views.IoManager;

public class Controller {
    private Manager manager;
    private IoManager ioManager;

    public Controller(Manager manager, IoManager ioManager) {
        this.manager = manager;
        this.ioManager = new IoManager();
    }



}
