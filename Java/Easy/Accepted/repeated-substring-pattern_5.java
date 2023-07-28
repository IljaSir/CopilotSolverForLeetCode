class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        int n = s.length();
        int[] f = new int[n];
        for (int i = 1, j = 0; i < n; ++i) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = f[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                ++j;
            }
            f[i] = j;
        }
        return f[n - 1] > 0 && n % (n - f[n - 1]) == 0;
    }
}