class Solution {
    public String longestNiceSubstring(String s) {
        
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (s.indexOf(Character.toLowerCase(c)) < 0 || s.indexOf(Character.toUpperCase(c)) < 0) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                return left.length() >= right.length() ? left : right;
            }
        }
        return s;
    }
}