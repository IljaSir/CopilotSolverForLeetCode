class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> res = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie.root, res);
            }
        }
        return new ArrayList<String>(res);
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, Set<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }
}
    }
}