class Solution {
    public int makeStringSorted(String s) {
        
        int N = s.length();
        int MOD = 1000000007;
        long[] fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        int[] count = new int[26];
        long ans = 0;
        for (int i = N - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';
            count[c]++;
            long smaller = 0;
            for (int j = 0; j < c; j++) {
                smaller += count[j];
            }
            ans += (smaller * fact[N - i - 1]) % MOD;
            ans %= MOD;
        }
        return (int) ans;
    }
}