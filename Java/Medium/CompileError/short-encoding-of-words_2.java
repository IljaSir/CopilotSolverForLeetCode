class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie.count();
    }
}
    }
}