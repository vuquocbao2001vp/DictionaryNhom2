import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        try {

            dictionaryCommandline.dictionaryAdvanced();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        dictionaryCommandline.dictionarySearcher("aw");
    }
}
