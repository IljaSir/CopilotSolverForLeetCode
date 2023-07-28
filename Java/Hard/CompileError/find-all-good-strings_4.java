class Solution {
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        
        int MOD = 1000000007;
        int[] dp = new int[n + 1];
        int[] dp2 = new int[n + 1];
        int[] next = new int[evil.length() + 1];
        int[] fail = new int[evil.length() + 1];
        for (int i = 0; i < evil.length(); ++i) {
            int j = i;
            while (j > 0 && evil.charAt(j) != evil.charAt(i)) {
                j = fail[j - 1];
            }
            if (j > 0 || evil.charAt(j) == evil.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        next[0] = 0;
        for (int i = 1; i <= evil.length(); ++i) {
            int j = i - 1;
            while (j > 0 && evil.charAt(j) != s2.charAt(i - 1)) {
                j = fail[j - 1];
            }
            if (j > 0 || evil.charAt(j) == s2.charAt(i - 1)) {
                ++j;
            }
            next[i] = j;
        }
        int max = 1;
        for (int i = 0; i < n; ++i) {
            max = (max * 26) % MOD;
        }
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            int min = s1.charAt(i) - 'a';
            int max = s2.charAt(i) - 'a';
            for (int j = 0; j < 26; ++j) {
                if (j < min || j > max) {
                    continue;
                }
                int k = next[i + 1];
                while (k > 0 && evil.charAt(k) != 'a' + j) {
                    k = fail[k - 1];
                }
                if (k > 0 || evil.charAt(k) == 'a' + j) {
                    ++k;
                }
                dp2[i + 1] = (dp2[i + 1] + dp[i] - (k == evil.length() ? dp[k - 1] : 0) + MOD) % MOD;
            }
            for (int
    }
}