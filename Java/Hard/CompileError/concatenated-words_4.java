class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        TrieNode root = new TrieNode();
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
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
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            if (dfs(word, 0, root, 0)) {
                result.add(word);
            }
        }
        return result;
    }
    private boolean dfs(String word, int index, TrieNode root, int count) {
        TrieNode node = root;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
            if (node.word != null) {
                if (i == word.length() - 1) {
                    return count >= 1;
                }
                if (dfs(word, i + 1, root, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}