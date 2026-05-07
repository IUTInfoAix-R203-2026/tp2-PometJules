package fr.univ_amu.iut.exercice3;

/**
 * Exercice 3 - Convertisseur de chiffres romains en nombres arabes.
 *
 * <p>Règles :
 *
 * <ul>
 *   <li>Les symboles valides sont {@code I=1, V=5, X=10, L=50, C=100, D=500, M=1000}
 *   <li>Lus de gauche à droite, les symboles s'additionnent : {@code VI = 5 + 1 = 6}
 *   <li>Un symbole placé avant un symbole de valeur supérieure se soustrait : {@code IV = 5 - 1 =
 *       4}
 *   <li>Les seules soustractions valides sont :
 *       <ul>
 *         <li>I avant V ou X ({@code IV = 4}, {@code IX = 9})
 *         <li>X avant L ou C ({@code XL = 40}, {@code XC = 90})
 *         <li>C avant D ou M ({@code CD = 400}, {@code CM = 900})
 *       </ul>
 *       Toute autre soustraction doit lever {@link IllegalArgumentException}.
 * </ul>
 */
public class ConvertisseurDeNombreRomain {

  /**
   * Convertit une chaîne de chiffres romains en valeur entière.
   *
   * @param chiffreRomain chaîne composée de symboles romains (par exemple {@code "XLIX"})
   * @return la valeur entière correspondante
   * @throws IllegalArgumentException si la chaîne contient un symbole invalide ou une soustraction
   *     interdite
   */
  public int enNombreArabe(String chiffreRomain) {
    int total = 0;
    // TODO exercice 3 : remplir total en parcourant la chaîne.
    //
    // Activez les tests un par un. Commencez par "I" = 1 (fake it en
    // retournant 1 en dur), puis "II" = 2 et "III" = 3 (boucle de comptage
    // d'occurrences de I), puis "V" = 5 (switch sur le symbole).
    //
    // Quand vous arrivez à "IV" = 4 : extrayez une méthode valeurDe(char)
    // pour factoriser, puis ajoutez la logique de soustraction.
    //
    // Pour les exceptions : une soustraction est valide seulement pour
    // I avant V/X, X avant L/C, C avant D/M. Tout le reste est invalide.
    String upper = chiffreRomain.toUpperCase();

    for (int i = 0; i < upper.length(); i++) {
      int valeurCourante = valeurDe(upper.charAt(i));

      if (i + 1 < upper.length()) {
        int valeurSuivante = valeurDe(upper.charAt(i + 1));

        if (valeurCourante < valeurSuivante) {
          verifierSoustractionValide(upper.charAt(i), upper.charAt(i + 1));
          total += valeurSuivante - valeurCourante;
          i++; // on saute le caractère suivant, déjà traité
        } else {
          total += valeurCourante;
        }
      } else {
        total += valeurCourante;
      }
    }
    return total;
  }

  private int valeurDe(char symbole) {
    switch (symbole) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        throw new IllegalArgumentException("Symbole romain invalide : " + symbole);
    }
  }

  private void verifierSoustractionValide(char gauche, char droite) {
    boolean valide =
        (gauche == 'I' && (droite == 'V' || droite == 'X'))
            || (gauche == 'X' && (droite == 'L' || droite == 'C'))
            || (gauche == 'C' && (droite == 'D' || droite == 'M'));

    if (!valide) {
      throw new IllegalArgumentException("Soustraction invalide : " + gauche + " avant " + droite);
    }
  }
}
