import java.util.Scanner;

public class DictionaryCommandline {
    /*Dictionary d = new Dictionary();

    public void showAllWords() {
        System.out.println("No" + "\t" + "|English" + "\t\t" + "|Vietnamese");
        for (int i = 0; i < d.dictionary.size(); i++) {
            System.out.println(i + 1 + "\t" + "|" + d.dictionary.get(i).getEng() + "\t\t\t" +  "|" + d.dictionary.get(i).getVn());
        }
    }
    public void dictionaryBasic() {
        d.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        d.exportToFile();
        d.insertFromFile();
        //d.changeTranslation();
        //d.removeWord();
        showAllWords();
        d.dictionarySearcher();

    }*/

//    public static int compareString(String str1, String str2)
//    {
//        int n;
//        if (str1.length() > str2.length()) {
//            n = str2.length();
//        } else {
//            n = str1.length();
//        }
//        for (int i = 0; i < n; i++) {
//            if (str1.charAt(i) > str2.charAt(i)) {
//                return 1;
//            } else if (str1.charAt(i) < str2.charAt(i)) {
//                return -1;
//            }
//        }
//        if (str1.length() > str2.length()) {
//            return 1;
//        } else if (str1.length() < str2.length()) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }

    public static int search(Dictionary dic, String unknownWord) {
        int head = 0;
        int tail = dic.dictionary.size() - 1;
        while (head <= tail) {
            int mid = head + (tail - head) / 2;
            if (Word.compareWord(unknownWord, dic.dictionary.get(mid).getEnglish()) < 0) {
                tail = mid - 1;
            } else if (Word.compareWord(unknownWord, dic.dictionary.get(mid).getEnglish()) > 0) {
                head = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Dictionary test = new Dictionary();
        test.readDataFromFile("dictionary.txt");
        Scanner scan = new Scanner(System.in);
        String searchWord = scan.nextLine();
        int pos = DictionaryCommandline.search(test, searchWord);
        if (pos == -1) System.out.println("Can not find word!");
        System.out.println(test.dictionary.get(pos).getEnglish() + " " + test.dictionary.get(pos).getPronounce());
        System.out.println(test.dictionary.get(pos).getExplaintion());
    }
}
