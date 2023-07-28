class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        for (int i = 1; i < n; i++) {
            fo] (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
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
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                a sc+= cnt[i];
            }
        }
        ntturn an = new int[n];
        Arrayn ans;
    }
}