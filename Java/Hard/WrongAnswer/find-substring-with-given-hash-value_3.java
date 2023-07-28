class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        
        int n = s.length();
        int[] p = new int[n];
        p[0] = 1;
        for (int i = 1; i < n; i++) {
            p[i] = (p[i - 1] * power) % modulo;
        }
        int[] h = new int[n];
        h[0] = s.charAt(0) - 'a' + 1;
        for (int i = 1; i < n; i++) {
            h[i] = (h[i - 1] + (s.charAt(i) - 'a' + 1) * p[i]) % modulo;
        }
        for (int i = 0; i + k <= n; i++) {
            int hash = h[i + k - 1];
            if (i > 0) {
                hash = (hash - h[i - 1] + modulo) % modulo;
            }
            if (hash == (hashValue * p[i]) % modulo) {
                return s.substring(i, i + k);
            }
        }
        return "";
    }
}