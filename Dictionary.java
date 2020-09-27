import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    ArrayList<Word> dictionary = new ArrayList<Word>();
    Scanner sc = new Scanner(System.in);

    public void insertFromCommandline() {
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
            File file = new File("C:\\Users\\lapto\\Desktop\\dictionary.txt");
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
    }

}
