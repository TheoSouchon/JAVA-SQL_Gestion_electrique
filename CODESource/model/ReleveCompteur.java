package controleContinu.model;

import java.time.LocalDateTime;

public class ReleveCompteur {
	@Override
	public String toString() {
		return "ReleveCompteur [idReleveCompteur=" + idReleveCompteur + ", operateur=" + operateur + ", montantElec="
				+ montantElec + ", dateReleve=" + dateReleve + "]";
	}

	private int idReleveCompteur;

	public int getIdReleveCompteur() {
		return idReleveCompteur;
	}

	public void setIdReleveCompteur(int idReleveCompteur) {
		this.idReleveCompteur = idReleveCompteur;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public int getMontantElec() {
		return montantElec;
	}

	public void setMontantElec(int montantElec) {
		this.montantElec = montantElec;
	}

	public LocalDateTime getDateReleve() {
		return dateReleve;
	}

	public void setDateReleve(LocalDateTime dateReleve) {
		this.dateReleve = dateReleve;
	}

	private String operateur;
	private int montantElec;
	private LocalDateTime dateReleve;
}
