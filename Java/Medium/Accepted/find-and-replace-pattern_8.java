class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> result = new ArrayList<String>();
        for (String word : words) {
            if (isMatch(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }
    
    public boolean isMatch(String word, String pattern) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!map.containsKey(w)) {
                map.put(w, p);
            }
            if (!map2.containsKey(p)) {
                map2.put(p, w);
            }
            if (map.get(w) != p || map2.get(p) != w) {
                return false;
            }
        }
        return true;
    }
}