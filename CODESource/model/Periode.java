package controleContinu.model;

import java.time.LocalDate;

public class Periode {

	@Override
	public String toString() {
		return "Periode [dateDebt=" + dateDebt + ", dateFin=" + dateFin + ", prixElec=" + prixElec + "]";
	}

	private LocalDate dateDebt;
	private LocalDate dateFin;
	private int prixElec;

	public Periode(LocalDate dateDbt, LocalDate dateFin2, int prix) {
		this.dateDebt = dateDbt;
		this.dateFin = dateFin2;
		this.prixElec = prix;
		// TODO Auto-generated constructor stub
	}

	public int getPrixElec() {
		return prixElec;
	}

	public void setPrixElec(int prixElec) {
		this.prixElec = prixElec;
	}
}
