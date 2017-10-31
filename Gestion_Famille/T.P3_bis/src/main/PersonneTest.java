package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import personne.Personne;

/**
 * Classe de test de la classe Personne.
 * @author Lucile Torres
 * @version 1.2
 */
public class PersonneTest {
		
	/* Constantes statiques */
	/** Flux de sortie initial. */
	private static final PrintStream original; 
	/** Saut de ligne. */
	private static final String lineSeparator; 
	/** Annee en cours. */
	private static final int anneeCourante; 
	/** Liste non modifiable des annees de naissance utilisees pour les personnes. */
	private static final List<Integer> anneesDeNaissance; 
	/** Liste non modifiable des ages correspondants à la liste des annees de naissance */
	private static final List<Integer> ages; 

	static {
		ArrayList<Integer> liste;
		original = System.out;
		lineSeparator = System.lineSeparator();
		anneeCourante = new GregorianCalendar().get(Calendar.YEAR);
		anneesDeNaissance = Collections.unmodifiableList(Arrays.asList( 1976, 1973, 1996, 1932, 2003,
				1946, 1950, 1969, 1970, 1976, 1990, 1995, anneeCourante+3));
		liste = new ArrayList<Integer>();
		for (int i=0; i<anneesDeNaissance.size(); i++)
			liste.add( Math.max( anneeCourante - anneesDeNaissance.get(i), 0)); 
		ages = Collections.unmodifiableList( liste);
	}
	
	/* Variables d'instance */
	/** Tableau des personnes utilisees pour les tests */
	private Personne [] personnes;
	/** Flux de redirection de la sortie standard. */
	private OutputStream sortie; 
	
	/**
	 * Test de la creation de la 1ere personne. Ce test doit etre extrait 
	 * du contexte commun car il ne peut etre realise qu'une seule fois :
	 * pour la 1ere personne. 
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		String resultatAttendu;
		OutputStream output = new ByteArrayOutputStream();
		System.setOut( new PrintStream(output));		
		new Personne( "Cover", "Harry", 1976, 'M');
		resultatAttendu = "Naissance de la 1ere personne." + lineSeparator;
		assertEquals( resultatAttendu, output.toString() );
		System.setOut( new PrintStream(original));	
	}

	/**
	 * Definition du contexte commun des tests : creation d'un nombre de personnes
	 * egal a la taille de la liste anneesDeNaissance, dont les ages sont ceux de la 
	 * liste ages, puis redirection du flux de sortie. la sortie standard est redirigée 
	 * dans un flux en ecriture de taille variable (java.io.ByteArrayOutputStream) pour 
	 * pouvoir tester automatiquement dans les methodes de test les affichages sur la 
	 * console (realises dans les methodes a tester par les instructions 
	 * System.out.print/println).
	 */
	@Before
	public void setUp() {
		System.setOut( new PrintStream(new ByteArrayOutputStream()));	
		personnes = new Personne [ anneesDeNaissance.size()];
		personnes[0] = new Personne( "Cover", "Harry", anneesDeNaissance.get(0), 'M');
		personnes[1] = new Personne( "Tine", "Clement", anneesDeNaissance.get(1), 'M');
		personnes[2] = new Personne( "Sticket", "Sophie",anneesDeNaissance.get(2), 'F');
		personnes[3] = new Personne( "Selaire", "Jacques", anneesDeNaissance.get(3), 'M');
		personnes[4] = new Personne( "Honette", "Marie", anneesDeNaissance.get(4), 'F');
		personnes[5] = new Personne( "Terieur", "Alex", anneesDeNaissance.get(5), 'M');
		personnes[6] = new Personne( "Homalie", "Anne", anneesDeNaissance.get(6), 'F');
		personnes[8] = new Personne( "Tassion", "Felicie", anneesDeNaissance.get(8), 'F');
		initAvantQuestion4();
		//initAPartirDeQuestion4();
		sortie = new ByteArrayOutputStream();
		System.setOut( new PrintStream(sortie));		
	}
	
	private void initAvantQuestion4() {
		personnes[7] = new Personne( "Terieur", "Alain", anneesDeNaissance.get(7), 'M'); 
		personnes[9] = new Personne( "Tatouille", "Sarah", anneesDeNaissance.get(9), 'F');		
		personnes[10] = new Personne( "Terieur", "Aeropos", anneesDeNaissance.get(10), 'M');		
		personnes[11] = new Personne( "Tatouille", "Lara", anneesDeNaissance.get(11), 'F');
		personnes[12] = new Personne( "Terieur", "Enguerrand", anneesDeNaissance.get(12), 'M');			
	}
	
//	private void initAPartirDeQuestion4() {
//		personnes[7] = new Personne( "Terieur", "Alain", anneesDeNaissance.get(7), 'M', personnes[5], personnes[6]);
//		personnes[9] = new Personne( "Tatouille", "Sarah", anneesDeNaissance.get(9), 'F', null, null);		
//		personnes[10] = new Personne( "Terieur", "Aeropos", anneesDeNaissance.get(10), 'M', personnes[7], personnes[8]);		
//		personnes[11] = new Personne( "Tatouille", "Lara", anneesDeNaissance.get(11), 'F', null, personnes[9]);
//		personnes[12] = new Personne( "Terieur", "Enguerrand", anneesDeNaissance.get(12), 'M', personnes[10], personnes[11]);		
//	}

	/**
	 * Suppression de la redirection du flux de sortie. 
	 */
	@After
	public void tearDown() {
		System.setOut( original);
		personnes[0] = personnes[1] = personnes[2] = personnes[3] = personnes[4] = personnes[5] = personnes[6] = personnes[7] = personnes[8] = personnes[9] = personnes[10] = personnes[11] = personnes[12] = null;
	}
	
	/**
	 * Methode de test de 
	 * {@link personne.Personne#Personne(java.lang.String, java.lang.String, int, char)}.
	 */
	@Test
	public void testPersonneStringStringIntChar() {
		String resultatAttendu;		
		new Personne( "Bon", "Jean", 1976, 'M');
		resultatAttendu = "Naissance de la "+ Personne.getNombreInstances() + "eme personne." + lineSeparator;		
		new Personne( "Javel", "Aude", anneeCourante, 'F');
		resultatAttendu += "Naissance de la " + Personne.getNombreInstances() + "eme personne." + lineSeparator;
		new Personne( "Siclette", "Abby",(anneeCourante + 10), 'F');
		resultatAttendu += "Naissance de la " + Personne.getNombreInstances() + "eme personne." + lineSeparator;
		assertEquals( resultatAttendu, sortie.toString() );
	}
	
	/**
	 * Methode de test de {@link personne.Personne#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals( "M. Harry Cover, ne en 1976, celibataire.", personnes[0].toString());
		assertEquals( "Mlle Sophie Sticket, nee en 1996, celibataire.", personnes[2].toString());
		personnes[0].marier(personnes[2]);
		assertEquals( "M. Harry Cover-Sticket ne Cover, ne en 1976, marie.", personnes[0].toString());
		assertEquals( "Mme Sophie Cover-Sticket nee Sticket, nee en 1996, mariee.", personnes[2].toString());
	}

	/**
	 * Methode de test de {@link personne.Personne#afficheAge(int)}.
	 */
	@Test
	public void testAfficheAgeInt() {
		String resultatAttendu = "";
		personnes[0].afficheAge(1977);
		resultatAttendu += "M. Harry Cover avait 1 an en 1977." + lineSeparator;
		personnes[0].afficheAge(2002);
		resultatAttendu += "M. Harry Cover avait 26 ans en 2002." + lineSeparator;
		personnes[0].afficheAge(anneeCourante);
		resultatAttendu += "M. Harry Cover a " + ages.get(0) + " ans en " + anneeCourante + "." + lineSeparator;
		personnes[0].afficheAge(anneeCourante + 15);
		resultatAttendu += "M. Harry Cover aura " + (ages.get(0) + 15) + " ans en " + (anneeCourante + 15) + "." + lineSeparator;
		personnes[0].afficheAge(1976);
		resultatAttendu += "M. Harry Cover est ne en 1976." + lineSeparator;
		personnes[0].afficheAge(1900);
		resultatAttendu += "M. Harry Cover n'etait pas ne en 1900." + lineSeparator;
		assertEquals( resultatAttendu, sortie.toString());
	}

	/**
	 * Methode de test de {@link personne.Personne#afficheAge()}.
	 */
	@Test
	public void testAfficheAge() {
		String resultatAttendu = "";
		personnes[0].afficheAge();
		resultatAttendu += "M. Harry Cover a " + ages.get(0) 
				+ " ans en " + anneeCourante + "." + lineSeparator;
		personnes[1].afficheAge();
		resultatAttendu += "M. Clement Tine a "+ ages.get(1)
				+ " ans en " + anneeCourante + "." + lineSeparator;
		personnes[12].afficheAge();
		resultatAttendu += "M. Enguerrand Terieur est ne en " 
				+ anneeCourante + "." + lineSeparator;
		assertEquals( resultatAttendu, sortie.toString() );
	}

	/**
	 * Methode de test de {@link personne.Personne#getAge()}.
	 */
	@Test 
	public void testGetAge() {
		assertEquals(ages.get(0).intValue(), personnes[0].getAge());
		assertEquals(ages.get(1).intValue(), personnes[1].getAge());
		assertEquals(ages.get(2).intValue(), personnes[2].getAge());
		assertEquals(ages.get(12).intValue(), personnes[12].getAge());
	}

	/**
	 * Methode de test de {@link personne.Personne#marier(personne.Personne)}.
	 */
	@Test @Ignore
	public void testMarier() {
		personnes[2].marier(personnes[1]);
		assertEquals( "M. Clement Sticket-Tine ne Tine, ne en 1973, marie.", personnes[1].toString());
		assertEquals( "Mme Sophie Sticket-Tine nee Sticket, nee en 1996, mariee.", personnes[2].toString());
		personnes[3].marier(personnes[4]);
		assertEquals( "M. Jacques Honette-Selaire ne Selaire, ne en 1932, marie.", personnes[3].toString());
		assertEquals( "Mme Marie Honette-Selaire nee Honette, nee en 2003, mariee.", personnes[4].toString());
		personnes[6].marier(personnes[5]);
		assertEquals( "M. Alex Homalie-Terieur ne Terieur, ne en 1946, marie.", personnes[5].toString());
		assertEquals( "Mme Anne Homalie-Terieur nee Homalie, nee en 1950, mariee.", personnes[6].toString());
		personnes[0].marier(personnes[6]);
		assertEquals( "M. Harry Cover, ne en 1976, celibataire.", personnes[0].toString());
		assertEquals( "Mme Anne Homalie-Terieur nee Homalie, nee en 1950, mariee.", personnes[6].toString());
		personnes[7].marier(personnes[0]);
		assertEquals( "M. Harry Cover-Terieur ne Cover, ne en 1976, marie.", personnes[0].toString());
		assertEquals( "M. Alain Cover-Terieur ne Terieur, ne en 1969, marie.", personnes[7].toString());
	}
	
	/**
	 * Methode de test de {@link personne.Personne#compareTo(personne.Personne)}.
	 */
	@Test @Ignore
	public void testCompareToPersonne() {
		assertTrue(personnes[0].compareTo(personnes[1]) < 0);
		assertTrue(personnes[1].compareTo(personnes[0]) > 0);
		assertTrue(personnes[0].compareTo(personnes[9]) == 0);
		assertTrue(personnes[9].compareTo(personnes[0]) == 0);
		assertTrue(personnes[4].compareTo(personnes[0]) < 0);
		assertTrue(personnes[0].compareTo(personnes[4]) > 0);
	}

	/**
	 * Methode de test de 
	 * {@link personne.Personne#compareTo(personne.Personne, personne.Personne)}.
	 */
	@Test @Ignore
	public void testCompareToPersonnePersonne() {
		assertTrue(Personne.compareTo(personnes[0],personnes[1]) < 0);
		assertTrue(Personne.compareTo(personnes[1],personnes[0]) > 0);
		assertTrue(Personne.compareTo(personnes[0],personnes[9]) == 0);
		assertTrue(Personne.compareTo(personnes[9],personnes[0]) == 0);
		assertTrue(Personne.compareTo(personnes[4],personnes[0]) < 0);
		assertTrue(Personne.compareTo(personnes[0],personnes[4]) > 0);
	}

	/**
	 * Methode de test de {@link personne.Personne#estAncetre(personne.Personne)}.
	 */
	@Test @Ignore
	public void testEstAncetre() {
		assertTrue(personnes[5].estAncetre(personnes[7]));
		assertTrue(personnes[5].estAncetre(personnes[10]));
		assertTrue(personnes[5].estAncetre(personnes[12]));
		assertTrue(personnes[6].estAncetre(personnes[7]));
		assertTrue(personnes[6].estAncetre(personnes[10]));
		assertTrue(personnes[6].estAncetre(personnes[12]));
		assertTrue(personnes[8].estAncetre(personnes[10]));
		assertTrue(personnes[8].estAncetre(personnes[12]));
		assertTrue(personnes[9].estAncetre(personnes[12]));
		assertTrue(personnes[11].estAncetre(personnes[12]));
		assertFalse(personnes[7].estAncetre(personnes[5]));
		assertFalse(personnes[9].estAncetre(personnes[10]));
		assertFalse(personnes[8].estAncetre(personnes[8]));
	}

	/**
	 * Methode de test de {@link personne.Personne#afficheAieux()}.
	 */
	@Test @Ignore
	public void testAfficheAieux() {
		personnes[7].marier(personnes[8]);
		personnes[5].marier(personnes[6]);
		String arbreGenealogique = "Enguerrand Terieur\n";
		arbreGenealogique += "|___de pere Aeropos Terieur\n";
		arbreGenealogique += "\t|___de pere Alain Terieur epoux de Felicie Tassion\n";
		arbreGenealogique += "\t\t|___de pere Alex Terieur epoux de Anne Homalie\n";
		arbreGenealogique += "\t\t|___de mere Anne Homalie epouse de Alex Terieur\n";
		arbreGenealogique += "\t|___de mere Felicie Tassion epouse de Alain Terieur\n";
		arbreGenealogique += "|___de mere Lara Tatouille\n";
		arbreGenealogique += "\t|___de mere Sarah Tatouille\n";
		personnes[12].afficheAieux();
		assertEquals(arbreGenealogique, sortie.toString());
	}

	/**
	 * Methode de test de {@link personne.Personne#equals(Object)}.
	 */
	@Test @Ignore
	public void testEquals() {
		int annee = anneesDeNaissance.get(0);
		assertFalse(personnes[0].equals(personnes[1]));
		assertTrue(personnes[0].equals(personnes[0]));
		Personne homonymeDePersonne0 = new Personne( "Cover", "Harry", annee, 'M');
		assertTrue(personnes[0].equals(homonymeDePersonne0));
		assertFalse(personnes[0].equals(new Personne( "Cover", "Harry", annee, 'F')));
		assertFalse(personnes[0].equals(new Personne( "Cover", "Henri", annee, 'M')));
		assertFalse(personnes[0].equals(new Personne( "Covert", "Harry", annee, 'M')));
		assertFalse(personnes[0].equals(new Personne( "Cover", "Harry", annee-1, 'M')));
		personnes[0].marier(personnes[6]);
		assertFalse(personnes[0].equals(homonymeDePersonne0));
		homonymeDePersonne0.marier(personnes[2]);
		assertFalse(personnes[0].equals(homonymeDePersonne0));
	}
}
