package view;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import model.domain.Moon;
import model.domain.Planet;
import model.domain.SolarSystem;

/**
 * console class.
 */
public class Console {
  Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

  /**
   * startMenu options.
   */
  public enum StartMenu {
    CreateSolar,
    SelectSolar,
    ShowALL,
    Quit,
    Error
  }

  /**
   * SolarMenu options.
   */
  public enum SolarMenu {
    AddPlanet,
    ListSolarBySize,
    ListSolarByOrbit,
    DeleteSolar,
    ShowPlanets,
    ShowDetails,
    SelectPlanet,
    Cancel,
    Error
  }

  /**
   * PlanetMenu options.
   */
  public enum PlanetMenu {
    AddMoon,
    DeletePlanet,
    ShowMoons,
    SelectMoon,
    Cancel,
    ShowDetails,
    Error
  }

  /**
   * moon menu options.
   */
  public enum MoonMenu {
    DeleteMoon,
    ShowDetails,
    Cancel,
    Error
  }

  /**
   * main menu entry.
   */
  public StartMenu showMainMenu() {
    System.out.println("\nMain Menu:");
    System.out.println("1. Create a new Solar");
    System.out.println("2. Select a Solar");
    System.out.println("3. Show all solar systems");
    System.out.println("0. Quit");
    System.out.println(">>");

    int choice = scanner.nextInt();
    scanner.nextLine();

    switch (choice) {
      case 1:
        return StartMenu.CreateSolar;
      case 2:
        return StartMenu.SelectSolar;
      case 3:
        return StartMenu.ShowALL;
      case 0:
        return StartMenu.Quit;
      default:
        System.out.println("Invalid choice. Please try again.");
        showMainMenu();
        return StartMenu.Error;
    }

  }

  /**
   * Solar menu.
   */
  public SolarMenu showSolarMenu(SolarSystem solar) {
    System.out.println("\n" + "Solar chosen is: " + solar.getName());
    System.out.println("Solar Menu:");
    System.out.println("1. delete a Solar");
    System.out.println("2. Add a new Planet");
    System.out.println("3. List Solar (size)");
    System.out.println("4. List Solar (orbit)");
    System.out.println("5. Select planet");
    System.out.println("6. show details");
    System.out.println("0. Return to Main Menu");
    System.out.println(">>");

    int choice = scanner.nextInt();
    scanner.nextLine();

    switch (choice) {
      case 1:
        return SolarMenu.DeleteSolar;
      case 2:
        return SolarMenu.AddPlanet;
      case 3:
        return SolarMenu.ListSolarBySize;
      case 4:
        return SolarMenu.ListSolarByOrbit;
      case 5:
        return SolarMenu.SelectPlanet;
      case 6:
        return SolarMenu.ShowDetails;
      case 0:
        return SolarMenu.Cancel;
      default:
        System.out.println("Invalid choice. Please try again.");
        return SolarMenu.Error;
    }
  }

  /**
   * Planets menu.
   */
  public PlanetMenu showPlanetMenu(Planet planet) {
    System.out.println("\n" + "Planet chosen is: " + planet.getName());
    System.out.println("Planet Menu:");
    System.out.println("1. Add a new Moon");
    System.out.println("2. Select a Moon");
    System.out.println("3. Show all Moons");
    System.out.println("4. Delete Planet");
    System.out.println("5. Show Planet details");
    System.out.println("0. Return to Main Menu");
    System.out.println(">>");

    int choice = scanner.nextInt();
    scanner.nextLine();

    switch (choice) {
      case 1:
        return PlanetMenu.AddMoon;
      case 2:
        return PlanetMenu.SelectMoon;
      case 3:
        return PlanetMenu.ShowMoons;
      case 4:
        return PlanetMenu.DeletePlanet;
      case 5:
        return PlanetMenu.ShowDetails;
      case 0:
        return PlanetMenu.Cancel;
      default:
        System.out.println("Invalid choice. Please try again.");
        return PlanetMenu.Error;
    }

  }

  /**
   * moon menu.
   */
  public MoonMenu showMoonMenu(Moon moon) {
    System.out.println("\n" + "Planet chosen is: " + moon.getName());
    System.out.println("Moon Menu:");
    System.out.println("1. Delete Moon");
    System.out.println("2. show Moon details");
    System.out.println("0. Return to Main Menu");
    System.out.println(">>");

    int choice = scanner.nextInt();
    scanner.nextLine();

    switch (choice) {
      case 1:
        return MoonMenu.DeleteMoon;
      case 2:
        return MoonMenu.ShowDetails;
      case 0:
        return MoonMenu.Cancel;
      default:
        System.out.println("Invalid choice. Please try again.");
        return MoonMenu.Error;
    }

  }

  /**
   * returns the selected planet.
   */
  public Planet selectPlanet(ArrayList<Planet> myPlanets) {
    int input;
    System.out.println("\nPlease select a planet:\n");
    for (int i = 0; i < myPlanets.size(); i++) {
      System.out.println(i + ". " + myPlanets.get(i).getName());
    }
    do {
      input = scanner.nextInt();
    } while (input > myPlanets.size());
    return myPlanets.get(input);
  }

  /**
   * Read input from the user.
   */
  private String readInput(String message) {
    System.out.println(message);
    String input = scanner.nextLine();
    return input;
  }

  public String addSolarName() {
    String name = readInput("Please enter a name for the solar system:");
    return name;
  }

  public String addSunName() {
    String name = readInput("Please enter a name for the sun:");
    return name;
  }

  /**
   * Get planet name.
   */
  public String addName() {
    String name = readInput("Please enter a name:");
    return name;
  }

  /**
   * Get radius.
   */
  public int addRadius() {
    String radiusStr = readInput("Please enter a radius (km):");
    int radius = Integer.parseInt(radiusStr);
    return radius;
  }

  /**
   * Get orbit.
   */
  public int addOrbit() {
    String orbitStr = readInput("Please enter an orbit(km):");
    int orbit = Integer.parseInt(orbitStr);
    return orbit;
  }

  public void printInvalidPlanet() {

    System.out.println("\nOps!...\nInvalid planet information, please try again!\n");
  }

  public void planetAdded(String name) {
    System.out.println("The planet " + name + " has been succesfully added");
  }

  public void planetRemoved(Planet p) {
    System.out.println("The planet " + p.getName() + " has been removed");
  }

  /**
   * select moon.
   */
  public Moon selectMoon(ArrayList<Moon> moons) {
    int input;
    System.out.println("\nPlease select a moon:\n");
    for (int i = 0; i < moons.size(); i++) {
      System.out.println(i + ". " + moons.get(i).getName());
    }
    do {
      input = scanner.nextInt();
    } while (input > moons.size());
    return moons.get(input);
  }

  public void moonAdded(String name) {
    System.out.println("The Moon " + name + " has been succesfully added");

  }

  /**
   * print moons.
   */
  public void printMoons(Planet planet) {
    int ind = 0;
    for (Moon moon : planet.getMoons()) {
      System.out.println(ind + ". name: " + moon.getName() + ", average radius " + moon.getAvgRadius()
          + ", average orbit radius " + moon.getOrbiteSize() + " km");
    }

  }

  public void printInvalidMoon() {
    System.out.println("\nOps!...\nInvalid moon information, please try again!\n");
  }

  /**
   * print planets ordered by size.
   */
  public void printSolarOrderedBySize(SolarSystem ss) {
    System.out.println("\nSolar System: " + ss.getName());
    System.out.println("Star: " + ss.getSun().getName() + ", average radius "
        + ss.getSun().getAvgRadius());

    int pind = 1;
    for (Planet planet : ss.sortBySizes()) {
      System.out.println("\t " + pind + ". Planet. " + planet.getName()
          + ", average radius: " + planet.getAvgRadius()
          + ", average orbit radius: " + planet.getOrbiteSize() + " km");
      pind++;
      int mind = 1;

      for (Moon moon : planet.getMoons()) {
        System.out.println("\t\t" + mind + ". moon. name: " + moon.getName() + ", average radius: " 
            + moon.getAvgRadius() + ", average orbit radius: " + moon.getOrbiteSize() + " km");
        mind++;
      }
    }
  }

  /**
   * print planets ordered by size.
   */
  public void printSolarOrderedByOrbit(SolarSystem ss) {
    System.out.println("\nSolar System: " + ss.getName());
    System.out.println("Star: " + ss.getSun().getName() + ", average radius "
        + ss.getSun().getAvgRadius());
    
    int pind = 1; 
    for (Planet planet : ss.sortByOrbitSize()) {
      System.out.println("\t " + pind + ". Planet. " + planet.getName()
          + ", average radius: " + planet.getAvgRadius()
          + ", average orbit radius: " + planet.getOrbiteSize() + " km");
      pind++;
      int mind = 1;

      for (Moon moon : planet.getMoons()) {
        System.out.println("\t\t" + mind + ". moon. name: " + moon.getName() + ", average radius: " 
            + moon.getAvgRadius() + ", average orbit radius: " + moon.getOrbiteSize() + " km");
        mind++;
      }
    }
  }

  public void printInvildSun() {
    System.out.println("\nInvild Sun, please try again!");
  }

  public void solarAdded(String solarName) {
    System.out.println("The " + solarName + " sun has been added.");
  }

  /**
   * select a solar.
   */
  public SolarSystem getSolar(ArrayList<SolarSystem> solarSystems) {
    int input;
    System.out.println("\nPlease select a Solar:\n");
    for (int i = 0; i < solarSystems.size(); i++) {
      System.out.println(i + ". " + solarSystems.get(i).getName());
    }
    do {
      input = scanner.nextInt();
    
    } while (input < 0 || input >= solarSystems.size());

    return solarSystems.get(input);
  }

  /**
   * lists all solar systems name.
   */
  public void showSolarSystems(ArrayList<SolarSystem> solarSystems) {
    if (!solarSystems.isEmpty()) {
      int ind = 0;
      for (SolarSystem solarSystem : solarSystems) {
        System.out.println(ind + ". " + solarSystem.getName() + "\n");
        ind++;
      }
    } else {
      System.out.println("no solars available!");

    }

  }

  /**
   * prints information.
   */
  public void showSolarDetails(ArrayList<SolarSystem> solarSystems, SolarSystem ss) {
    for (int i = 0; i < solarSystems.size(); i++) {
      if (solarSystems.get(i) == ss) {
        System.out.println("\nsolar name: " + ss.getName() + "\nsun name: " + ss.getSun().getName()
            + "\n\tsun radius: " + ss.getSun().getAvgRadius() 
            + "\n\tplanets: " + ss.getPlanets().size());
        
      }
    }

  }

  public void showMoonDetails(Moon moon) {
    System.out.println("\nname: " + moon.getName() + "\nradius: " + moon.getAvgRadius()
        + "\norbit" + moon.getOrbiteSize());
  }

  public void showPlanetDetails(Planet planet) {
    System.out.println("\nname: " + planet.getName() + "\nradius: " + planet.getAvgRadius()
        + "\norbit" + planet.getOrbiteSize() + "\nMoons: " + planet.getMoons().size());
  }

  public void showListIsEmpty() {
    System.out.println("The list is empty. please add elements to the list, and then try again.");
  }

}
