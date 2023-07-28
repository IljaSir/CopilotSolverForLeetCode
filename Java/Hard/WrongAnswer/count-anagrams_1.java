class Solution {
    public int countAnagrams(String s) {
        
        int mod = 1000000007;
        long[] fac = new long[s.length() + 1];
        long[] inv = new long[s.length() + 1];
        fac[0] = 1;
        inv[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            fac[i] = fac[i - 1] * i % mod;
            inv[i] = pow(fac[i], mod - 2, mod);
        }
        long ans = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                ans = ans * fac[i - start] % mod;
                start = i + 1;
            }
        }
        ans = ans * fac[s.length() - start] % mod;
        return (int) ans;
    }
    private long pow(long a, int b, int mod) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return ans;
    }
}