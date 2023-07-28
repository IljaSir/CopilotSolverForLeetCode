class Solution {
    public long minimumDifference(int[] nums) {
        
        int n = nums.length / 3;
        int[] sum = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, solve(sum, i, n));
        }
        return ans;
    }

    long solve(int[] sum, int i, int n) {
        long ans = Long.MAX_VALUE;
        for (int j = 0; j <= n; j++) {
            int x = sum[i + j] - sum[i];
            int y = sum[sum.length - 1] - sum[i + j] + sum[i];
            ans = Math.min(ans, Math.abs(x - y));
        }
        return ans;
    }
}