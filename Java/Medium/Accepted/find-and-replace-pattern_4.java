class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            char b = pattern.charAt(i);
            if (!map.containsKey(a)) {
                map.put(a, b);
            } else {
                if (map.get(a) != b) {
                    return false;
                }
            }
        }
        boolean[] used = new boolean[26];
        for (char c : map.values()) {
            if (used[c - 'a']) {
                return false;
            }
            used[c - 'a'] = true;
        }
        return true;
    }
}