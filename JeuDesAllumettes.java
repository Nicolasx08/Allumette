import java.util.Scanner;

/**
 * Created by PagNi1731620 on 2018-01-15.
 */
public class JeuDesAllumettes {
    public static void main(String[] args) {

        int decision[]=new int[150];
        String nom1;
        String nom2;
        int choix1=0;
        int choix2=0;
        int nbeChoix=0;
        char nouvelleGame;
        char choixNbePersonne;
        boolean partieFini=false;
        int nbeAllumettes=0;
        int n=0;
        char rematch;
        boolean autrePartie=false;
        int j=0;
        boolean solitaire=false;
        Scanner sc = new Scanner(System.in);

            System.out.println("Voulez-vous jouer seul?(o/n)");
            choixNbePersonne=sc.next().charAt(0);
            if (choixNbePersonne=='n'){
                solitaire=false;
            }
            else if (choixNbePersonne=='o'){
                solitaire=true;
            }
            else {
                System.out.println("Entrez un réponse valide");
            }

            if (solitaire==false){
                    System.out.println("Bonjour, quelles sont vos noms?");
                    System.out.println("Joueur1:");

                    nom1=sc.next();
                    System.out.println("Joueur2:");
                    nom2=sc.next();
                    while (partieFini==false){
                        //réinitialise la variable si il joue un autre fois
                        autrePartie=false;
                        System.out.println("Bonjour "+ nom1+" et "+ nom2+" votre but est de ne pas enlever la dernière allumette.");
                        nbeAllumettes= (int)(Math.random()*(81)+20);
                        System.out.println("Il y a "+nbeAllumettes+" allumettes");
                        while (nbeAllumettes>0){
                            for (int i=0;i<2;i++){
                                if (i==0){
                                    if (nbeAllumettes>0){
                                        System.out.println(nom1+ ", combien voulez-vous enlever d'allumette(s)?(1-3)");
                                        choix1=sc.nextInt();
                                        decision[j]=choix1;
                                        nbeChoix++;
                                        j++;
                                        if (choix1<1 || choix1>3){
                                            System.out.println("Entrez un chiffre entre 1 et 3");
                                            i--;
                                        }
                                        else {
                                            nbeAllumettes -= choix1;
                                            // n-> pour m'aider à trouver le gagnant
                                            n = 1;
                                        }
                                    }
                                }
                                else {
                                    if (nbeAllumettes>0){
                                        System.out.println(nom2+ ", combien voulez-vous enlever d'allumette(s)?(1-3)");
                                        choix2=sc.nextInt();
                                        decision[j]=choix2;
                                        nbeChoix++;
                                        j++;
                                        if (choix2<1 || choix2>3){
                                            System.out.println("Entrez un chiffre entre 1 et 3");
                                            i--;
                                        }
                                        else {
                                            nbeAllumettes-=choix2;
                                            n=2;
                                        }
                                    }
                                }
                                System.out.println("Il reste "+ nbeAllumettes);

                            }
                        }
                        if (n==1){
                            System.out.println(nom2+" a gagné la partie!");
                        }
                        else if (n==2){
                            System.out.println(nom1+" a gagné la partie!");
                        }
                        System.out.println(nom1+ "a joué:");
                        for (j=0;j<nbeChoix;j+=2){
                            System.out.print(decision[j]+",");
                        }
                        System.out.println();
                        System.out.println(nom2+" a joué:");
                        for (j=1;j<nbeChoix;j+=2) {
                            System.out.print(decision[j]+",");
                        }

                        System.out.println();
                        while (autrePartie==false) {
                            System.out.println("Voulez-vous rejouer?(o/n)");
                            rematch = sc.next().charAt(0);
                            if (rematch == 'o') {
                                partieFini = false;
                                autrePartie=true;
                            } else if (rematch == 'n') {
                                partieFini = true;
                                autrePartie=true;
                            } else {
                                System.out.println("Entrez une réponse valide.");
                                autrePartie=false;
                            }
                        }
                    }
            }
            else {

            }

        System.out.println("Merci d'avoir joué au jeu des allumettes, bonne journée!");
    }
}
