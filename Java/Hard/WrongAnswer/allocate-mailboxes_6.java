class Solution {
    public int minDistance(int[] houses, int k) {
        
        Arrays.sort(houses);
        int n = houses.length;
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(houses, 0, k, dp);
    }

    private int dfs(int[] houses, int index, int k, int[][] dp) {
        if (k == 0 && index == houses.length) {
            return 0;
        }
        if (k == 0 || index == houses.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[index][k] != -1) {
            return dp[index][k];
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int median = 0;
        for (int i = index; i < houses.length; i++) {
            sum += houses[i];
            median = sum / (i - index + 1);
            int left = houses[i] * (i - index + 1) - sum;
            int right = sum - houses[index] * (i - index + 1);
            int cost = left + right;
            int next = dfs(houses, i + 1, k - 1, dp);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, cost + next);
            }
        }
        dp[index][k] = min;
        return min;
    }
}