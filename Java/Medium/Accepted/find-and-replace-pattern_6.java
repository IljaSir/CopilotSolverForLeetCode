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
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c1 = word.charAt(i);
            char c2 = pattern.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (set.contains(c2)) {
                    return false;
                }
                map.put(c1, c2);
                set.add(c2);
            }
        }
        return true;
    }
}