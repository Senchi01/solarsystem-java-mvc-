package model.domain;

import java.util.ArrayList;

/**
 * class to controll solarsystem.
 */
public class SolarManager {
  private ArrayList<SolarSystem> solars;

  public SolarManager() {
    this.solars = new ArrayList<>();
  }

  public void addSolarSystem(SolarSystem solarSystem) {
    solars.add(solarSystem);
  }

  public void deleteSolarSystem(SolarSystem solarSystem) {
    solars.remove(solarSystem);
  }

  /**
   * retuns a copy of the solars.
   */
  public ArrayList<SolarSystem> getAllSolarSystems() {
    ArrayList<SolarSystem> solarList = new ArrayList<>();
    solars.forEach(s -> solarList.add(s));
    return solarList;
  }
}
