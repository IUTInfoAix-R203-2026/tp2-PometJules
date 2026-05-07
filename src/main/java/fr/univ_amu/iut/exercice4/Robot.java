package fr.univ_amu.iut.exercice4;

public class Robot {

  private Position position;
  private Orientation orientation;

  public Robot(Position position, Orientation orientation) {
    this.position = position;
    this.orientation = orientation;
  }

  public Position getPosition() {
    return position;
  }

  public Orientation getOrientation() {
    return orientation;
  }

  public void tournerADroite() {
    Orientation[] valeurs = Orientation.values();
    orientation = valeurs[(orientation.ordinal() + 1) % valeurs.length];
  }

  public void tournerAGauche() {
    Orientation[] valeurs = Orientation.values();
    orientation = valeurs[(orientation.ordinal() + valeurs.length - 1) % valeurs.length];
  }

  public void avancer() {
    switch (orientation) {
      case NORD:
        position = new Position(position.x(), position.y() + 1);
        break;
      case EST:
        position = new Position(position.x() + 1, position.y());
        break;
      case SUD:
        position = new Position(position.x(), position.y() - 1);
        break;
      case OUEST:
        position = new Position(position.x() - 1, position.y());
        break;
    }
  }
}
