package controleContinu.model;

import java.time.LocalDate;

public class Facture {
	private int idFacture;
	private LocalDate dateDebt;
	private LocalDate dateFin;
	private LocalDate dateEmission; // date d'envoi de la facture
	private LocalDate datePaiement;
	private int montantPaiement;
	private int quantiteElec;
	private ReleveCompteur releveDbt;
	private ReleveCompteur releveFin;
}
