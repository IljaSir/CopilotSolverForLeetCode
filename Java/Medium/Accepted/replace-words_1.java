class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null || cur.word != null) {
                    break;
                }
                cur = cur.children[c - 'a'];
            }
            sb.append(cur.word != null ? cur.word : word);
        }
        return sb.toString();
    }
    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}