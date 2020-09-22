import java.util.Scanner;

public class DictionaryCommandline {
    Dictionary d = new Dictionary();

    public void showAllWords() {
        System.out.println("No      |English      |Vietnamese");
        for (int i = 0; i < d.dictionary.size(); i++) {
            System.out.println(i + 1 + "      |" + d.dictionary.get(i).getEng() + "      |" + d.dictionary.get(i).getVn());
        }
    }

    public void dictionaryBasic() {
        d.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        d.insertFromFile();
        //d.changeTranslation();
        //d.removeWord();
        showAllWords();
        d.dictionarySearcher();
    }

    public static void main(String[] args) {
        DictionaryCommandline dc = new DictionaryCommandline();
        dc.dictionaryAdvanced();
    }
}
