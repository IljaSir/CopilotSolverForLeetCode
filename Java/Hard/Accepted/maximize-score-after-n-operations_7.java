class Solution {
    public int maxScore(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][1 << n];
        return dfs(0, 0, nums, dp);
    }
    
    private int dfs(int idx, int used, int[] nums, int[][] dp) {
        if (idx == nums.length / 2) {
            return 0;
        }
        if (dp[idx][used] != 0) {
            return dp[idx][used];
        }
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((used & (1 << i)) == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if ((used & (1 << j)) == 0) {
                        max = Math.max(max, dfs(idx + 1, used | (1 << i) | (1 << j), nums, dp) + (idx + 1) * gcd(nums[i], nums[j]));
                    }
                }
            }
        }
        dp[idx][used] = max;
        return max;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}