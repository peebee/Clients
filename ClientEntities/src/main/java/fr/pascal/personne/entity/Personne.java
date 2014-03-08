package fr.pascal.personne.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Personne implements Serializable,Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1532311120726607298L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 30)
	private String nom_naissance;

	@Column(nullable = false, length = 30)
	private String nom_usage;

	@Column(nullable = false, length = 30)
	private String prenom;

	@Temporal(TemporalType.DATE)
	private Date dt_naissance;

	@Temporal(TemporalType.DATE)
	private Date dt_deces;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Enumerated(EnumType.STRING)
	private Genre genre;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		final Personne other = (Personne) obj;

		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 7;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_naissance() {
		return nom_naissance;
	}

	public void setNom_naissance(String nom_naissance) {
		this.nom_naissance = nom_naissance;
	}

	public String getNom_usage() {
		return nom_usage;
	}

	public void setNom_usage(String nom_usage) {
		this.nom_usage = nom_usage;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDt_naissance() {
		return dt_naissance;
	}

	public void setDt_naissance(Date dt_naissance) {
		this.dt_naissance = dt_naissance;
	}

	public Date getDt_deces() {
		return dt_deces;
	}

	public void setDt_deces(Date dt_deces) {
		this.dt_deces = dt_deces;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		String Newligne=System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass()).append("-").append(Newligne);
		sb.append("  id = ").append(id).append(Newligne);
		sb.append("  nom d'usage = ").append(nom_usage).append(Newligne);
		sb.append("  nom de naissance = ").append(nom_naissance).append(Newligne);
		sb.append("  prénom=").append(prenom).append(Newligne);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		sb.append("  date de naissance = ").append(sdf.format(dt_naissance)).append(Newligne);
		sb.append("  date de décés = ").append((dt_deces!=null) ? sdf.format(dt_deces):"NULL");
		return sb.toString();
	}

}
