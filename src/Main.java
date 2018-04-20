import java.io.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {


        Queue liste = new LinkedList();
        Map<Integer, Contacts> conts = new HashMap<Integer, Contacts>();

        String choix = "";
        boolean continuer = false;
        Exception ex = new Exception();

        System.out.println("Voulez-vous télécharger une liste existante? \t1-oui\t2-non ");
        String choix12 = sc.next();

        if (choix12.equals("1")) {
            try{
                ObjectInput entré = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream("save.dat"))) {
                };
                conts  = (HashMap<Integer, Contacts>) entré.readObject();
                entré.close();


            }   catch (IOException e){
                e.printStackTrace();
            }
            catch (ClassNotFoundException ya){
                ya.printStackTrace();
            }


        }
        while(continuer ==false)

    {

        System.out.println("Que voulez-vous faire?\n" + "1-Ajouter un contact\n2-Modifier un contact" +
                "\n3-Afficher un contact\n4-Supprimer un contact\n5-Liste de Rappels\n6-Quitter");
        choix = sc.next();
        switch (choix) {
            case ("1"):
                Contacts nouveau = new Contacts();
                assignernomprenom(nouveau);
                conts.put(Contacts.getConts(), nouveau);
                nouveau.ad1.assigneradresse();
                nouveau.oc.assignerOccupation();
                nouveau.setTelephones();
                break;

            case ("2"):
                modifierContact(conts);
                break;
            case ("3"):
                afficherContact(conts);
                break;
            case ("4"):
                supprimerContact(conts);
                break;
            case ("5"):
                listeRappels(conts, liste);
                break;
            case ("6"):
                continuer = true;
                break;
        }
    }
        try{
            ObjectOutputStream sauvegarde = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("save.dat")));
            sauvegarde.writeObject(conts);
            System.out.println("Sauvegarde effectuée");
            sauvegarde.close();
        }   catch (IOException e){
            e.printStackTrace();
        }

}

    public static void afficherContact(Map conts) {

        System.out.println("Lequel? Veuilez entrer son numéro d'entrée");
        Contacts afficher = (Contacts) conts.get(sc.nextInt());
        if (afficher != null) {
            System.out.println("Vous avez choisi : " + afficher.getNom());
            System.out.println("Prénom : " + afficher.getPrenom());
            System.out.println("Nom : " + afficher.getNom());
            System.out.println("ADRESSE\nNuméro Civique : " + afficher.ad1.getNumero());
            System.out.println("Rue : " + afficher.ad1.getRue());
            System.out.println("App. : " + afficher.ad1.getApp());
            System.out.println("Ville : " + afficher.ad1.getVille());
            System.out.println("Province : " + afficher.ad1.getProv());
            System.out.println("Pays : " + afficher.ad1.getPays());
            System.out.println("OCCUPATION : \nPoste : " + afficher.oc.getPoste());
            System.out.println("ENTREPRISE : \nNom : " + afficher.oc.getPoste());
            System.out.println("ADRESSE\nNuméro Civique : " + afficher.ad1.getNumero());
            System.out.println("Rue : " + afficher.ad1.getRue());
            System.out.println("App. : " + afficher.ad1.getApp());
            System.out.println("Ville : " + afficher.ad1.getVille());
            System.out.println("Province : " + afficher.ad1.getProv());
            System.out.println("Pays : " + afficher.ad1.getPays());
            System.out.println("Telephones");
            for (Telephone telephone : afficher.numerosdeTelephones) {
                System.out.println(telephone.getNom() + "\t" + telephone.getNumero());
            }
        } else {
            System.out.println("Liste vide");
        }
    }

    public static void modifierContact(Map conts) {
        {

            System.out.println("Lequel? Veuillez entrer son numéro d'entrée");
            Contacts amodifier = (Contacts) conts.get(sc.nextInt());
            if (conts.isEmpty()) {
            } else {
                System.out.println("Vous avez choisi : " + amodifier.getNom());
                assignernomprenom(amodifier);
                amodifier.ad1.assigneradresse();
                amodifier.oc.assignerOccupation();
                amodifier.setTelephones();
            }
        }

    }

    public static void assignernomprenom(Contacts nouveau) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est son prenom?");
        verifierString(sc.next());
        nouveau.setPrenom(sc.next());
        System.out.println("Quel est son nom?");
        verifierString(sc.next());
        nouveau.setNom(sc.next());
        nouveau.setNumeroentree(Contacts.conts);
        System.out.println("Son numéro d'entrée est : " + nouveau.getNumeroentree());
    }

    public static void supprimerContact(Map conts) {
        System.out.println("Lequel? Veuillez entrer son numéro d'entrée");
        Contacts asupprimer = (Contacts) conts.get(sc.nextInt());
        conts.remove(asupprimer);
    }

    public static void listeRappels(Map conts, Queue liste) {
        boolean termine = false;
        while (termine == false) {
            System.out.println("Que voulez-vous faire? \n1-Entrer un contact à rappeler\n2-Rappeler contacts\n" +
                    "3-Quitter");
            int choix = sc.nextInt();

            if (choix == 1 && conts.size() > 0) {
                System.out.println("Lequel? Entrez son numéro d'entrée.");
                Contacts numeroaRappeler = (Contacts) conts.get(sc.nextInt());

                System.out.println("Vous avez choisi : " + numeroaRappeler.getNom());
                liste.add(numeroaRappeler);

            } else if (choix == 1 && conts.size() == 0) {
                System.out.println("Veuillez entrer un contact valable s.v.p.");
            } else if (choix == 2 && conts.size() > 0) {
                Contacts prioritaire = (Contacts) liste.peek();
                System.out.println("Voici le contact prioritaire à rappeler : " + prioritaire.toString());
                System.out.println("Voulez-vous le rappeler? 1-oui 2-non");
                choix = sc.nextInt();
                if (choix == 1) {
                    liste.remove();
                }
            } else if (choix == 2 && conts.size() == 0) {
                System.out.println("Impossible, il n'y a aucun contact disponible");
            } else {
                termine = true;
            }
        }
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

































