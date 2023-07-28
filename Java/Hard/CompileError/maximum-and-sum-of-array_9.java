class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        
        int n = nums.length;
        int m = numSlots;
        int[] dp = new int[1 << m];
        int[] pre = new int[1 << m];
        int[] suf = new int[1 << m];
        int[] cnt = new int[1 << m];
        int[] sum = new int[1 << m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < (1 << m); ++j) {
                if ((i & j) == 0) {
                    cnt[j]++;
                    sum[j] += nums[i];
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < (1 << m); ++j) {
                if ((j >> i & 1) == 1) {
                    cnt[j] += cnt[j ^ (1 << i)];
                    sum[j] += sum[j ^ (1 << i)];
                }
            }
        }
        for (int i = 0; i < (1 << m); ++i) {
            if (cnt[i] == m) {
                dp[i] = sum[i];
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < (1 << m); ++j) {
                if ((j >> i & 1) == 1) {
                    dp[j] = Math.max(dp[j], dp[j ^ (1 << i)]);
                }
            }
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < (1 << m); ++j) {
                if ((j >> i & 1) == 1) {
                    pre[j] = Math.max(pre[j], pre[j ^ (1 << i)]);
                    suf[j] = Math.max(suf[j], suf[j ^ (1 << i)]);
                } else {
                    pre[j] = Math.max(pre[j], dp[j ^ (1 << i)]);
                    suf[j] = Math.max(suf[j], dp[j ^ (1 << i)]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i
    }
}