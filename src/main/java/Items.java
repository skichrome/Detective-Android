
public enum Items {

	ROPE("corde"),
    LIGHTER("briquet"),
    STRAND("m?che de cheveux"),
    BOOK("livre"),
    LETTER("lettre"),
    WINEGLASS("verre ? pied"),
    KNIFE("couteau"),
    CELLULAR("t?l?phone portable"),
    TISSUE("mouchoir"),
    PEN("stylo"),
    USBDRIVE("cl? usb"),
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
