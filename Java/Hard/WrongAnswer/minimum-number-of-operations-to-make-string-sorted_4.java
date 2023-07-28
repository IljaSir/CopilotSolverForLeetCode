class Solution {
    public int makeStringSorted(String s) {
        
        int n = s.length();
        int[] f = new int[26];
        for (int i = 0; i < n; i++) {
            f[s.charAt(i) - 'a']++;
        }
        long res = 0;
        long mod = 1000000007;
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % mod;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < s.charAt(i) - 'a'; j++) {
                if (f[j] > 0) {
                    f[j]--;
                    res = (res + fact[n - 1 - i]) % mod;
                    f[j]++;
                }
            }
            f[s.charAt(i) - 'a']--;
        }
        return (int) res;
    }
}