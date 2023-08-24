package controller;


import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import model.domain.Moon;
import model.domain.Planet;
import model.domain.SolarManager;
import model.domain.SolarSystem;
import view.Console;
import view.Console.MoonMenu;
import view.Console.PlanetMenu;
import view.Console.SolarMenu;



/**
 * mainmenu class.
 */
public class MainMenu {
  Planet planet;
  SolarSystem ss;
  Moon moon;
  Console ui;
  Controller controller;
  SolarManager sm;


  /**
   * Main Menu.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP")
  public MainMenu(Console ui, SolarSystem ss, Controller controller, SolarManager sm) {
    this.controller = controller;
    this.ss = ss;
    this.ui = ui;
    this.sm = sm;

  }

  protected void showMainMenu() { 
    boolean on = true;

    while (on) {
      switch (ui.showMainMenu()) {
        case CreateSolar:
          controller.createSolar();
          break;
        case ShowALL:
          ui.showSolarSystems(sm.getAllSolarSystems());
          break;
        case SelectSolar:
          if (!sm.getAllSolarSystems().isEmpty()) {
            ss = ui.getSolar(sm.getAllSolarSystems());
            showSolarMenu(ui.showSolarMenu(ss));
            break;
          }
          ui.showListIsEmpty();
          break;
        case Quit:
          on = false;
          break;
        default:
          break;
      }
      
    }

  }

  private void showSolarMenu(SolarMenu showSolarMenu) {
    switch (showSolarMenu) {
      case AddPlanet:
        controller.addNewplanet();
        break;
      case DeleteSolar:
        if (ss != null) {
          ss.deleteSolar();
          sm.deleteSolarSystem(ss); // Pass the selected solar system to the method
          ss = null; // Reset the selected solar system after deletion
        }
        break;
      case ListSolarBySize:
        ui.printSolarOrderedBySize(ss);
        break;
      case ListSolarByOrbit:
        ui.printSolarOrderedByOrbit(ss);
        break;
      case SelectPlanet:
        if (!ss.getPlanets().isEmpty()) {
          planet = ui.selectPlanet(ss.getPlanets());
          showPlanetMenu(ui.showPlanetMenu(planet));
          break;
        }
        ui.showListIsEmpty();
        break;
      case ShowDetails:
        ui.showSolarDetails(sm.getAllSolarSystems(), ss);
        break;
      case Cancel:
        ss = null;
        break;
      default:
        break;
    }
  }

  private void showPlanetMenu(PlanetMenu planetMenu) {
    switch (planetMenu) {
      case AddMoon:
        controller.addNewMoon(planet);
        break;
      case ShowMoons:
        ui.printMoons(planet);
        break;
      case DeletePlanet:
        ss.deletePlanet(planet.getName());
        break;
      case Cancel:
        planet = null;
        break;
      case SelectMoon:
        if (!planet.getMoons().isEmpty()) {
          moon = ui.selectMoon(planet.getMoons());
          showMoonsMenu(ui.showMoonMenu(moon));
          break;

        }
        ui.showListIsEmpty();
        break;
      case ShowDetails:
        ui.showPlanetDetails(planet);
        break;
      default:
        break;
    }
  }

  private void showMoonsMenu(MoonMenu showMoonMenu) {
    switch (showMoonMenu) {
      case DeleteMoon:
        ss.deleteMoon(planet, moon.getName());
        break;
      case ShowDetails:
        ui.showMoonDetails(moon);
        break;
      case Cancel:
        moon = null;
        break;
      default:
        break;
    }
  }

}
