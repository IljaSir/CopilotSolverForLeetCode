class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
        int n = nums.length;
        int[] count = new int[200001];
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + nums[i];
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            int l = lower - sum[i], r = upper - sum[i];
            if (l <= 0 && r >= 0) {
                ans += count[100000];
            }
            if (l > 0) {
                ans += count[100000 + l];
            }
            if (r < 0) {
                ans += count[100000 + r + 1];
            }
            ++count[sum[i] + 100000];
        }
        return ans;
    }
}