class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie.root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }

        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j, node, result);
        }
        if (j > 0) {
            dfs(board, i, j - 1, node, result);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, node, result);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, node, result);
        }
        board[i][j] = c;
    }
}
    }
}