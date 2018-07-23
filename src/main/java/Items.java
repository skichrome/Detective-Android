
public enum Items {

	ROPE("corde"),
    LIGHTER("briquet"),
    STRAND("mèche de cheveux"),
    BOOK("livre"),
    LETTER("lettre"),
    WINEGLASS("verre à pied"),
    KNIFE("couteau"),
    CELLULAR("téléphone portable"),
    TISSUE("mouchoir"),
    PEN("stylo"),
    USBDRIVE("clé usb"),
    BUSINESSCARD("carte de visite"),
    CALCULATOR("calculatrice"),
    HARDDISK("disque dur"),
    FLASHLIGHT("lampe de poche");
	
	private String nameItems;
	
	Items(String nameItems) {
        this.nameItems = nameItems;
    }
	
	public String getName() {
        return nameItems;
    }

    public String toString() {
        return nameItems;
    }
	
	
	
}
