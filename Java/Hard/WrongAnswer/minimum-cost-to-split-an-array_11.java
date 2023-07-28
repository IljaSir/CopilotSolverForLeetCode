class Solution {
    public int minCost(int[] nums, int k) {
        
        int n = nums.length;
        int[] freq = new int[n];
        for(int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        int[] unique = new int[n];
        int m = 0;
        for(int i = 0; i < n; i++) {
            if(freq[i] == 1) {
                unique[m++] = i;
            }
        }
        int[] dp = new int[n + 1];
        int[] sum = new int[n + 1];
        int[] count = new int[n + 1];
        for(int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
            count[i + 1] = count[i] + freq[nums[i]] - 1;
        }
        for(int i = 1; i <= m; i++) {
            int[] next = new int[n + 1];
            int[] nextSum = new int[n + 1];
            int[] nextCount = new int[n + 1];
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