package controleContinu.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Properties;

import controleContinu.controleur.gestionFacture;
import controleContinu.model.Periode;
import controleContinu.model.ReleveCompteur;

public class Bdd {

	public static Connection conn;
	public static Statement stmt;

	public static void registerDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void initConnection() {
		Properties userInfo = new Properties();
		userInfo.setProperty("user", "root");
		userInfo.setProperty("password", "password");

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/elec", userInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void creerBases() {
		try {
			Statement stmt = conn.createStatement();
			String sqlclient = "CREATE TABLE IF NOT EXISTS Client  " + "(nom VARCHAR(255), " + "idclient INT NOT NULL, "
					+ "ville VARCHAR(255)," + "nbrbat INT, " + "numerotel INT, " + " PRIMARY KEY ( idclient ))";
			stmt.executeUpdate(sqlclient);
			String sqlperiode = "CREATE TABLE IF NOT EXISTS Periode  " + " (debut DATE, " + "fin DATE, "
					+ "prixKwh INT, " + "idperiode INT NOT NULL," + " PRIMARY KEY ( idperiode ))";
			stmt.executeUpdate(sqlperiode);
			stmt.close();
			Statement stmt2 = conn.createStatement();
			String sqlcontrat = "CREATE TABLE IF NOT EXISTS Contrat " + " (idcontrat INT NOT NULL, "
					+ " adresselocal VARCHAR(255), " + "dateemission DATE," + "datedebut DATE," + "idclient INT ,"
					+ "maxKwh INT NOT NULL," + "FOREIGN KEY (idclient) REFERENCES Client(idclient), "
					+ " PRIMARY KEY ( idcontrat ))";
			stmt2.executeUpdate(sqlcontrat);
			stmt2.close();
			Statement stmt3 = conn.createStatement();
			String sqlcompteur = "CREATE TABLE IF NOT EXISTS Compteur " + " (idcompteur INT NOT NULL, "
					+ " modele VARCHAR(255), " + "maxkwhlivrable INT NOT NULL ," + "dateinstallation DATE,"
					+ "idcontrat INT ," + "FOREIGN KEY (idcontrat) REFERENCES Contrat(idcontrat), "
					+ " PRIMARY KEY ( idcompteur ))";
			stmt3.executeUpdate(sqlcompteur);
			stmt3.close();
			Statement stmt4 = conn.createStatement();
			String sqlreleve = "CREATE TABLE IF NOT EXISTS Releve" + "(idreleve INT NOT NULL," + "idcompteur INT ,"
					+ "operateur VARCHAR(255),valeurreleve int DEFAULT NULL," + "dateheure DATETIME,"
					+ "FOREIGN KEY (idcompteur) REFERENCES Compteur(idcompteur), " + "PRIMARY KEY (idreleve))";
			stmt4.executeUpdate(sqlreleve);
			stmt4.close();

			Statement stmt5 = conn.createStatement();
			String sqlfacture = "CREATE TABLE IF NOT EXISTS Facture" + "(idfacture INT NOT NULL," + "datedebut DATE,"
					+ "datefin DATE," + "datefacture DATE," + "datepaiement DATE," + "Total INT, " + "TotalKwh INT,"
					+ "relevedebut INT , " + "relevefin INT ,"
					+ "FOREIGN KEY (relevedebut) REFERENCES Releve(idreleve), "
					+ "FOREIGN KEY (relevefin) REFERENCES Releve(idreleve), " + "PRIMARY KEY (idfacture))";
			stmt5.executeUpdate(sqlfacture);
			stmt5.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void creerLignes() {
		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO client VALUES ('theo',1,'tours',0,707070707),('clement',2,'ptp',0,707070707),('remifasol',3,'ptp',0,887070707),('corentin',4,'tours',0,108970707),('baptitsé',5,'tours',2,108970707);";
			stmt.executeUpdate(sql);
			String sql5 = "INSERT INTO periode VALUES ('2001-03-17','2001-12-22',0,1),('2001-12-22','2002-02-14',0,2)";
			stmt.executeUpdate(sql5);
			String sql3 = "INSERT INTO contrat VALUES (1,'55 avenue de la bequille','2001-03-17','2001-03-17',1,3000),(2,'235 rue deleglise','2001-12-22','2001-12-22',2,2500)";
			stmt.executeUpdate(sql3);
			String sql2 = "INSERT INTO compteur VALUES (1,'mafusee',2000,'2001-01-01',2),(2,'mafusee',3000,'2001-01-01',1)";
			stmt.executeUpdate(sql2);
			String sql6 = "INSERT INTO releve VALUES (1,1,'mickelangelo',100,'2001-12-22 10:34:09'),(2,1,'raphael',90,'2002-02-14 11:34:50'),(3,2,'leonardo',150,'2001-12-22 09:59:10'),(4,2,'raphael',220,'2002-02-14 09:59:10')";
			stmt.executeUpdate(sql6);
			String sql4 = "INSERT INTO facture VALUES (1,'2001-03-17','2001-12-22','2001-12-22','2001-12-22',10,90,1,2)";
			stmt.executeUpdate(sql4);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void creerFacture(Periode periode, ReleveCompteur releveDbt, ReleveCompteur releveFin) {
		try {
			Statement stmt = conn.createStatement();
			int totalKwh = releveFin.getMontantElec() - releveDbt.getMontantElec();
			int prixTotal = totalKwh * periode.getPrixElec();
			int maxIdFacture = gestionFacture.getMaxIdFacture() + 1;
			String sql = "INSERT INTO facture VALUES (" + maxIdFacture + ",NULL,NULL,NULL,NULL," + prixTotal + ","
					+ totalKwh + "," + releveDbt.getIdReleveCompteur() + "," + releveFin.getIdReleveCompteur() + ");";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void creerContrat(int idContrat, String adresseLocal, LocalDate dateDebutContrat, int idClient,
			int maxKwh) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO contrat VALUES (" + idContrat + ",'" + adresseLocal + "',NULL,'"
					+ dateDebutContrat.toString() + "'," + idClient + "," + maxKwh + ");";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
