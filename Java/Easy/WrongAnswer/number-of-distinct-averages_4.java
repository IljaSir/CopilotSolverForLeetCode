class Solution {
    public int distinctAverages(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(nums, 0, n - 1, dp);
    }
    
    private int dfs(int[] nums, int l, int r, int[][] dp) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return 1;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = l; i <= r; i++) {
            set.add(nums[i]);
        }
        int ans = set.size();
        for (int i = l; i < r; i++) {
            ans = Math.min(ans, dfs(nums, l, i, dp) + dfs(nums, i + 1, r, dp));
        }
        return dp[l][r] = ans;
    }
}