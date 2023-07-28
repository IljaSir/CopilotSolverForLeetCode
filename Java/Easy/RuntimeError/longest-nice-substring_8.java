class Solution {
    public String longestNiceSubstring(String s) {
        
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        int i = 0;
        while (i < s.length() && counts[s.charAt(i) - 'a'] > 0) {
            i++;
        }
        if (i == s.length()) {
            return s;
        }
        String left = longestNiceSubstring(s.substring(0, i));
        String right = longestNiceSubstring(s.substring(i + 1));
        return left.length() >= right.length() ? left : right;
    }
}