package cipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CaesarCipher {
    private final ArrayList<Character> listEn = new ArrayList(
            Arrays.asList(
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                    'u', 'v', 'w', 'x', 'y', 'z'
            ));
    private final ArrayList<Character> reverseEn = reverseList(listEn);
    private final ArrayList<Character> listSym = new ArrayList(
            Arrays.asList('.', ',', '«', '»', '\"', '\'', ':', '!', '?', ' ')
    );
    private final ArrayList<Character> reverseSym = reverseList(listSym);
    private ArrayList<Character> list = reverseEn;
    private ArrayList<Character> listSymbol = reverseSym;
    private String textEnd;
    private int keyEnd;

    public CaesarCipher() {
        this.textEnd = "";
        this.keyEnd = 0;
    }

    public String getTextEnd() {
        return textEnd;
    }

    public int getKeyEnd() {
        return keyEnd;
    }

    private <T> ArrayList<T> reverseList(ArrayList<T> list) {
        ArrayList<T> reverse = new ArrayList<>(list);
        Collections.reverse(reverse);
        return reverse;
    }

    public String decryptEncrypt(String command, int key, String textStart) {
        if (command.equals("ENCRYPT")) {
            list = listEn;
            listSymbol = listSym;
        }

        for (int i = 0; i < textStart.length(); i++) {
            char c = textStart.charAt(i);
            if (Character.isUpperCase(c)) {
                char ch = Character.toLowerCase(textStart.charAt(i));
                if (list.contains(ch)) {
                    int num = (list.indexOf(ch) + (key % list.size())) % list.size();
                    textEnd += Character.toUpperCase(list.get(num));
                } else {
                    textEnd += ch;
                }
            } else {
                char ch = textStart.charAt(i);
                if (list.contains(textStart.charAt(i))) {
                    int num = (list.indexOf(ch) + (key % list.size())) % list.size();
                    textEnd += list.get(num);
                } else if (listSymbol.contains(textStart.charAt(i))) {
                    int numSymbol = (listSymbol.indexOf(ch) + (key % listSymbol.size())) % listSymbol.size();
                    textEnd += listSymbol.get(numSymbol);
                } else {
                    textEnd += ch;
                }
            }
        }
        return textEnd;
    }

    public String bruteForce(String textStart) {
        for (int i = 1; i <= list.size(); i++) {
            int countThe = 0;
            String textEndFor = decryptEncrypt("DECRYPT", i, textStart);
            countThe = countArticleThe(textEndFor);
            textEnd = "";
            if (countThe > 3) {
                this.keyEnd = i;
                textEnd += textEndFor;
                break;
            }
        }
        return textEnd;
    }

    public int countArticleThe(String str) {
        str = str.toLowerCase();
        String target = " the ";
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
}