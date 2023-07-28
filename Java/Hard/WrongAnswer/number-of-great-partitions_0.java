class Solution {
    public int countPartitions(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int[] dp = new int[n];
        int[] last = new int[n];
        Arrays.fill(last, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (sum[i] >= k) {
                ans++;
            }
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] >= k) {
                    int lastIdx = last[j];
                    if (lastIdx == -1) {
                        dp[i] = (dp[i] + 1) % 1000000007;
                    } else {
                        dp[i] = (dp[i] + dp[lastIdx]) % 1000000007;
                    }
                    last[j] = i;
                }
            }
            ans = (ans + dp[i]) % 1000000007;
        }
        return ans;
    }
}