package fr.univ_amu.iut.exercice4;

public class SimulateurDeRobot {

  private final Robot robot;

  public SimulateurDeRobot(Robot robot) {
    this.robot = robot;
  }

  public void executer(String commandes) {
    for (int i = 0; i < commandes.length(); i++) {
      switch (commandes.charAt(i)) {
        case 'R':
          robot.tournerADroite();
          break;
        case 'L':
          robot.tournerAGauche();
          break;
        case 'A':
          robot.avancer();
          break;
        default:
          throw new IllegalArgumentException("Commande inconnue : " + commandes.charAt(i));
      }
    }
  }

  public Robot getRobot() {
    return robot;
  }
}
