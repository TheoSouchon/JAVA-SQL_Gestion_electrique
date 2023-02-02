package controleContinu.controleur;

import java.time.LocalDate;

import controleContinu.model.Periode;

public class gestionPeriode {
	public static Periode getPeriodeFacture(LocalDate dateDbt, LocalDate dateFin) {
		return PeriodeDAO.getPeriode(dateDbt, dateFin);
	}
}
