class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(trie.search(word));
        }
        return sb.toString();
    }
}
    }
}