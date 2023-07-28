class Solution {
    public int makeStringSorted(String s) {
        
        int n = s.length(), mod = (int)1e9 + 7;
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (int)((long)fact[i - 1] * i % mod);
        }
        int[] count = new int[26];
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';
            count[c]++;
            int sum = 0;
            for (int j = 0; j < c; j++) {
                sum += count[j];
            }
            res = (res + (int)((long)sum * fact[n - 1 - i] % mod)) % mod;
            for (int j = c + 1; j < 26; j++) {
                res = (res + (int)((long)count[j] * fact[n - 1 - i] % mod)) % mod;
            }
        }
        return res;
    }
}