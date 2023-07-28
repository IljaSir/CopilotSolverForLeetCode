class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }
        int[] dp = new int[words.length];
        return trie.dfs(dp);
    }
}
    }
}