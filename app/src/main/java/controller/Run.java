package controller;

import model.domain.SolarManager;
import model.domain.SolarSystem;
import view.Console;

/**
 * run class.
 */
public class Run {

  /**
   * main run function.
   */
  public static void main(String[] args) {
    Console ui = new Console();
    SolarSystem ss = new SolarSystem();
    SolarManager sm = new SolarManager();
    Controller controller = new Controller(ui, ss, sm);
    MainMenu menu = new MainMenu(ui, ss, controller, sm);

    menu.showMainMenu();

  }

}
