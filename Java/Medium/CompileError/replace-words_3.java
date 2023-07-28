class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        TrieNode root = new TrieNode();
        for (String word: dictionary) {
            TrieNode node = root;
            for (char c: word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        StringBuilder sb = new StringBuilder();
        for (String word: sentence.split("\\s+")) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            TrieNode node = root;
            for (char c: word.toCharArray()) {
                if (node.children[c - 'a'] == null || node.word != null) {
                    break;
                }
                node = node.children[c - 'a'];
            }
            sb.append(node.word != null ? node.word : word);
        }
        return sb.toString();
    }
}
    }
}