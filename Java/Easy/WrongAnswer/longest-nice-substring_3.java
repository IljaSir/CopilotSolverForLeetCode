class Solution {
    public String longestNiceSubstring(String s) {
        
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (!Character.isLowerCase(s.charAt(i))) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                return left.length() >= right.length() ? left : right;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!Character.isUpperCase(s.charAt(i))) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                return left.length() >= right.length() ? left : right;
            }
        }
        return s;
    }
}