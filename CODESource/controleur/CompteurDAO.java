package controleContinu.controleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controleContinu.model.Compteur;
import controleContinu.utility.Bdd;;

public class CompteurDAO {
	public static List<Compteur> getCompteurModel(String modele) {
		List<Compteur> listCompteur = new ArrayList<Compteur>();
		PreparedStatement ps;
		try {
			ps = Bdd.conn.prepareStatement("SELECT * FROM compteur WHERE modele=?");
			ps.setString(1, modele);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Compteur compteur = new Compteur();
				compteur.setIdCompteur(rs.getInt("compteur.idcompteur"));
				compteur.setModele(rs.getString("compteur.modele"));
				compteur.setMaxVolumeElecCompteur(rs.getInt("compteur.maxkwhlivrable"));
				String dateInstallation = rs.getString("compteur.dateinstallation");
				compteur.setDateInstallation(LocalDate.parse(dateInstallation));
				listCompteur.add(compteur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listCompteur;
	}
}
