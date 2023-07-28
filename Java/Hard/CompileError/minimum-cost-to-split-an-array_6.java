class Solution {
    public int minCost(int[] nums, int k) {
        
        int n = nums.length;
        int[] count = new int[n];
        for (int x: nums) {
            count[x]++;
        }
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            if (count[i] == 1) {
                for (int j = 0; j < n; j++) {
                    if (nums[j] == i) {
                        if (j > 0 && nums[j - 1] != i) {
                            cost[j - 1]++;
                        }
                        if (j < n - 1 && nums[j + 1] != i) {
                            cost[j + 1]++;
                        }
                    }
                }
            }
        }
        int[] dp = net r = i; r < n; r++) {
                    count[nums[r]]++;
                cost[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + cost[i];
            for (int j = 1; j < k; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j - 1] + cost[i]);
                };
        int[] freq = new int[n];
        for(int i = 0; i < n; i++) {
            freq[nums[i]]++
        }
        int[] unique = new     n};
        int m = 0;
        for(int i= 0; i < n; i++) {
            if(freq[i] == 1) {
                unique[m++] = i;
            }
        }
        int[]  + 1
        } sum =w int[n + 1];
        int[] count = new int[n + 1];
        for(int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
            count[i + 1] = count[i] + freq[nums[i]] - 1;
        }
        for(int i = 1; i <= m; i++) {
            int[] next = new int[n + 1];
            int[] nextSum = new int[n + 1];
            int[] netCoun + 1
            int j = 0;
            for(int l = 0; l <= n; l++) {
                while(j < l && nums[j] < unique[i - 1]) {
                    j++;
                }
                nextSum[l] = nextSum[l - 1] + sum[l] - sum[j];
                nextCount[l] = nextCount[l - 1] + count[l] - count[j];
                next[l] = dp[j] + nextSum[l] + nextCount[l] * k;
                if(l > 0) {
                    next[l] = Math.min(next[l], next[l - 1]);
                }
            }
            dp = next;
        }
        return dp[n];
    }
}