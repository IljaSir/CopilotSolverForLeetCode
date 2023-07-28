class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        String[] words = sentence.split(" ");
        Trie trie = new Trie();
        for (String root : dictionary) {
            trie.insert(root);
        }
        for (int i = 0; i < words.length; i++) {
            String replace = trie.replace(words[i]);
            if (replace != null) {
                words[i] = replace;
            }
        }
        return String.join(" ", words);
    }
}
    }
}