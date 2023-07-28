class Solution {
    public int makeStringSorted(String s) {
        
        int n = s.length();
        int MOD = 1000000007;
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }
        long[] count = new long[26];
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int ch = s.charAt(i) - 'a';
            long less = 0;
            for (int j = 0; j < ch; j++) {
                less += count[j];
            }
            ans += less * factorial[n - 1 - i] % MOD;
            ans %= MOD;
            count[ch]++;
        }
        return (int) ans;
    }
}