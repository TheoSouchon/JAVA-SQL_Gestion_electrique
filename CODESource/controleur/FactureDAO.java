package controleContinu.controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controleContinu.utility.Bdd;

public class FactureDAO {
	public static int getMaxIdFacture() {
		Statement s;
		int maxId = 0;
		try {
			s = Bdd.conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT max(idfacture) from facture;");
			rs.next();
			maxId = rs.getInt(1);
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxId;
	}
}
