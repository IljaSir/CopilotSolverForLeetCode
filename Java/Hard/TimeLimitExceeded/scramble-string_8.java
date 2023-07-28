class Solution {
    public boolean isScramble(String s1, String s2) {
        
        int n = s1.length();
        if (n != s2.length()) {
            return false;
        }
        if (n == 1) {
            return s1.equals(s2);
        }
        if (s1.equals(s2)) {
            return true;
        }
        // check if they are anagrams
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                return true;
            }
        }
        return false;
    }
}