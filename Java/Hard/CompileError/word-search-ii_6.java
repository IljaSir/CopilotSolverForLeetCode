class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, visited, i, j, trie.root, result);
            }
        }
        return result;
    }

    public void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode root, List<String> result) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return;
        }

        char c = board[i][j];
        TrieNode node = root.children[c - 'a'];
        if(node == null) {
            return;
        }

        if(node.word != null) {
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