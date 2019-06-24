package LeetCode;

public class WordDictionary {

    public TrieNode root;

    class TrieNode {

        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (!node.containsKey(curChar))
                node.put(curChar, new TrieNode());
            node = node.get(curChar);
        }
        node.isEnd = true;
    }

    private boolean search(TrieNode node, String word, int idx) {
        if (idx == word.length())
            return node.isEnd;
        char c = word.charAt(idx);
        boolean flag = false;

        if (c == '.') {
            for (TrieNode tmp : node.links) {
                if (tmp != null)
                    flag = flag || search(tmp, word, idx + 1);
            }
        } else if (node.get(c) == null){
            return false;
        }
        else
            return search(node.get(c), word, idx + 1);
        return flag;

    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(this.root, word, 0);
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("bd");
        wd.addWord("b");
        System.out.println(wd.search("ba."));
    }
}
