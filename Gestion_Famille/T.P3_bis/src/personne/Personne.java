package personne;

import java.util.Calendar;

/**
 * @author BourjijKiller
 * @version 1.1
 */

public class Personne
{
	private static String status = "célibataire";
	private String nom;
	private String prenom;
	private int ddn;
	private char civilite;
	private static int countInstance;
	private int curYear = Calendar.getInstance().get(Calendar.YEAR);
	private int age;
	private String stringCivilite;
	private String verbeNaitre;
	private String motAns;
	private Personne conjoint;
	private String nomMarier;
	private Personne pere;
	private Personne mere;
	
	/** Constructeur de la classe */
	public Personne(String nom, String prenom, int ddn, char civilite)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.ddn = ddn;
		this.civilite = civilite;
		this.countInstance++;
		System.out.println("Naissance de la " + this.getNombreInstances() + (this.getNombreInstances() > 1 ? "ème" : "ere") + " personne.");
	}
	
	/** Deuxième constructeur de la classe */
	public Personne(String nom, String prenom, int ddn, char civilite, Personne pere, Personne mere)
	{
		this(nom, prenom, ddn, civilite);
		this.pere = pere;
		this.mere = mere;
	}
	
	/** Méthode permettant de récupérer le nombre d'instance de la classe */
	public static int getNombreInstances()
	{
		return Personne.countInstance;
	}
	
	/** Méthode récupérant le nom courant */
	public String getNom()
	{
		return this.nom;
	}
	
	/** Méthode récupérant le nom de mariage */
	public String getNomMarier()
	{
		return this.nomMarier;
	}
	
	/** Méthode récupérant le prénom courant */
	public String getPrenom()
	{
		return this.prenom;
	}
	
	/** Méthode récupérant la date de naissance courante */
	public int getDdn()
	{
		return this.ddn;
	}
	
	/** Méthode récupérant la civilité courante */
	public char getCivilite()
	{
		return this.civilite;
	}
	
	/** Méthode permettant de conjuguer correctement le verbe naétre en fonction du sexe */
	public String getVerbeNaitre()
	{
		return(this.getCivilite() == 'M' ? "né" : "née");
	}
	
	/** Méthode permettant de récupérer le pére */
	public Personne getPere()
	{
		return this.pere;
	}
	
	/** Méthode permettant de récupérer la mére */
	public Personne getMere()
	{
		return this.mere;
	}
	
	/** Méthode permettant de changer la civilité en cohérence */
	public String changementCivilite()
	{
		if(this.getCivilite() == 'M')
			stringCivilite = "M.";
		else {
			if(status == "célibataire")
				stringCivilite = "Mlle.";
			else
				stringCivilite = "Mme.";
		}
		
		return stringCivilite;
	}
	
	/** Méthode permettant de calculer l'ége d'une personne en fonction de l'année courante */
	public int getAge()
	{
		age = curYear - this.ddn;
		
		return age;
	}
	
	/** Méthode permettant de donner une phrase en fonction de l'ége de la personne */
	public String afficheAge(int annee)
	{
		String verbeAvoir;
		int ageEnFonctionDeAnnee;
		String phraseFinal;
		
		if(annee < curYear)
			verbeAvoir = "avait";
		else if(annee > curYear)
			verbeAvoir = "aura";
		else
			verbeAvoir = "a";
		
		motAns = (this.getAge() == 1 ? "an" : "ans");
		
		if(annee > curYear) {
			ageEnFonctionDeAnnee = annee - curYear;
			ageEnFonctionDeAnnee = ageEnFonctionDeAnnee + getAge();
		}
		else
			ageEnFonctionDeAnnee = annee - this.ddn;
		
		if(annee < this.getDdn())
			phraseFinal = this.changementCivilite() + " " + this.getNom() + " " + this.getPrenom() + " n'était pas " + this.getVerbeNaitre() + " en " + annee;
		else if(annee > this.getDdn())
			phraseFinal = this.changementCivilite() + " " + this.getNom() + " " + this.getPrenom() + " " + verbeAvoir + " " + ageEnFonctionDeAnnee + " " + motAns + " en " + annee;
		else
			phraseFinal = this.changementCivilite() + " " + this.getNom() + " " + this.getPrenom() + " est " + this.getVerbeNaitre() + " en " + annee;
		
		return phraseFinal;
	}
	
	/** Méthode permettant d'afficher l'ége de la personne en fonction de l'année courante */
	public String afficheAge()
	{
		return(this.changementCivilite() + " " + this.getNom() + " " + this.getPrenom() + " a " + this.getAge() + " " + (this.getAge() == 1 ? "an" : "ans") + " en " + curYear);
	}
	
	/** Méthode permettant de marier deux personnes */
	public void marier(Personne p)
	{
		if(p.status == "célibataire" && this.status == "célibataire") {
			System.out.println("Mariage de " + p.getNom() + " " + p.getPrenom() + " avec " + this.getNom() + " " + this.getPrenom());
			status = "marier";
			this.nomMarier = this.getNom() + "-" + p.getNom();
			p.nomMarier = p.getNom() + "-" + this.nom;
		}
		else
			System.out.println("Mariage impossible ! Une des deux personnes est déjé marié(e)");
	}
	
	/** Méthode permettant de comparer deux personnes par leur âge */
	public int compareTo(Personne p)
	{
		int retour;
		if(this.getAge() == p.getAge())
			retour = 0;
		else if(this.getAge() < p.getAge())
			retour = -1;
		else
			retour = 1;

		return retour;
	}
	
	/** Méthode permettant de comparer deux personnes par leur âge */
	public static int compareTo(Personne p1, Personne p2)
	{
		int diff;
		System.out.println(p1.getNom() + " " + p1.getPrenom() + " a un âge de " + p1.getAge());
		System.out.println(p2.getNom() + " " + p2.getPrenom() + " a un âge de " + p2.getAge());

		if(Math.max(p1.getAge(), p2.getAge()) == p1.getAge())
			diff = p1.getAge() - p2.getAge();
		else
			diff = p2.getAge() - p1.getAge();

		System.out.println("Nombre(s) d'année(s) de différence : ");
		return diff;
	}
	
	/** Méthode permettant de tester si la personne courante est ancêtre de la personne en paramétre */
	public boolean estAncetre(Personne p)
	{
		if(p == null)
			return false;
		else {
			if(p.getPere() != null && p.getPere().equals(this) || p.getMere() != null && p.getMere().equals(this))
				return true;
			else
				return this.estAncetre(p.getPere()) || this.estAncetre(p.getMere());
		}
	}
	
	private void afficheAieux(Personne p, int nbTab)
	{
		nbTab++;
		System.out.print("\t");
		if(p.getPere() != null ) {
			for(int i = 0; i < nbTab; i++)
				System.out.print("\t");
			System.out.print("|");
			System.out.println(" _____ de père " + p.getPere().nom + " " + p.getPere().prenom);
			afficheAieux(p.getPere(), nbTab);
		}
		
		if(p.getMere() != null) {
			for(int i = 0; i < nbTab; i++)
				System.out.print("\t");
			System.out.print("|");
			System.out.println(" _____ de mère " + p.getMere().nom + " " + p.getMere().prenom);
			afficheAieux(p.getPere(), nbTab);
		}
	}
	
	/** Méthode permettant de construire l'arbre généalogique d'une personne */
	public void afficheAieux()
	{
		if(this.getMere() == null && this.getMere() == null) {
			System.out.println(this.nom + " " + this.prenom + " n'as pas d'arbre généalogique");
		}
		else {
			System.out.println("Arbre généalogique de " + this.nom + " " + this.prenom);
			System.out.println("|");
			System.out.println(" _____ de père " + this.getPere().nom + " " + this.getPere().prenom);
			afficheAieux(this.getPere(), 0);
			System.out.println("|");
			System.out.println(" _____ de mère " + this.getMere().nom + " " + this.getMere().prenom);
			afficheAieux(this.getMere(), 0);
		}
	}
	
	public boolean equals(Personne o)
	{
		if(this.nom == o.nom && this.prenom == o.prenom && this.ddn == o.ddn && this.civilite == o.civilite)
			return true;
		else
			return false;
	}
	
	
	/** Méthode permettant de donner une phrase d'informations de la personne */
	public String toString()
	{
		if(status == "célibataire")
			return(this.changementCivilite() + " " + this.getNom() + " " + this.getPrenom() + " " + this.getVerbeNaitre() + " en " + this.getDdn() + ", " + status);
		else
			return(this.changementCivilite() + " " + this.getNomMarier() + " " + this.getPrenom() + " " + this.getVerbeNaitre() + " " + this.getNom() + " en " + this.getDdn() + " , " + status);
	}
	
	/** Méthode de test */
	public static void main(String[] args)
	{
		Personne pp1 = new Personne("Toyota", "Yaris", 1200, 'M');
		Personne pp2 = new Personne("Valentin" , "Manger", 1200, 'F');
		Personne pp3 = new Personne("Renault", "Clio", 900, 'M');
		Personne pp4 = new Personne("Trou", "Duc", 901, 'F');
		Personne p1 = new Personne("Harry", "Cover", 1976, 'M', pp1, pp2);
		Personne p2 = new Personne("Giselle", "Girafe", 1905, 'F', pp3, pp4);
		Personne fils = new Personne("Veau" , "Bg", 2014, 'M', p1, p2);
		Personne ami = new Personne("Chat", "Beauté", 2010, 'M');
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p1.afficheAge(2050));
		System.out.println(p2.afficheAge(1900));
		System.out.println(p1.afficheAge());
		System.out.println(p2.afficheAge());
		p1.marier(p2);
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(compareTo(p1, p2));
		System.out.println("La personne fils est-il ancêtre de p1 ? : " + fils.estAncetre(p1));
		System.out.println("La personne ami est-il ancêtre de p1 ? : " + ami.estAncetre(p1));
		System.out.println("La personne p1 est-il ancêtre de fils ? " + p1.estAncetre(fils));
		fils.afficheAieux();
		System.out.println("\n");
		System.out.println(fils.equals(ami));
		System.out.println(fils.equals(fils));
	}
	
}