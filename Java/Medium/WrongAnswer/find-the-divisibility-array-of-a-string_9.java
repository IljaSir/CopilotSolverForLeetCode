class Solution {
    public int[] divisibilityArray(String word, int m) {
        
        int n = word.length();
        int[] ret = new int[n];
        int[] dp = new int[n];
        int[] mod = new int[m];
        int[] pow = new int[n];
        int i, j, k, l;
        pow[0] = 1;
        for (i = 1; i < n; ++i) {
            pow[i] = (pow[i - 1] * 10) % m;
        }
        for (i = 0; i < n; ++i) {
            dp[i] = (word.charAt(i) - '0') % m;
            if (dp[i] == 0) {
                ++ret[i];
            }
        }
        for (i = 1; i < n; ++i) {
            for (j = 0; j < m; ++j) {
                mod[j] = 0;
            }
            for (j = 0; j < m; ++j) {
                if (mod[j] > 0) {
                    k = (j + dp[i] * pow[i]) % m;
                    mod[k] += mod[j];
                    ret[i] += mod[j];
                }
            }
            ++mod[dp[i]];
        }
        return ret;
    }
}