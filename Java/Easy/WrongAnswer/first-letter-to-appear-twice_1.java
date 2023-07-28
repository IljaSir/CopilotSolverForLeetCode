class Solution {
    public char repeatedCharacter(String s) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (count[c - 'a'] > 1) {
                return c;
            }
        }
        return ' ';
    }
}