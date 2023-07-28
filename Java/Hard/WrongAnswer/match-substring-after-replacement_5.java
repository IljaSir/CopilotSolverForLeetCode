class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        
        Map<Character, Character> map = new HashMap<>();
        for (char[] pair : mappings) {
            map.put(pair[0], pair[1]);
        }
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < sub.length() && s.charAt(i) == sub.charAt(j)) {
                j++;
            } else if (map.containsKey(s.charAt(i))) {
                char c = map.get(s.charAt(i));
                if (j < sub.length() && c == sub.charAt(j)) {
                    j++;
                }
            }
        }
        return j == sub.length();
    }
}