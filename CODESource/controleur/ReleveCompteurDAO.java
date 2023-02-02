package controleContinu.controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controleContinu.model.ReleveCompteur;
import controleContinu.utility.Bdd;

public class ReleveCompteurDAO {
	public static ReleveCompteur getReleve(int idClient, LocalDate date) {
		Statement s;
		int valeur = -1;
		ReleveCompteur rc = new ReleveCompteur();
		try {
			s = Bdd.conn.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT * FROM releve INNER JOIN compteur ON releve.idcompteur=compteur.idcompteur INNER JOIN contrat ON compteur.idcontrat=contrat.idcontrat where cast(dateheure as date)='"
							+ date + "' AND contrat.idclient=" + idClient + ";");
			while (rs.next()) {
				rc.setIdReleveCompteur(rs.getInt("releve.idreleve"));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				rc.setDateReleve(LocalDateTime.parse(rs.getString("releve.dateheure"), formatter));
				rc.setMontantElec(rs.getInt("releve.valeurreleve"));
				rc.setOperateur(rs.getString("releve.operateur"));
				valeur = rs.getInt("releve.valeurreleve");

			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (valeur == -1) {
			System.out.println("Relevé n'existe pas\n");
			System.exit(-1);
		}
		return rc;
	}

	public static ReleveCompteur getRelevePro(int idClient, int idCompteur, LocalDate date) {
		Statement s;
		int valeur = -1;
		ReleveCompteur rc = new ReleveCompteur();
		try {
			s = Bdd.conn.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT * FROM releve INNER JOIN compteur ON releve.idcompteur=compteur.idcompteur INNER JOIN contrat ON compteur.idcontrat=contrat.idcontrat where cast(dateheure as date)='"
							+ date + "' AND contrat.idclient=" + idClient + " AND compteur.idcompteur=" + idCompteur
							+ ";");
			System.out.println(
					"SELECT * FROM releve INNER JOIN compteur ON releve.idcompteur=compteur.idcompteur INNER JOIN contrat ON compteur.idcontrat=contrat.idcontrat where cast(dateheure as date)='"
							+ date + "' AND contrat.idclient=" + idClient + " AND compteur.idcompteur=" + idCompteur
							+ ";");
			while (rs.next()) {
				rc.setIdReleveCompteur(rs.getInt("releve.idreleve"));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				rc.setDateReleve(LocalDateTime.parse(rs.getString("releve.dateheure"), formatter));
				rc.setMontantElec(rs.getInt("releve.valeurreleve"));
				rc.setOperateur(rs.getString("releve.operateur"));
				valeur = rs.getInt("releve.valeurreleve");

			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (valeur == -1) {
			System.out.println("Relevé n'existe pas\n");
			System.exit(-1);
		}
		return rc;

	}
}
