class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        Trie trie = new Trie();
        for (String root : dictionary) {
            trie.insert(root);
        }
        StringBuilder res = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            if (res.length() > 0) {
                res.append(" ");
            }
            TrieNode cur = trie.root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null || cur.word != null) {
                    break;
                }
                cur = cur.children[c - 'a'];
            }
            res.append(cur.word != null ? cur.word : word);
        }
        return res.toString();
    }
}
    }
}