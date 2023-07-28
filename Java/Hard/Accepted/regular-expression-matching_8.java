class Solution {
    public boolean isMatch(String s, String p) {
        
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        boolean firstMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return isMatch(s, p, i, j + 2) || (firstMatch && isMatch(s, p, i + 1, j));
        } else {
            return firstMatch && isMatch(s, p, i + 1, j + 1);
        }
    }
}