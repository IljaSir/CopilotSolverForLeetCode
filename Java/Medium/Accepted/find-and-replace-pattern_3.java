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
    
    public boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (map.containsKey(w)) {
                if (map.get(w) != p) {
                    return false;
                }
            } else {
                if (set.contains(p)) {
                    return false;
                }
                map.put(w, p);
                set.add(p);
            }
        }
        return true;
    }
}