package controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import model.domain.Planet;
import model.domain.SolarManager;
import model.domain.SolarSystem;
import model.domain.Star;
import view.Console;


/**
 * controller class.
 */
public class Controller {
  private Console ui;
  private SolarSystem ss;
  private SolarManager sm;


  /**
   * constructor.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP")
  public Controller(Console ui, SolarSystem ss, SolarManager sm) { 
    this.ui = ui;
    this.ss = ss;
    this.sm = sm;
  }

  
  protected void addNewplanet() {
    String name =  ui.addName();
    int radius = ui.addRadius();
    int orbit = ui.addOrbit();
    boolean valid = ss.addPlanet(name, radius, orbit);
    if (!valid) { 
      ui.printInvalidPlanet();
      addNewplanet();
    } else {
      ui.planetAdded(name);
    }
  }

  protected void addNewMoon(Planet p) { 
    String name =  ui.addName();
    int radius = ui.addRadius();
    int orbit = ui.addOrbit();
    boolean valid = ss.addMoon(p, name, radius, orbit);
    if (!valid) { 
      ui.printInvalidMoon();
      addNewMoon(p);
    } else {
      ui.moonAdded(name);
    }
  }


  /**
   * addnew solar system.
   */
  public void createSolar() {
    String solarName = ui.addSolarName();
    String sunName = ui.addSunName();
    double radius = ui.addRadius();
    Star sun = new Star(sunName, radius);
    SolarSystem solarSystem = new SolarSystem(solarName, sun);
    boolean valid = solarSystem.setSun(sun);
    if (!valid) { 
      ui.printInvildSun();
    } else {
      sm.addSolarSystem(solarSystem);
      this.ss = solarSystem;
      ui.solarAdded(solarName);

    }

  }
}
