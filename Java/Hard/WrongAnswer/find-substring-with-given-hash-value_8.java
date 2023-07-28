class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        
        int n = s.length();
        long[] p = new long[n];
        p[0] = 1;
        for(int i = 1; i < n; i++) {
            p[i] = (p[i - 1] * power) % modulo;
        }
        long[] h = new long[n + 1];
        for(int i = 0; i < n; i++) {
            h[i + 1] = (h[i] + (s.charAt(i) - 'a' + 1) * p[i]) % modulo;
        }
        for(int i = 0; i + k <= n; i++) {
            long curHash = (h[i + k] - h[i] + modulo) % modulo;
            if(curHash == hashValue * p[i] % modulo) {
                return s.substring(i, i + k);
            }
        }
        return "";
    }
}