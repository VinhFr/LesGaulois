package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public void booster(Gaulois gaulois) {
		int potion2;
		potion2=preparerPotion();
		if (gaulois.getNom() == "Obelix") {
			parler("Non, Obélix !... Tu n’auras pas de potion magique ! »");
		} else {
			gaulois.boirePotion(potion2);
		}
	}

	public int preparerPotion() {
		Random rand = new Random();
		int nb_retourne = rand.nextInt(effetPotionMax - effetPotionMin) + effetPotionMin;
		forcePotion = nb_retourne;
		if (nb_retourne > 7) {
			parler("J'ai prepare une super potion de force " + forcePotion);
		} else {
			parler("Je n'ai pas trouve tous les ingredients, ma potion est seulement de force " + forcePotion);
		}
		return nb_retourne;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
	}

}
