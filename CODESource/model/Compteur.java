package controleContinu.model;

import java.time.LocalDate;
import java.util.List;

public class Compteur {

	private int idCompteur;
	private String modele;
	private int maxVolumeElecCompteur;
	private LocalDate dateInstallation;
	private List<ReleveCompteur> listReleve;

	public int getIdCompteur() {
		return idCompteur;
	}

	public void setIdCompteur(int idCompteur) {
		this.idCompteur = idCompteur;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getMaxVolumeElecCompteur() {
		return maxVolumeElecCompteur;
	}

	public void setMaxVolumeElecCompteur(int maxVolumeElecCompteur) {
		this.maxVolumeElecCompteur = maxVolumeElecCompteur;
	}

	public LocalDate getDateInstallation() {
		return dateInstallation;
	}

	public void setDateInstallation(LocalDate dateInstallation) {
		this.dateInstallation = dateInstallation;
	}

	@Override
	public String toString() {
		return "Compteur [idCompteur=" + idCompteur + ", modele=" + modele + ", maxVolumeElecCompteur="
				+ maxVolumeElecCompteur + ", dateInstallation=" + dateInstallation + ", listReleve=" + listReleve
				+ "]\n";
	}

	public List<ReleveCompteur> getListReleve() {
		return listReleve;
	}

	public void setListReleve(List<ReleveCompteur> listReleve) {
		this.listReleve = listReleve;
	}

}
