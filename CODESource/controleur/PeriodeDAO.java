package controleContinu.controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import controleContinu.model.Periode;
import controleContinu.utility.Bdd;

public class PeriodeDAO {
	public static Periode getPeriode(LocalDate dateDbt, LocalDate dateFin) {
		Statement s;
		int prix = -1;
		try {
			s = Bdd.conn.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT prixKwh FROM periode WHERE debut='" + dateDbt + "' AND fin='" + dateFin + "';");
			rs.next();
			prix = rs.getInt("periode.prixKwh");
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (prix == -1) {
			System.out.println("La période n'existe pas\n");
			System.exit(-1);
		}
		Periode p = new Periode(dateDbt, dateFin, prix);
		return p;

	}
}
