import java.awt.*;
import java.io.Serializable;
import java.util.Scanner;

public class Adresse implements Serializable {

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getRue() {
        return Rue;
    }

    public void setRue(String rue) {
        Rue = rue;
    }

    public String getApp() {
        return App;
    }

    public void setApp(String app) {
        App = app;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public String getProv() {
        return Prov;
    }

    public void setProv(String prov) {
        Prov = prov;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String pays) {
        Pays = pays;
    }

    private String Numero="";
    private String Rue="";
    private String App="";
    private String Ville="";
    private String Prov="";
    private String Pays="";

    public void assigneradresse(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Quel est son numero civique?");
        verifierchiffre(sc.next());
        this.setNumero(sc.next());
        System.out.println("Quel est son nom de rue?");
        verifierString(sc.next());
        this.setRue(sc.next());
        System.out.println("A-t-il un numero d'appartement? 1-oui 2-non");
        if(sc.next().equals("1"))
        {
            System.out.println("Lequel?");
            verifierchiffre(sc.next());
            this.setApp(sc.next());
        }
        else{};
        System.out.println("Quelle est sa ville?");
        verifierString(sc.next());
        this.setVille(sc.next());
        System.out.println("Quelle est sa province?");
        verifierString(sc.next());
        this.setProv(sc.next());
        System.out.println("Quel est son pays?");
        verifierString(sc.next());
        this.setPays(sc.next());
    }
    public static void verifierString(String sc){
        int diviseur=1;
        for(int i=0;i<sc.length();i++) {
            if (sc.charAt(i) < 65 || sc.charAt(i) > 122) {
                diviseur = 0;
            }
        }
        try{
            int exception = 1/diviseur;
        }
        catch (ArithmeticException e){
            System.out.println("Vous avez entré un mauvais caractère, veuillez recommencer");
        }
    }
    public static void verifierchiffre(String sc){
        int diviseur=2;
        for(int i=0;i<sc.length();i++) {
            if (sc.charAt(i) < 48 || sc.charAt(i) > 57) {
                diviseur = 0;
            }
        }
        try{
            int exception = 1/diviseur;
        }
        catch (ArithmeticException e){
            System.out.println("Vous avez entré un mauvais chiffre, veuillez recommencer");
            diviseur=0;
        }
    }

}

