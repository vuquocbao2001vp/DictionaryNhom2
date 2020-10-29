package Dictionary;

import java.io.IOException;

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

    public void dictionarySearcher(String wordToSearcher){
        String[] list = DictionaryManagement.dictionarySearcher(wordToSearcher);
        for(int i = 0; i < list.length; i++){
            System.out.print(list[i]+" ");
        }
    }
}
