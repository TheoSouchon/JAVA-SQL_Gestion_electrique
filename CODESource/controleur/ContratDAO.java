package controleContinu.controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controleContinu.model.Contrat;
import controleContinu.utility.Bdd;

public class ContratDAO {
	public static List<Contrat> getContratVille(String Ville) {
		Statement s;
		List<Contrat> listContrat = new ArrayList<Contrat>();
		try {
			s = Bdd.conn.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT * from contrat inner join client on contrat.idclient=client.idclient where ville='" + Ville
							+ "';");
			while (rs.next()) {
				Contrat contrat = new Contrat();
				contrat.setIdContrat(rs.getInt("contrat.idcontrat"));
				contrat.setAdresseLocal(rs.getString("contrat.adresselocal"));
				LocalDate dateSignature = LocalDate.parse(rs.getString("contrat.dateemission"));
				contrat.setDateSignature(dateSignature);
				LocalDate dateEmission = LocalDate.parse(rs.getString("contrat.datedebut"));
				contrat.setDateDebut(dateEmission);
				contrat.setIdContrat(rs.getInt("contrat.idclient"));
				contrat.setMaxVolumeElecContrat(rs.getInt("contrat.maxKwh"));
				listContrat.add(contrat);
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listContrat;
	}
}
