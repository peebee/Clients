package fr.pascal.personne.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Personne implements Serializable {

    private static final long serialVersionUID = 1532311120726607298L;
    private static final String newligne = System.getProperty("line.separator");
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private String dtdeces ;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    @Column(nullable = false)
    private int version;

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

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToMany
    @JoinTable(name = "Personne_Adresse",
            joinColumns = @JoinColumn(name = "personne_Id"),
            inverseJoinColumns = @JoinColumn(name = "adresse_Id"))
    private Collection<Adresse> adresses ;

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

    public Collection<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(Collection<Adresse> adresses) {
        this.adresses = adresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personne)) return false;

        Personne personne = (Personne) o;

        if (dt_deces != null ? !dt_deces.equals(personne.dt_deces) : personne.dt_deces != null) return false;
        if (dt_naissance != null ? !dt_naissance.equals(personne.dt_naissance) : personne.dt_naissance != null)
            return false;
        if (genre != personne.genre) return false;
        if (id != null ? !id.equals(personne.id) : personne.id != null) return false;
        if (nom_naissance != null ? !nom_naissance.equals(personne.nom_naissance) : personne.nom_naissance != null)
            return false;
        if (nom_usage != null ? !nom_usage.equals(personne.nom_usage) : personne.nom_usage != null) return false;
        if (prenom != null ? !prenom.equals(personne.prenom) : personne.prenom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nom_naissance != null ? nom_naissance.hashCode() : 0);
        result = 31 * result + (nom_usage != null ? nom_usage.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (dt_naissance != null ? dt_naissance.hashCode() : 0);
        result = 31 * result + (dt_deces != null ? dt_deces.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        dtdeces = (dt_deces!=null)?sdf.format(dt_deces):null;
        String ret =  "Personne{" +
                "id=" + id + newligne +
                ", nom_naissance='" + nom_naissance + newligne +
                ", nom_usage='" + nom_usage + newligne +
                ", prénom='" + prenom + newligne +
                ", dt_naissance=" + sdf.format(dt_naissance) + newligne +
                ", dt_décès=" + dtdeces + newligne +
                ", genre=" + genre + newligne;
        if (adresses!=null){
            for (Adresse adresse : adresses){
                ret = ret + adresse.toString();
            }
        } else {
            ret = ret + null;
        }

        ret = ret + '}';

        return ret;
    }
}
