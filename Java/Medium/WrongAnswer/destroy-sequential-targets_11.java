class Solution {
    public int destroyTargets(int[] nums, int space) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] next = new int[n];
        for (int i = 0; i < n; ++i) {
            next[i] = Arrays.binarySearch(nums, nums[i] + space);
            if (next[i] < 0) {
                next[i] = ~next[i];
            }
        }
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = Math.max(dp[i + 1], dp[next[i]] + next[i] - i);
        }
        return n - dp[0];
    }
}