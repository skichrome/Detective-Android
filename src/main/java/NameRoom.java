public enum NameRoom {
    //Objets directement construits
    HALL("Le hall"),
    WC("La salle de bain"),
    ROOM("La chambre"),
    KITCHEN("La cuisine");

    private String name;

    //Constructeur
    NameRoom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}


//public enum Volume {
//    HALL {
//        @Override
//        public void access() {
//            System.out.println(roomName.getName());
//            System.out.println("Vous allez inspecter : (Q pour quitter)");
//            System.out.println("");
//            System.out.println("la cuisine (K)");
//            System.out.println("le salon (S)");
//            System.out.println("la bibliothï¿½que (L)");
//            choice = sc.nextLine().charAt(0);
//
//
//        }
//    }, MEDIUM {
//        @Override
//        public void alert() {
//            System.out.println("Tout baigne.");
//
//        }
//    }, HIGH {
//        @Override
//        public void alert() {
//            System.out.println("Attention, c'est trop fort !");
//
//        }
//    };