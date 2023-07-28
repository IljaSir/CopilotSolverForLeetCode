class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        Set<String> result = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie.root, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, Set<String> result) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) {
            return;
        }
        p = p.next[c - 'a'];
        if (p.word != null) {
            result.add(p.word);
        }
        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j, p, result);
        }
        if (j > 0) {
            dfs(board, i, j - 1, p, result);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, p, result);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, p, result);
        }
        board[i][j] = c;
    }
}
    }
}