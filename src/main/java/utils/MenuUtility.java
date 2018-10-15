package utils;

public interface MenuUtility {

    //******************************************************************************************************************
    //                                                PRINTING
    //******************************************************************************************************************

    default void printGameMenu() {
        System.out.println("\n******************\n" +
                "** ECRAN DE JEU **\n" +
                "******************\n");
        System.out.println(printIntroduction());
    }

    default String printIntroduction() {
        return "Bienvenue dans le manoir Shikabuki, détective Kovac.\n" +
                "Votre objectif est de mener à bien l'enquête sur le meurtre d'un très grand dignitaire Maths." +
                "\nCe dernier a eu sa stack détruite..." +
                "\nVous devez chercher et trouver le coupable !\n";
    }

    default void printMainMenu() {
        System.out.println("\n********************\n" +
                "** MENU PRINCIPAL **\n" +
                "********************\n");

        System.out.println("Nouvelle partie (N)\n"
                + "Continuer la partie (C)\n"
                + "Quitter (Q)");
    }

    default void printActionMenu() {
        System.out.println("Listes des actions possibles :\n\t"
                + "-Se déplacer (D)\n\t"
                + "-Vérifier l'inventaire (I)\n\t"
                + "-Retour menu principal (R)\n");
    }

    default void printItemMenu() {
        System.out.println("Listes des actions possibles :\n\t"
                + "-Prendre objet (T)\n\t"
//                + "-Jeter objet (D)\n\t"
                + "-Voir contenu du sac (B)\n\t"
                + "-Retour au menu des actions (A)");
    }

    default void bagPackMenu() {
        System.out.println("Vous êtes dans votre sac.\nListes des actions possibles :\n\t"
                + "-Jeter objet (D)\n\t"
        		+ "-Retour menu des actions (A)\n\t"
        		+ "-Retour menu principal (R)\n");
    }

    default void EmptyBagPackMenu() {
        System.out.println("Vous êtes dans votre sac mais il est vide.\nListes des actions possibles :\n\t"
        		+ "-Retour menu des actions (A)\n\t"
        		+ "-Retour menu principal (R)\n");
    }

}
