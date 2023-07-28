class Solution {
    public long maxKelements(int[] nums, int k) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add((long)nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
    public int maximizeScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        long[] dp = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            dp[i] = Long.MIN_VALUE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= i; j++) {
                int l = j - 1;
                int r = i - j - 1;
                if (l >= 0 && r < n) {
                    dp[i] = Math.max(dp[i], dp[l] + multipliers[i - 1] * nums[l]);
                    dp[i] = Math.max(dp[i], dp[l + 1] + multipliers[i - 1] * nums[n - r - 1]);
                } else if (l >= 0) {
                    dp[i] = Math.max(dp[i], dp[l] + multipliers[i - 1] * nums[l]);
                } else if (r < n) {
                    dp[i] = Math.max(dp[i], dp[l + 1] + multipliers[i - 1] * nums[n - r - 1]);
                }
            }
        }
        long ans = Long.MIN_VALUE;
        for (int i = 0; i <= m; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return (int)ans;
    }
}