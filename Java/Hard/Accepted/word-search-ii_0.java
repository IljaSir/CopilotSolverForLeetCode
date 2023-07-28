class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie.root, res);
            }
        }
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }
        node = node.children[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j, node, res);
        }
        if (j > 0) {
            dfs(board, i, j - 1, node, res);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, node, res);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, node, res);
        }
        board[i][j] = c;
    }
    
    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        
        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
    }
    
    class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
}