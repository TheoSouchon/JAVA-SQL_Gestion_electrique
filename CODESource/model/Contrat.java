package controleContinu.model;

import java.time.LocalDate;

public class Contrat {
	private int IdContrat;
	private String adresseLocal;
	private LocalDate dateSignature;
	private LocalDate dateDebut;
	private Compteur compteur;
	private int maxVolumeElecContrat;

	public int getIdContrat() {
		return IdContrat;
	}

	public void setIdContrat(int idContrat) {
		IdContrat = idContrat;
	}

	public String getAdresseLocal() {
		return adresseLocal;
	}

	public void setAdresseLocal(String adresseLocal) {
		this.adresseLocal = adresseLocal;
	}

	public LocalDate getDateSignature() {
		return dateSignature;
	}

	public void setDateSignature(LocalDate dateSignature) {
		this.dateSignature = dateSignature;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Compteur getCompteur() {
		return compteur;
	}

	public void setCompteur(Compteur compteur) {
		this.compteur = compteur;
	}

	public int getMaxVolumeElecContrat() {
		return maxVolumeElecContrat;
	}

	public void setMaxVolumeElecContrat(int maxVolumeElecContrat) {
		this.maxVolumeElecContrat = maxVolumeElecContrat;
	}

	@Override
	public String toString() {
		return "Contrat [IdContrat=" + IdContrat + ", adresseLocal=" + adresseLocal + ", dateSignature=" + dateSignature
				+ ", dateDebut=" + dateDebut + ", compteur=" + compteur + ", maxVolumeElecContrat="
				+ maxVolumeElecContrat + "]\n";
	}

}
