class Solution {
    public int makeStringSorted(String s) {
        
        int MOD = 1000000007;
        int[] fact = new int[s.length() + 1];
        fact[0] = 1;
        for (int i = 1; i <= s.length(); ++i) {
            fact[i] = (int) ((long) fact[i - 1] * i % MOD);
        }
        int[] count = new int[26];
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            int less = 0;
            for (int j = s.charAt(i) - 'a' + 1; j < 26; ++j) {
                less += count[j];
            }
            ans = (ans + (int) ((long) less * fact[s.length() - 1 - i] % MOD)) % MOD;
            ++count[s.charAt(i) - 'a'];
        }
        return ans;
    }
}