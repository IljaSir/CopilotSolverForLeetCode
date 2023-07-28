class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] - target[i];
        }
        return sum;
    }

    public int minOperations(int[] nums, int[] target) {
        int n = nums.length;
        int m = target.length;
        int max = n + m;
        int min = Math.abs(max - 2 * Math.min(n, m));
        long diff = makeSimilar(nums, target);
        if (diff < min || diff > max || (diff & 1) != 0) {
            return -1;
        }
        int half = (max + min) / 2;
        long[][] dp = new long[2][half + 1];
        for (int i = 0; i <= half; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= half; j++) {
                dp[(i + 1) & 1][j] = dp[i & 1][j];
            }
            for (int j = 0; j <= half; j++) {
                int k = j + nums[i];
                if (k <= half) {
                    dp[(i + 1) & 1][k] = Math.max(dp[(i + 1) & 1][k], dp[i & 1][j] + nums[i]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= half; j++) {
            int k = j + (int) diff;
            if (k <= half) {
                ans = Math.min(ans, n - (int) (dp[n & 1][j] + dp[n & 1][k]) / 2);
            }
        }
        return ans;
    }
}