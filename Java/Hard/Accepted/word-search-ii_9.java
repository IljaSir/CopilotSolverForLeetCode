class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        int m = board.length;
        int n = board[0].length;
        TrieNode root = buildTrie(words);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, ans);
            }
        }
        return ans;
    }
    void dfs(char[][] board, int i, int j, TrieNode p, List<String> ans) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            ans.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, ans); 
        if (j > 0) dfs(board, i, j - 1, p, ans);
        if (i < board.length - 1) dfs(board, i + 1, j, p, ans); 
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, ans); 
        board[i][j] = c;
    }
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
}