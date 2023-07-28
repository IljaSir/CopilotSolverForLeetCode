class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> ans = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, trie.root, ans);
            }
        }
        return ans;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> ans) {
        char c = board[i][j];
        if (c == '#' || node.next[c - 'a'] == null) {
            return;
        }
        node = node.next[c - 'a'];
        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j, node, ans);
        }
        if (j > 0) {
            dfs(board, i, j - 1, node, ans);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, node, ans);
        }
        if (j < board[i].length - 1) {
            dfs(board, i, j + 1, node, ans);
        }
        board[i][j] = c;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.word = word;
        }
    }
}