class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        return trie.count();
    }
}
    }
}