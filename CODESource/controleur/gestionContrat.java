package controleContinu.controleur;

import java.util.List;

import controleContinu.model.Contrat;

public class gestionContrat {
	public static List<Contrat> getContratVille(String Ville) {
		return ContratDAO.getContratVille(Ville);
	}
}
