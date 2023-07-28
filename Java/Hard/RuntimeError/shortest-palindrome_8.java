class Solution {
    public String shortestPalindrome(String s) {
        
        int n = s.length();
        int[] p = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = p[j - 1];
            if (s.charAt(i) == s.charAt(j)) j++;
            p[i] = j;
        }
        int j = p[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) j++;
        }
        if (j == n) return s;
        String suffix = s.substring(j);
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
}