package cnam.teleconsult.modele.bean;
// Generated 12 ao�t 2016 14:40:39 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Dmpcadresse generated by hbm2java
 */
@Entity
@Table(name = "dmpcadresse", catalog = "teleconsult")
public class Dmpcadresse implements java.io.Serializable {

	private Integer adresseId;
	private String adresseLigneadresse;
	private String adresseVille;
	private String adresseCodepostal;
	private String adressePays;
	private Set<Dmpcpatient> dmpcpatients = new HashSet<Dmpcpatient>(0);
	private Set<Dmpcstructuresante> dmpcstructuresantes = new HashSet<Dmpcstructuresante>(0);

	public Dmpcadresse() {
	}

	public Dmpcadresse(String adresseLigneadresse, String adresseVille, String adresseCodepostal, String adressePays) {
		this.adresseLigneadresse = adresseLigneadresse;
		this.adresseVille = adresseVille;
		this.adresseCodepostal = adresseCodepostal;
		this.adressePays = adressePays;
	}

	public Dmpcadresse(String adresseLigneadresse, String adresseVille, String adresseCodepostal, String adressePays,
			Set<Dmpcpatient> dmpcpatients, Set<Dmpcstructuresante> dmpcstructuresantes) {
		this.adresseLigneadresse = adresseLigneadresse;
		this.adresseVille = adresseVille;
		this.adresseCodepostal = adresseCodepostal;
		this.adressePays = adressePays;
		this.dmpcpatients = dmpcpatients;
		this.dmpcstructuresantes = dmpcstructuresantes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ADRESSE_ID", unique = true, nullable = false)
	public Integer getAdresseId() {
		return this.adresseId;
	}

	public void setAdresseId(Integer adresseId) {
		this.adresseId = adresseId;
	}

	@Column(name = "ADRESSE_LIGNEADRESSE", nullable = false, length = 200)
	public String getAdresseLigneadresse() {
		return this.adresseLigneadresse;
	}

	public void setAdresseLigneadresse(String adresseLigneadresse) {
		this.adresseLigneadresse = adresseLigneadresse;
	}

	@Column(name = "ADRESSE_VILLE", nullable = false, length = 20)
	public String getAdresseVille() {
		return this.adresseVille;
	}

	public void setAdresseVille(String adresseVille) {
		this.adresseVille = adresseVille;
	}

	@Column(name = "ADRESSE_CODEPOSTAL", nullable = false, length = 20)
	public String getAdresseCodepostal() {
		return this.adresseCodepostal;
	}

	public void setAdresseCodepostal(String adresseCodepostal) {
		this.adresseCodepostal = adresseCodepostal;
	}

	@Column(name = "ADRESSE_PAYS", nullable = false, length = 20)
	public String getAdressePays() {
		return this.adressePays;
	}

	public void setAdressePays(String adressePays) {
		this.adressePays = adressePays;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dmpcadresse")
	public Set<Dmpcpatient> getDmpcpatients() {
		return this.dmpcpatients;
	}

	public void setDmpcpatients(Set<Dmpcpatient> dmpcpatients) {
		this.dmpcpatients = dmpcpatients;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dmpcadresse")
	public Set<Dmpcstructuresante> getDmpcstructuresantes() {
		return this.dmpcstructuresantes;
	}

	public void setDmpcstructuresantes(Set<Dmpcstructuresante> dmpcstructuresantes) {
		this.dmpcstructuresantes = dmpcstructuresantes;
	}

}
