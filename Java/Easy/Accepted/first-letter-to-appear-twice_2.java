class Solution {
    public char repeatedCharacter(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                return c;
            } else {
                map.put(c, i);
            }
        }
        return ' ';
    }
}