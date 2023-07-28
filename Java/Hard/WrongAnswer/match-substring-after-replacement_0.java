class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        
        Map<Character, Character> map = new HashMap<>();
        for (char[] mapping : mappings) {
            map.put(mapping[0], mapping[1]);
        }
        int i = 0;
        int j = 0;
        while (i < s.length() && j < sub.length()) {
            if (s.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else if (map.containsKey(sub.charAt(j))) {
                if (map.get(sub.charAt(j)) == s.charAt(i)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return j == sub.length();
    }
}