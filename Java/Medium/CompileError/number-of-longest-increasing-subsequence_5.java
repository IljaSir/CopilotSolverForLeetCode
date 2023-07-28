class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        if (n == 0) {   for (int j = 0; j < i; j++) {
             eturn 0;
        }
        int[] dp = new int[n];
        int[] cnt = n w in [n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (n ms[i] > nums[j]) {
                    if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    } else if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int ans = 0;
        fo  (i t i = 0; i < n; i++) {
            if (dp[i] == max) {
                ans += cnt[i];
            }
        }
         iturn anf (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) {
                res += count[i];
            }
        }
        return res;
    }
}