
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

    private String fileName = "saveRoom.txt";
    private File file = new File(fileName);

    public Save() {
    }

    public void saveRoom(char choice) {
        //on demande à l'utilisateur s'il veut sauvegarder sa salle
        // si oui, on écrit dans le fichier


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

            bufferedWriter.write(choice);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public char loadRoom() {

        BufferedReader bufferedReader = null;
        char letter = '\n';

        try {
            FileReader fileReader = new FileReader(file);

            bufferedReader = new BufferedReader(fileReader);
            // met en tampon le contenu
            // lit le fichier

            String line = "";

            // lit la ligne

            while ((line = bufferedReader.readLine()) != null) {

                letter = line.charAt(0);
                System.out.println(letter);
                // affiche la ligne
            }


        } catch (FileNotFoundException e) {
            System.err.printf("Le fichier %s n'a pas été trouvé.", file.toString());
        } catch (IOException e) {
            System.err.println("Impossible de lire le contenu du fichier " + file.toString());
        } finally {
            // execute finally quoiqu'il arrive

            try {

                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible de fermer le fichier " + file.toString());
            } catch (NullPointerException e) {
                System.err.println("Impossible d'ouvrir le fichier " + file.toString());
            }

        }

        return letter;

    }


}

