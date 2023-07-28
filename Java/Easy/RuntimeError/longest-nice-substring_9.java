class Solution {
    public String longestNiceSubstring(String s) {
        
        if (s.length() < 2) {
            return "";
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a'] += 1;
        }
        int i = 0;
        while (i < s.length()) {
            if (count[s.charAt(i) - 'a'] < 2) {
                i++;
            } else {
                break;
            }
        }
        if (i == s.length()) {
            return s;
        }
        String l = longestNiceSubstring(s.substring(0, i));
        String r = longestNiceSubstring(s.substring(i + 1));
        return l.length() > r.length() ? l : r;
    }
}