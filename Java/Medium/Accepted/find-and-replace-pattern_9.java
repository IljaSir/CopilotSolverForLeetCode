class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> list = new ArrayList<>();
        for (String w : words) {
            if (match(w, pattern)) {
                list.add(w);
            }
        }
        return list;
    }
    
    public boolean match(String w, String p) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < w.length(); i++) {
            char wc = w.charAt(i);
            char pc = p.charAt(i);
            if (!map.containsKey(pc)) {
                if (set.contains(wc)) {
                    return false;
                }
                map.put(pc, wc);
                set.add(wc);
            } else {
                if (map.get(pc) != wc) {
                    return false;
                }
            }
        }
        return true;
    }
}