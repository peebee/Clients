package fr.pascal.personne.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Pascal on 08/03/14.
 */
@Entity
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String newligne = System.getProperty("line.separator");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String ligne1;

    @Column
    private String ligne2;

    @Column
    private String ligne3;

    @Column
    private String ligne4;

    @Column
    private String ligne5;

    @Column
    private String ligne6;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adresse)) return false;

        Adresse adresse = (Adresse) o;

        if (id != null ? !id.equals(adresse.id) : adresse.id != null) return false;
        if (ligne1 != null ? !ligne1.equals(adresse.ligne1) : adresse.ligne1 != null) return false;
        if (ligne2 != null ? !ligne2.equals(adresse.ligne2) : adresse.ligne2 != null) return false;
        if (ligne3 != null ? !ligne3.equals(adresse.ligne3) : adresse.ligne3 != null) return false;
        if (ligne4 != null ? !ligne4.equals(adresse.ligne4) : adresse.ligne4 != null) return false;
        if (ligne5 != null ? !ligne5.equals(adresse.ligne5) : adresse.ligne5 != null) return false;
        if (ligne6 != null ? !ligne6.equals(adresse.ligne6) : adresse.ligne6 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ligne1 != null ? ligne1.hashCode() : 0);
        result = 31 * result + (ligne2 != null ? ligne2.hashCode() : 0);
        result = 31 * result + (ligne3 != null ? ligne3.hashCode() : 0);
        result = 31 * result + (ligne4 != null ? ligne4.hashCode() : 0);
        result = 31 * result + (ligne5 != null ? ligne5.hashCode() : 0);
        result = 31 * result + (ligne6 != null ? ligne6.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", ligne1='" + ligne1 + newligne +
                ", ligne2='" + ligne2 + newligne +
                ", ligne3='" + ligne3 + newligne +
                ", ligne4='" + ligne4 + newligne +
                ", ligne5='" + ligne5 + newligne +
                ", ligne6='" + ligne6 + newligne +
                '}';
    }
}
