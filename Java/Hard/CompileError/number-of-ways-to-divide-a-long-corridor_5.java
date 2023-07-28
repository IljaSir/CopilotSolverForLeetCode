class Solution {
    public int numberOfWays(String corridor) {
        
        int mod = 1000000007;
        int n = corridor.length();
        int[] dp = new int[n];
        int[] ps = new int[n];
        int[] pp = new int[n];
        int s = 0;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                s++;
            } else {
                p++;
            }
            ps[i] = s;
            pp[i] = p;
        }
        if (s < 2) {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                dp[i] = (dp[i - 1] * 2) % mod;
                if (i > 1 && corridor.charAt(i - 1) == 'P') {
                    int j = i - 2;
                    while (j >= 0 && corridor.charAt(j) == 'P') {
                        j--;
                    }
                    if (j >= 0) {
                        int k = i - j - 1;
                        dp[i] = (dp[i] + mod - ((dp[j] * (long) pp[i - 1] % mod * powMod(pp[j], mod - 2, mod) % mod * powMod(pp[i - 1] - pp[j], mod - 2, mod) % mod) % mod)) % mod;
                    }
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }

    public int powMod(int a, int b, int mod) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * (long) a) % mod;
            }
            a = (a * (long) a) % mod;
            b >>= 1;
        }
        return res;
    }
}