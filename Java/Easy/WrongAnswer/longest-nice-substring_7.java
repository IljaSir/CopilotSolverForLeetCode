class Solution {
    public String longestNiceSubstring(String s) {
        
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (!Character.isUpperCase(s.charAt(i))) {
                String s1 = longestNiceSubstring(s.substring(0, i));
                String s2 = longestNiceSubstring(s.substring(i + 1));
                return s1.length() >= s2.length() ? s1 : s2;
            }
        }
        for (int i = 0; i < len; i++) {
            if (!s.contains("" + Character.toUpperCase(s.charAt(i)))) {
                String s1 = longestNiceSubstring(s.substring(0, i));
                String s2 = longestNiceSubstring(s.substring(i + 1));
                return s1.length() >= s2.length() ? s1 : s2;
            }
        }
        return s;
    }
}