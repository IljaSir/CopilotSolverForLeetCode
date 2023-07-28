class Solution {
    public int makeStringSorted(String s) {
        
        int mod = 1000000007;
        int n = s.length();
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (int) ((long) fact[i - 1] * i % mod);
        }
        int[] count = new int[26];
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';
            count[c]++;
            int less = 0;
            for (int j = 0; j < c; j++) {
                less += count[j];
            }
            res = (res + (int) ((long) less * fact[n - i - 1] % mod)) % mod;
            for (int j = c + 1; j < 26; j++) {
                res = (res + (int) ((long) count[j] * fact[n - i - 1] % mod)) % mod;
            }
        }
        return res;
    }
}