class Solution {
    public int makeStringSorted(String s) {
        
        int n = s.length();
        int MOD = 1000000007;
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (int) ((long) fact[i - 1] * i % MOD);
        }
        int[] count = new int[26];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';
            int less = 0;
            for (int j = 0; j < c; j++) {
                less += count[j];
            }
            ans = (ans + (int) ((long) less * fact[n - i - 1] % MOD)) % MOD;
            count[c]++;
        }
        return ans;
    }
}