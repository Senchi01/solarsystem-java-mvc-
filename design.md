# SolarSystem OO-Design
This document describes the design according to the requirements presented in assignment 2.

## Architectural Overview
The application uses the model-view-controller (MVC) architectural pattern. The view is passive and gets called from the controller. The view may only read information from the model, not directly change it.

![class diagram](img/package_diagram.jpg)

## Detailed Design
### Class Diagram
![class diagram](img/Class_diagram.png)

### Sequence Diagram
#### addNewPlanet sequence diagram
![seq_diagram](img/seq_diagram.png)
