class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }
    
    private boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c1 = word.charAt(i);
            char c2 = pattern.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (used.contains(c2)) {
                    return false;
                }
                map.put(c1, c2);
                used.add(c2);
            }
        }
        return true;
    }
}