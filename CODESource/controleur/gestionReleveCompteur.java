package controleContinu.controleur;

import java.time.LocalDate;

import controleContinu.model.ReleveCompteur;

public class gestionReleveCompteur {
	public static ReleveCompteur getReleveDate(int idClient, LocalDate date) {
		return ReleveCompteurDAO.getReleve(idClient, date);
	}

	public static ReleveCompteur getReleveDatePro(int idClient, int idCompteur, LocalDate date) {
		return ReleveCompteurDAO.getRelevePro(idClient, idCompteur, date);
	}

}
