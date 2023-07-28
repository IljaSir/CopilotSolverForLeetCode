class Solution {
    public String shortestPalindrome(String s) {
        
        int n = s.length();
        int[] f = new int[n];
        for (int i = 1; i < n; i++) {
            int t = f[i - 1];
            while (t > 0 && s.charAt(i) != s.charAt(t)) {
                t = f[t - 1];
            }
            if (s.charAt(i) == s.charAt(t)) {
                t++;
            }
            f[i] = t;
        }
        int best = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (best > 0 && s.charAt(i) != s.charAt(best)) {
                best = f[best - 1];
            }
            if (s.charAt(i) == s.charAt(best)) {
                best++;
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(best));
        return sb.reverse().toString() + s;
    }
}