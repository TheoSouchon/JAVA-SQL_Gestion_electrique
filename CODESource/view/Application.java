package controleContinu.view;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import controleContinu.controleur.gestionCompteur;
import controleContinu.controleur.gestionContrat;
import controleContinu.controleur.gestionPeriode;
import controleContinu.controleur.gestionReleveCompteur;
import controleContinu.model.Compteur;
import controleContinu.model.Contrat;
import controleContinu.model.Periode;
import controleContinu.model.ReleveCompteur;
import controleContinu.utility.Bdd;

public class Application {

	public static void main(String[] args) {

		Bdd.registerDriver();
		Bdd.initConnection();
		Bdd.creerBases(); // IF NOT EXIST
		// insererNouveauContrat();
		// Bdd.creerLignes();
		// rechercheClientVille();
		// infoCompteurModele();

//		try {
//			creerFacture(); // FONCTION 1
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}

	}

	private static void creerFacture() throws ParseException {
		int idCompteur = 0;
		System.out.println("Le client est-il prive ou pro ? (priv/pro)");
		Scanner scanner = new Scanner(System.in);
		String typeClient = scanner.nextLine();
		if (!typeClient.equals("priv") && !typeClient.equals("pro")) {
			System.out.println("Type client : " + typeClient + " invalide\n");
			System.exit(-1);
		}
		System.out.println("Entrer l'id du client à facturer");
		int idClient = scanner.nextInt();
		scanner.nextLine();
		if (typeClient.equals("pro")) {
			System.out.println("Entrer id compteur de la facture");
			idCompteur = scanner.nextInt();
			scanner.nextLine();
		}

		// System.out.println("Entrer date de début de facture (yyyy-MM-dd/yyyy-MM-dd
		// HH:mm:ss)");
		// String dateDbt = scanner.nextLine();
		String dateDbt = "2001-12-22";
		LocalDate dateDbt2 = LocalDate.parse(dateDbt.substring(0, 10));
		// System.out.println("Entrer date de fin de facture (yyyy-mm-dd/yyyy-mm-dd
		// hh:mm:ss)");
		// String dateFin = scanner.nextLine();
		String dateFin = "2002-02-14";
		LocalDate dateFin2 = LocalDate.parse(dateFin.substring(0, 10));
		scanner.close();
		Periode p = gestionPeriode.getPeriodeFacture(dateDbt2, dateFin2); // On check et créer l'object periode
		System.out.println(p);
		// on check et créer les objets relevés

		if (typeClient.equals("pro")) {
			ReleveCompteur rc1 = gestionReleveCompteur.getReleveDatePro(idClient, idCompteur, dateDbt2);
			System.out.println(rc1);
			ReleveCompteur rc2 = gestionReleveCompteur.getReleveDatePro(idClient, idCompteur, dateFin2);
			System.out.println(rc2);
			Bdd.creerFacture(p, rc1, rc2); // on créer les objets facture selon les infos recup
		} else {
			ReleveCompteur rc1 = gestionReleveCompteur.getReleveDate(idClient, dateDbt2);
			System.out.println(rc1);
			ReleveCompteur rc2 = gestionReleveCompteur.getReleveDate(idClient, dateFin2);
			System.out.println(rc2);
			Bdd.creerFacture(p, rc1, rc2); // on créer les objets facture selon les infos recup
		}

	}

	private static void rechercheClientVille() {
		System.out.println("Entrer la ville des clients à chercher\n");
		Scanner scanner = new Scanner(System.in);
		String villeClient = scanner.nextLine();
		List<Contrat> listContrat = gestionContrat.getContratVille(villeClient);
		System.out.println(listContrat);
	}

	public static void infoCompteurModele() {
		System.out.println("Entrer le modele de compteur a chercher\n");
		Scanner scanner = new Scanner(System.in);
		String modele = scanner.nextLine();
		List<Compteur> listCompteur = gestionCompteur.getCompteurModele(modele);
		System.out.println(listCompteur);
	}

	public static void insererNouveauContrat() {
		System.out.println("Entrer le numero du contrat\n");
		Scanner scanner = new Scanner(System.in);
		int idcontrat = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Entrer l'adresse du local\n");
		String adresselocal = scanner.nextLine();

		System.out.println("Entrer la date de debut du contrat(YYYY-MM-JJ)\n");
		String datedebut = scanner.nextLine();
		LocalDate datedebutcontrat = LocalDate.parse(datedebut);
		System.out.println("Entrer l'id du client\n");
		int idClient = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Entrer le max de KwH délivré\n");
		int maxKwh = scanner.nextInt();
		scanner.nextLine();
		Bdd.creerContrat(idcontrat, adresselocal, datedebutcontrat, idClient, maxKwh);
	}
}
