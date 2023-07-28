class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> result = new ArrayList<String>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, visited, i, j, trie.root, result);
            }
        }
        return result;
    }
    public void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode node, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        char c = board[i][j];
        if (node.children[c - 'a'] == null) {
            return;
        }
        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        visited[i][j] = true;
        dfs(board, visited, i + 1, j, node, result);
        dfs(board, visited, i - 1, j, node, result);
        dfs(board, visited, i, j + 1, node, result);
        dfs(board, visited, i, j - 1, node, result);
        visited[i][j] = false;
    }
}
    }
}