class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        
        int n = nums.length;
        int[][] dp = new int[n][1001];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(nums, start, goal, 0, dp);
    }
    
    private int dfs(int[] nums, int start, int goal, int index, int[][] dp) {
        if (start < 0 || start > 1000) {
            return Integer.MAX_VALUE;
        }
        if (index == nums.length) {
            return start == goal ? 0 : Integer.MAX_VALUE;
        }
        if (dp[index][start] != -1) {
            return dp[index][start];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int newStart = start;
            if (i == 0) {
                newStart += nums[index];
            } else if (i == 1) {
                newStart -= nums[index];
            } else {
                newStart ^= nums[index];
            }
            int count = dfs(nums, newStart, goal, index + 1, dp);
            if (count != Integer.MAX_VALUE) {
                res = Math.min(res, 1 + count);
            }
        }
        return dp[index][start] = res;
    }
}