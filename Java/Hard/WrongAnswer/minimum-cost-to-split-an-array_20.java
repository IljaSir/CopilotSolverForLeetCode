class Solution {
    public int minCost(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] next = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < k; i++) {
            int[] cnt = new int[n];
            for (int j = 0; j < n; j++) {
                cnt[nums[j]]++;
            }
            Arrays.fill(next, Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    int sum = 0;
                    int max = 0;
                    for (int l = j; l < n; l++) {
                        if (cnt[nums[l]] == 1) {
                            sum++;
                        }
                        max = Math.max(max, cnt[nums[l]]);
                        next[l] = Math.min(next[l], dp[j] + sum + k - max);
                    }
                }
            }
            int[] tmp = dp;
            dp = next;
            next = tmp;
        }
        return dp[n - 1];
    }
}