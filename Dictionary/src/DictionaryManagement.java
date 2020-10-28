import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class DictionaryManagement {

    public static void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        int sum_word = sc.nextInt();
        for (int i = 0; i < sum_word; i++) {
            String a, b;
            a = sc.next();
            b = sc.nextLine();
            Word word = new Word(a,b);
            Dictionary.listWord.add(word);
        }
    }

    public static void  insertFromFile() throws IOException {
        Scanner sc = new Scanner(Paths.get("C:\\Users\\Admin\\IdeaProjects\\Dictionary\\Dictionaries.txt"), "UTF-8");
        File dictionary_file = new File("C:\\Users\\Admin\\IdeaProjects\\Dictionary\\Dictionaries.txt");
        if(dictionary_file.exists()){
            while (sc.hasNextLine( )) {
                String a = sc.next();
                String b = sc.nextLine();
                Word word = new Word(a, a + b);
                Dictionary.listWord.add(word);
            }
            sc.close( );
        }
        else System.out.println("File error");
    }

    public static void dictionaryLookup(){
        String word_lookup;
        Scanner sc = new Scanner(System.in);
        word_lookup = sc.nextLine();
        int count = 0;
        for (int i = 0; i < Dictionary.listWord.size(); i++){
            if (Dictionary.listWord.get(i).getWord_target().equals(word_lookup))
            {
                count++;
                break;
            }
        }
        if (count != 0) System.out.println( "found in dictionary" );
        else System.out.println( "not found in dictionary" );
    }
    public static int dictionaryLookup(String word_lookup) {
        int i;
        for (i = 0; i < Dictionary.listWord.size(); i++){
            if (Dictionary.listWord.get(i).getWord_target().equals(word_lookup))
            {
                break;
            }
        }
        return i + 1;
    }

    public static void insertWord(String a, String b) throws IOException{
        Word word = new Word( a, b );
        FileWriter writer = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\Dictionary\\Dictionaries.txt", true);
        writer.write("\n" + a + "\t" + b);
        writer.close();
    }

    public static void repairWord(String wordToRepair, String newWord, String explainNewWord ) throws IOException {
        int count = dictionaryLookup(wordToRepair);
        FileWriter printWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\Dictionary\\Dictionaries.txt");
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            String temp = Dictionary.listWord.get(i).getWord_explain() + "\n";
            if ( i != count - 1)  printWriter.write(temp);
            else printWriter.write(newWord + "\t" + explainNewWord + "\n");
        }
        printWriter.close();

    }

    public static void deleteWord(String wordToDelete) throws IOException{
        int count = dictionaryLookup(wordToDelete);
        //Dictionary.words.remove(count);
        FileWriter printWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\Dictionary\\Dictionaries.txt");
        //    printWriter
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            String temp = Dictionary.listWord.get(i).getWord_explain() + "\n";
            if ( i != count - 1)  printWriter.write(temp);
        }
        printWriter.close();
    }

    public void  dictionaryExportToFile() throws IOException {
        // insert ; repairWord ; deleteWord;
        FileWriter printWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\Dictionary\\Dictionaries.txt");
        //    printWriter
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            String temp = Dictionary.listWord.get(i).getWord_target() + "\t" + Dictionary.listWord.get(i).getWord_explain() + "\n";
            printWriter.write(temp);
        }
    }

}
