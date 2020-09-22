import java.util.Scanner;

public class Word {
    private String eng;
    private String vn;

    public Word(String e, String v) {
        eng = e;
        vn = v;
    }

    public String getEng() {
        return eng;
    }

    public String getVn() {
        return vn;
    }

    public void setVn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new word: ");
        String s = sc.nextLine();
        vn = s;
    }
}
