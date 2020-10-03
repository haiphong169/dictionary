public class Word {
    private String english;
    private String pronounce;
    private String explaintion;

    public Word() {
        english = "";
        pronounce = "";
        explaintion = "";
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getEnglish() {
        return english;
    }

    public void setExplaintion(String explaintion) {
        this.explaintion = explaintion;
    }

    public String getExplaintion() {
        return explaintion;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public String getPronounce() {
        return pronounce;
    }

    /**
     *
     * @param str1 - string 1
     * @param str2 - string 2
     * @return - a interger
     */
    public static int compareWord(String str1, String str2) {
        int lengthMinString = Math.min(str1.length(), str2.length());
        for (int i = 0; i < lengthMinString; i++) {
            if (str1.charAt(i) > str2.charAt(i)) {
                return 1;
            } else if (str1.charAt(i) < str2.charAt(i)) {
                return -1;
            }
        }
        int test = Integer.compare(str1.length(), str2.length());
        if (test == 1) {
            return 1;
        } else if (test == -1) {
            return -1;
        } else {
            return 0;
        }
    }

}
