class Solution {
    public int squareFreeSubsets(int[] nums) {
        
        int n = nums.length;
        int mod = 1000000007;
        int[] count = new int[31];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        int[] dp = new int[1 << 30];
        dp[0] = 1;
        for (int i = 1; i <= 30; i++) {
            int[] tmp = new int[1 << 30];
            for (int j = 0; j < 1 << 30; j++) {
                if (dp[j] == 0) {
                    continue;
                }
                for (int k = 1; k <= count[i]; k++) {
                    int mask = j;
                    for (int l = 0; l < k; l++) {
                        mask |= 1 << (i * l);
                    }
                    tmp[mask] += dp[j];
                    if (tmp[mask] >= mod) {
                        tmp[mask] -= mod;
                    }
                }
            }
            for (int j = 0; j < 1 << 30; j++) {
                dp[j] += tmp[j];
                if (dp[j] >= mod) {
                    dp[j] -= mod;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 1 << 30; i++) {
            int cnt = 0;
            for (int j = 0; j < 30; j++) {
                if ((i & (1 << j)) != 0) {
                    cnt++;
                }
            }
            if (cnt % 2 == 0) {
                ans += dp[i];
                if (ans >= mod) {
                    ans -= mod;
                }
            } else {
                ans -= dp[i];
                if (ans < 0) {
                    ans += mod;
                }
            }
        }
        return ans;
    }
}