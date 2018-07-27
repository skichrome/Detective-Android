import java.util.Hashtable;

public class SplashScreen {

    private static final int H = 5; // number of line  == ascii letter size
    private static Hashtable<Character, String[]> characterHashMap = new Hashtable<>();

    public SplashScreen() {

        characterHashMap.put('A', new String[]{" 0 ", "0 0", "000", "0 0", "0 0"});
        characterHashMap.put('B', new String[]{"00 ", "0 0", "00 ", "0 0", "00 "});
        characterHashMap.put('C', new String[]{" 00", "0  ", "0  ", "0  ", " 00"});
        characterHashMap.put('D', new String[]{"00 ", "0 0", "0 0", "0 0", "00 "});
        characterHashMap.put('E', new String[]{"000", "0  ", "00 ", "0  ", "000"});
        characterHashMap.put('F', new String[]{"000", "0  ", "00 ", "0  ", "0  "});
        characterHashMap.put('G', new String[]{" 00", "0  ", "0 0", "0 0", " 00"});
        characterHashMap.put('H', new String[]{"0 0", "0 0", "000", "0 0", "0 0"});
        characterHashMap.put('I', new String[]{" 0 ", " 0 ", " 0 ", " 0 ", " 0 "});
        characterHashMap.put('J', new String[]{"000", "  0", "  0", "0 0", " 0 "});
        characterHashMap.put('K', new String[]{"0 0", "00 ", "00 ", "0 0", "0 0"});
        characterHashMap.put('L', new String[]{"0  ", "0  ", "0  ", "0  ", "000"});
        characterHashMap.put('M', new String[]{"0 0", "000", "000", "0 0", "0 0"});
        characterHashMap.put('N', new String[]{"000", "0 0", "0 0", "0 0", "0 0"});
        characterHashMap.put('O', new String[]{" 0 ", "0 0", "0 0", "0 0", " 0 "});
        characterHashMap.put('P', new String[]{"00 ", "0 0", "00 ", "0  ", "0  "});
        characterHashMap.put('Q', new String[]{" 0 ", "0 0", "0 0", " 00", "  0"});
        characterHashMap.put('R', new String[]{"00 ", "0 0", "00 ", "0 0", "0 0"});
        characterHashMap.put('S', new String[]{" 00", "0  ", " 0 ", "  0", "00 "});
        characterHashMap.put('T', new String[]{"000", " 0 ", " 0 ", " 0 ", " 0 "});
        characterHashMap.put('U', new String[]{"0 0", "0 0", "0 0", "0 0", "000"});
        characterHashMap.put('V', new String[]{"0 0", "0 0", "0 0", "0 0", " 0 "});
        characterHashMap.put('W', new String[]{"0 0", "0 0", "000", "000", "0 0"});
        characterHashMap.put('X', new String[]{"0 0", "0 0", " 0 ", "0 0", "0 0"});
        characterHashMap.put('Y', new String[]{"0 0", "0 0", " 0 ", " 0 ", " 0 "});
        characterHashMap.put('Z', new String[]{"000", "  0", " 0 ", "0  ", "000"});
    }


    //    For testing each letter
    public String showLetter(char c) {
        StringBuilder builder = new StringBuilder();
        for (String res : characterHashMap.get(c)) {
            builder.append(res).append(System.lineSeparator());
        }
        return builder.toString();
    }

    //     0 Help to permute simple char into ascii art letter
    public void displayAsciiWord(String s) {
        String[][] matrix = new String[H][s.length()];
        s = s.toUpperCase();

        for (int j = 0; j < matrix.length; j++) {
            System.out.println();
            for (int k = 0; k < matrix[j].length; k++) {
                if (characterHashMap.containsKey(s.charAt(k))) {
                    matrix[j][k] = characterHashMap.get(s.charAt(k))[j] + "  ";
                    System.out.print(matrix[j][k]);
                } else
                    System.out.print("  ");
            }
        }
        System.out.println();
    }
}
