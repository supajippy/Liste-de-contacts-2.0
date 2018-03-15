import java.util.Scanner;

public class Occupation {

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
            this.setPoste(sc.next());
            System.out.println("Pour quelle entreprise?");
            ent.setNom(sc.next());
            ent.ad.assigneradresse();
        }
        else;
    }
}
