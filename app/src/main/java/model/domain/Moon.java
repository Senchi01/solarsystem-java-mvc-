package model.domain;

/**
 * Moon class.
 */
public class Moon {

  private String name;
  private double avgRadius;
  private double orbiteSize;

  Moon(String name, double avgRadius, double orbiteSize) {
    this.avgRadius = avgRadius;
    this.name = name;
    this.orbiteSize = orbiteSize;
  }

  public Moon() {

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
  
}
