class Solution {
    public int squareFreeSubsets(int[] nums) {
        
        int n = nums.length;
        int[] cnt = new int[31];
        for (int x : nums) {
            cnt[x]++;
        }
        int[] dp = new int[1 << 16];
        dp[0] = 1;
        for (int i = 1; i < 31; ++i) {
            if (cnt[i] == 0) {
                continue;
            }
            int[] t = new int[1 << 16];
            for (int j = 0; j < (1 << 16); ++j) {
                if (dp[j] > 0) {
                    int mask = j;
                    for (int k = 0; k < cnt[i]; ++k) {
                        mask = mask * i % 65536;
                        t[mask] = (t[mask] + dp[j]) % 1000000007;
                    }
                }
            }
            for (int j = 0; j < (1 << 16); ++j) {
                dp[j] = (dp[j] + t[j]) % 1000000007;
            }
        }
        int ret = 0;
        for (int i = 0; i < (1 << 16); ++i) {
            if (dp[i] > 0) {
                int x = 0;
                int y = i;
                while (y > 0) {
                    x += y % i;
                    y /= i;
                }
                if (x % 2 == 0) {
                    ret = (ret + dp[i]) % 1000000007;
                } else {
                    ret = (ret - dp[i] + 1000000007) % 1000000007;
                }
            }
        }
        return ret;
    }
}