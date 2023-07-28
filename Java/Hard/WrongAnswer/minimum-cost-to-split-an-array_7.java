class Solution {
    public int minCost(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] next = new int[n];
        return dp[n - 1] + k;
    }
}