package LeetCode;

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

public class SubstringWithConcatenationAllWords {

    public static List<Integer> findSubstring(String s, String[] words) {

        int n = words.length;
        List<Integer> ret = new LinkedList<>();
        if (s == null || s.length() == 0 || n == 0)
            return ret;
        int len = words[0].length();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        for (int i = 0; i <= s.length() - n * len; i++) {
            HashMap<String, Integer> record = new HashMap<>();
            int k = 0;
            while (k < n) {
                int start = i + k * len;
                int end = start + len;
                String str = s.substring(start, end);
                record.put(str, record.getOrDefault(str, 0) + 1);
                if (map.getOrDefault(str, 0) < record.get(str))
                    break;
                k++;
            }
            if (k == n)
                ret.add(i);
        }
        return ret;
    }

    public static void main(String[] args) {

        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "word"};
        findSubstring(s, words);
    }


}
