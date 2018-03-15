import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    private String Prenom="";
    private String Nom="";
     static int conts=0;
    private int numeroentree;

    public int getNumeroentree() {
        return numeroentree;
    }

    public void setNumeroentree(int numeroentree) {
        this.numeroentree = numeroentree;
    }

    public static int getConts() {
        return conts;
    }

    public static void setConts(int conts) {
        Contacts.conts = conts;
    }

    List<Telephone> numerosdeTelephones=new ArrayList<>();


    public Contacts() {conts++;}

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {

        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    Adresse ad1=new Adresse();
    Occupation oc=new Occupation();
    Entreprise en=new Entreprise();

    public void setTelephones() {
        Scanner sc = new Scanner(System.in);
        boolean continuer = true;
        int i = 0;
        while (continuer == true) {

            System.out.println("Voulez-vous entrer un numéro de téléphone? 1-oui 2-non");
            String choix = sc.next();
            if (choix.equals("1")) {
                Telephone tel=new Telephone();
                this.numerosdeTelephones.add(tel);
                System.out.println("À quoi sert ce numero? Maison,Travail,Mobile,...");
                this.numerosdeTelephones.get(i).setNom(sc.next());
                System.out.println(" Veuillez entrer le numéro");
                this.numerosdeTelephones.get(i).setNumero(sc.next());
                i++;


            } else {
                System.out.println("Votre contact a été entré avec succès.");
                continuer = false;
            }
        }
    }
    public String toString(){
       return this.getNom();
    }

}

