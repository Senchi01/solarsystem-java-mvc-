package model.domain;

import java.util.ArrayList;

/**
 * validator class.
 */
public class Validator {
  

  
  

  /**
   * validate the Star.
   */
  public boolean starIsValid(Star sun) {
    if (sun.getAvgRadius() > 20000 && !sun.getName().isBlank()) {
      return true;
    } 
    return false;
  }

  /**
   * validate the Planet.
   */
  public boolean planetIsValid(Star sun, String name, int radius, int orbit) {
    ArrayList<Planet> planets = sun.getPlanets();
    for (Planet p : planets) {
      if (p.getName().equalsIgnoreCase(name) || name.isBlank()) {
        return false;
      }
    }
    if (radius <= 1000 && radius >= 10 * sun.getAvgRadius()) {
      return false;
    }
    if (orbit <= 10 * sun.getAvgRadius()) {
      return false;
    }
    return true;
  }
  

  /**
   * validate the Moon.
   */
  public boolean moonIsValid(Planet p, String name, double radius, double orbiteSize) {
    if (radius > 10000 && radius < 17 * p.getAvgRadius()
         && orbiteSize == 5 * p.getOrbiteSize()) {
      return true;
    }
    for (Moon m : p.getMoons()) {
      if (m.getName().equalsIgnoreCase(name) || name.isBlank()) {
        return false;
      }
    }

    return false;
  }

 

}
