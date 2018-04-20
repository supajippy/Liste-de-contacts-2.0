import java.io.Serializable;
import java.util.Scanner;

public class Occupation implements Serializable {

    private String Poste="";
    private Entreprise ent=new Entreprise();

    public String getPoste() {
        return Poste;
    }

    public void setPoste(String poste) {
        Poste = poste;
    }

    public void assignerOccupation(){
        Scanner sc=new Scanner(System.in);
        System.out.println("A-t-il une occupation? 1-oui 2-non");
        if(sc.next().equals("1")){
            System.out.println("Quel est son poste?");
            verifierString(sc.next());
            this.setPoste(sc.next());
            System.out.println("Pour quelle entreprise?");
            verifierString(sc.next());
            ent.setNom(sc.next());
            ent.ad.assigneradresse();
        }
        else;
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
}
