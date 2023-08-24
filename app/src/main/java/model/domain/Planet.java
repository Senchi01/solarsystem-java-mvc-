package model.domain;

import java.util.ArrayList;

/**
 * Planet Class.
 */
public class Planet {
  
  private double orbiteSize;
  private double avgRadius;
  private String name;
  private ArrayList<Moon> moons;

  
  /**
   * Constructor.
   */
  public Planet(String name, double avgRadius, double orbiteSize) {
    this.avgRadius = avgRadius;
    this.name = name;
    this.orbiteSize = orbiteSize;
    this.moons = new ArrayList<>();
  }
  
  /*
   * empty constructor.
   */
  public Planet() {
  }

  /**
   * return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * param name the name to set.
   */
  public void setName(String name) {
    this.name = name;
  }
  

  /**
   * set radius.
   */
  public void setAvgRadius(double radius) {
    this.avgRadius = radius;


  }

  public double getAvgRadius() {
    return this.avgRadius;
  }

  /**
   * here we check if the orbit requirment is fullfilled.
   */
  public void setOribte(double oribte) {
    this.orbiteSize = oribte;
  }
  
  /**
   * return the orbiteSize.
   */
  public double getOrbiteSize() {
    return orbiteSize;
  }

  public void addMoon(Moon m) {
    moons.add(m);
  }

  /**
   * return Moon List.
   */
  public ArrayList<Moon> getMoons() {
    return new ArrayList<>(this.moons);
  }

  public void deleteMoon(String key) { 
    moons.removeIf(i -> i.getName().equalsIgnoreCase(key));

  }

}
