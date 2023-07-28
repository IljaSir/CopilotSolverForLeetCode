class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return result;
        }
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, i, j, trie.root, result);
            }
        }
        return result;
    }
    
    private void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode root, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        char c = board[i][j];
        if (root.children[c - 'a'] == null) {
            return;
        }
        root = root.children[c - 'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }
        visited[i][j] = true;
        dfs(board, visited, i + 1, j, root, result);
        dfs(board, visited, i - 1, j, root, result);
        dfs(board, visited, i, j + 1, root, result);
        dfs(board, visited, i, j - 1, root, result);
        visited[i][j] = false;
    }
    
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
    }
}