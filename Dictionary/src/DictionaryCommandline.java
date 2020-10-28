import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class DictionaryCommandline {

    public void showAllWords(){
        //   Dictionary dictionary = new Dictionary();
        System.out.println("No    | English    | Vietnamese ");
        for(int i = 0; i < Dictionary.listWord.size(); i++){
            System.out.println(i + 1 + "     | " +
                    Dictionary.listWord.get(i).getWord_target() + "         |" +
                    Dictionary.listWord.get(i).getWord_explain());
        }
    }
    public void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() throws IOException {
        DictionaryManagement.insertFromFile( );
        showAllWords( );
        DictionaryManagement.dictionaryLookup();
    }

    public ArrayList<String> dictionarySearcher(String wordToSearcher){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            String word =  Dictionary.listWord.get(i).getWord_target();
            if(word.contains(wordToSearcher) && guessWord(wordToSearcher, Dictionary.listWord.get(i).getWord_target()) == true) list.add(word);
        }
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        return list;
    }

    public boolean guessWord(String a, String b){
        boolean check = true;
        for ( int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                check = false;
            }
        }
        return check;
    }

}
