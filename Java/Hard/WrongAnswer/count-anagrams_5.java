class Solution {
    public int countAnagrams(String s) {
        
        int ans = 0;
        int n = s.length();
        int mod = 1000000007;
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; ++i) {
            fact[i] = (int) ((long) fact[i - 1] * i % mod);
        }
        int[] cnt = new int[26];
        int p = 1;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == ' ') {
                ans = (int) ((long) ans + p * fact[n - i - 1] % mod);
                p = 1;
                cnt = new int[26];
            } else {
                ++cnt[s.charAt(i) - 'a'];
                int sum = 0;
                for (int j = 0; j < 26; ++j) {
                    sum += cnt[j];
                }
                p = (int) ((long) p * fact[sum - 1] % mod);
                for (int j = 0; j < 26; ++j) {
                    p = (int) ((long) p * fact[cnt[j]] % mod);
                }
            }
        }
        ans = (int) ((long) ans + p * fact[n - n] % mod);
        return ans;
    }
}