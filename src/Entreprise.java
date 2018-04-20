import java.io.Serializable;

public class Entreprise implements Serializable {
    private String Nom="";

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getNom() {
        return Nom;
    }
    Adresse ad= new Adresse();


}
