class Solution {
    public char findTheDifference(String s, String t) {
        
        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            letters[c - 'a']--;
            if (letters[c - 'a'] < 0) {
                return c;
            }
        }
        return ' ';
    }
}