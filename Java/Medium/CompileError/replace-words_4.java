class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        Trie trie = new Trie();
        for (String root: dictionary) {
            trie.insert(root);
        }
        StringBuilder ans = new StringBuilder();
        for (String word: sentence.split("\\s+")) {
            String prefix = trie.search(word);
            if (prefix != null) {
                ans.append(prefix);
            } else {
                ans.append(word);
            }
            ans.append(" ");
        }
        return ans.toString().trim();
    }
}
    }
}