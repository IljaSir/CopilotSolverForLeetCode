class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, visited, i, j, trie.root, result);
            }
        }
        return result;
    }
    
    private void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode node, List<String> result) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        node = node.children[board[i][j] - 'a'];
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
    
    class Trie {
        TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode node = root;
            for(char c: word.toCharArray()) {
                int index = c - 'a';
                if(node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
    }
    
    class TrieNode {
        TrieNode[] children;
        String word;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}