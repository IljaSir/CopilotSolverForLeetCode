class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 1, j = 1; i <= n; i++) {
            while (j <= n && sum[j] - sum[i - 1] == j - i + 1) {
                j++;
            }
            ans = Math.max(ans, sum[j - 1] - sum[i - 1]);
        }
        return ans;
    }
}