import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Dictionary {
    ArrayList<Word> dictionary = new ArrayList<>();
    /*public void insertFromCommandline() {
        System.out.println("How many words do you want to enter: ");
        int num = sc.nextInt();
        sc.skip("\n");
        System.out.println("Enter " + num + " word(s): ");
        for (int i = 0; i < num; i++) {
            String e = sc.nextLine();
            String v = sc.nextLine();
            Word newWord = new Word(e, v);
            dictionary.add(newWord);
        }
    }

    public void insertFromFile() {
        try {
            File file = new File("dictionary.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] input = new String[2];
                input = sc.nextLine().split("\t");
                Word newWord = new Word(input[0], input[1]);
                dictionary.add(newWord);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dictionaryLookup() {
        System.out.println("Enter a word: ");
        String searchedWord = sc.nextLine();
        for (Word word : dictionary) {
            if (word.getEng().equals(searchedWord.toLowerCase())) {
                System.out.println(word.getVn());
                break;
            }
        }
    }

    public void dictionarySearcher() {
        System.out.println("Enter a word: ");
        String s = sc.nextLine();
        for (Word word : dictionary) {
            if (word.getEng().substring(0, s.length()).equals(s)) {
                System.out.println(word.getEng());
            }
        }
    }

    public void changeTranslation() {
        System.out.println("Enter a word: ");
        String s = sc.nextLine();
        for (Word word : dictionary) {
            if (word.getEng().equals(s)) {
                word.setVn();
                break;
            }
        }
    }

    public void removeWord() {
        System.out.println("Enter a word: ");
        String s = sc.nextLine();
        for (Word word : dictionary) {
            if (word.getEng().equals(s)) {
                dictionary.remove(word);
                break;
            }
        }
    }

    public void exportToFile() {
        String eng = sc.nextLine();
        String vn = sc.nextLine();
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\lapto\\Desktop\\dictionary.txt",true);
            fileWriter.write("\n" + eng + "\t" + vn);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }*/

    /**
     * đọc dữ liệu từ file vào từ điển
     *
     * @param path - path of file.
     */
    public void readDataFromFile(String path) {
        try {
            File file = new File(path);
            Scanner scan = new Scanner(file);
            String english = "";
            String pronouce = "";
            String explaintion = "";
            while (scan.hasNextLine()) {
                String aWordReadFromFile = scan.next();
                String aLineReadFromFile;
                if (aWordReadFromFile.charAt(0) == '@') {
                    int lengthWord = aWordReadFromFile.length();
                    aLineReadFromFile = aWordReadFromFile.substring(1, lengthWord)
                            + scan.nextLine();
                } else {
                    aLineReadFromFile = aWordReadFromFile + scan.nextLine();
                }

                if (aWordReadFromFile.charAt(0) == '@') {
                    if (english != "" && explaintion != "") {
                        Word word = new Word();
                        word.setEnglish(english);
                        word.setPronounce(pronouce);
                        word.setExplaintion(explaintion);
                        dictionary.add(word);
                    }
                    english = aLineReadFromFile.substring(0, aLineReadFromFile.indexOf(" /") + 1);
                    english = english.trim();
                    pronouce = aLineReadFromFile.substring(english.length(),
                            aLineReadFromFile.indexOf("/", english.length() + 2) + 1);
                    explaintion = "";
                }
                explaintion += aLineReadFromFile;
                explaintion += "\n";
            }
            Word lastWord = new Word();
            lastWord.setEnglish(english);
            lastWord.setPronounce(pronouce);
            lastWord.setExplaintion(explaintion);
            dictionary.add(lastWord);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hiển thị toàn bộ từ của từ điển.
     */
    public void showAllWord() {
        System.out.println(dictionary.size());
        for (int i = 0; i < dictionary.size(); i++) {
            System.out.println(dictionary.get(i).getEnglish());
        }
    }
}
