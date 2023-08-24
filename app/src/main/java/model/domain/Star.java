package model.domain;

import java.util.ArrayList;

/**
 * Star class.
 */
public class Star {

  private double avgRadius;
  private String name;
  private ArrayList<Planet> planets;

  /**
   * constructor. 
   */
  public Star(String name, double avgRadius) {
    this.name = name;
    this.avgRadius = avgRadius;
    this.planets = new ArrayList<>();
  }
  



  /**
   * return the name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * name to check set.
   */
  public void setName(String name) { 
    this.name = name;
    
  }

  /**
   * the avgRadius to set.
   */
  public void setAvgRadius(double radius) {
    this.avgRadius = radius;
  }


  public double getAvgRadius() {  
    return this.avgRadius;
  }

  public void addPlanet(Planet p) {
    this.planets.add(p);
  }
  
  /**
   * return the planets.
   */
  public ArrayList<Planet> getPlanets() {
    return this.planets;
  }


}
