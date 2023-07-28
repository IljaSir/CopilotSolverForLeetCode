class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int val = nums[i] - diff;
            int idx = Arrays.binarySearch(nums, 0, i, val);
            if (idx >= 0) {
                dp[i] = dp[idx] + 1;
            }
            ans += dp[i];
        }
        return ans;
    }
}