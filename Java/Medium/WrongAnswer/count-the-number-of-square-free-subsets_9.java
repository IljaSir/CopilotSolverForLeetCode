class Solution {
    public int squareFreeSubsets(int[] nums) {
        
        int MOD = 1_000_000_007;
        int n = nums.length;
        int[] cnt = new int[32];
        for (int x: nums) {
            cnt[x]++;
        }
        int[] dp = new int[1 << 16];
        dp[0] = 1;
        for (int i = 2; i <= 30; i++) {
            int[] ndp = new int[1 << 16];
            int mask = (1 << i) - 1;
            for (int j = 0; j < (1 << 16); j++) {
                if (dp[j] > 0) {
                    int c = cnt[i];
                    int nj = j;
                    for (int k = 0; k <= c; k++) {
                        ndp[nj] += dp[j];
                        if (ndp[nj] >= MOD) {
                            ndp[nj] -= MOD;
                        }
                        nj = ((nj << 1) & mask) | ((nj >> (i - 1)) & 1);
                    }
                }
            }
            dp = ndp;
        }
        int ans = 0;
        for (int i = 0; i < (1 << 16); i++) {
            if (dp[i] > 0) {
                int c = 0;
                for (int j = 0; j < 16; j++) {
                    if ((i & (1 << j)) > 0) {
                        c += cnt[j + 1];
                    }
                }
                if (c % 2 == 0) {
                    ans += dp[i];
                    if (ans >= MOD) {
                        ans -= MOD;
                    }
                } else {
                    ans -= dp[i];
                    if (ans < 0) {
                        ans += MOD;
                    }
                }
            }
        }
        return ans;
    }
}