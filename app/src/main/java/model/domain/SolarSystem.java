package model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * SolarSystem.
 */
public class SolarSystem {
  private Star sun;
  private String name;
  private Validator validator;

  /**
   * Construct.
   */
  public SolarSystem(String name, Star sun) {
    this.name = name;
    this.validator = new Validator();
    this.sun = sun;

  }

  /**
   * simple constructor.
   */
  public SolarSystem() {
    this.validator = new Validator();

    this.name = this.getName();
  }

  /**
   * return the name.
   * 
   */
  public String getName() {
    return this.name;
  }

  /**
   * return the sun.
   */
  public Star getSun() {
    return this.sun;
  }
  
  /**
   * validate the sun to be added.
   */
  public boolean setSun(Star sun) {
    if (validator.starIsValid(sun)) {
      this.sun = new Star(sun.getName(), sun.getAvgRadius());
      return true;
    }
    return false;
  }
  
  /**
   * addPlanet.
   */
  public boolean addPlanet(String name, int radius, int orbiteSize) {
    Star theSun = this.getSun();
    if (validator.planetIsValid(theSun, name, radius, orbiteSize)) {
      theSun.addPlanet(new Planet(name, radius, orbiteSize));
      return true;
    }
    return false;
  }

  /**
   * addMoon.
   */
  public boolean addMoon(Planet p, String name, int radius, int orbiteSize) {
    Star theSun = getSun();
    if (validator.planetIsValid(theSun, name, radius, orbiteSize)) {
      p.addMoon(new Moon(name, radius, orbiteSize));
      return true;
    }
    return false;

  }

  /**
   * Returns the list of planets.
   */
  public ArrayList<Planet> getPlanets() {
    return getSun().getPlanets();
  }

  /**
   * Deletes a planet from the list of planets in the current solar system.
   */
  public void deletePlanet(String name) {
    Iterator<Planet> planetsIt = getPlanets().iterator();
    while (planetsIt.hasNext()) {
      Planet planet = planetsIt.next();
      if (planet.getName().equals(name)) {
        planetsIt.remove(); // This will now remove the planet from the original list
      }
    }
  }


  /**
   * delete Planet.
   */
  public void deleteMoon(Planet p, String moonName) {
    p.deleteMoon(moonName);
  }

  /**
   * Delete all solar systems and their planets and moons.
   */
  public void deleteSolar() {

    ArrayList<Planet> planets = getPlanets();
    for (Planet planet : planets) {
      planet.getMoons().clear();
    }
    planets.clear();
  }

  /**
   * method to sort the planets by OrbitsSize.
   */
  public ArrayList<Planet> sortBySizes() {
    ArrayList<Planet> planetsToSort = this.getPlanets();
    Collections.sort(planetsToSort, new Comparator<Planet>() {
      @Override
      public int compare(Planet planet1, Planet planet2) {
        Double radius1 = planet1.getAvgRadius();
        Double radius2 = planet2.getAvgRadius();
        return radius1.compareTo(radius2);
      }
    });
    return planetsToSort;
  }

  /**
   * method to sort the planets by OrbitsSize.
   */
  public ArrayList<Planet> sortByOrbitSize() {
    ArrayList<Planet> planetsToSort = this.getPlanets();
    Collections.sort(planetsToSort, new Comparator<Planet>() {
      @Override
      public int compare(Planet planet1, Planet planet2) {
        Double radius1 = planet1.getOrbiteSize();
        Double radius2 = planet2.getOrbiteSize();
        return radius1.compareTo(radius2);
      }
    });
    return planetsToSort;
  }

}
