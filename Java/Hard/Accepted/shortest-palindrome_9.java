class Solution {
    public String shortestPalindrome(String s) {
        
        if (s == null || s.length() == 0) return s;
        String reverse = new StringBuilder(s).reverse().toString();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.substring(0, len - i).equals(reverse.substring(i))) {
                return reverse.substring(0, i) + s;
            }
        }
        return "";
    }
}