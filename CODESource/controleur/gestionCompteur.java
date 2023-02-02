package controleContinu.controleur;

import java.util.List;

import controleContinu.model.Compteur;

public class gestionCompteur {
	public static List<Compteur> getCompteurModele(String modele) {
		return CompteurDAO.getCompteurModel(modele);
	}
}
