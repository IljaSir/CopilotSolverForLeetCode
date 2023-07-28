class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        
        int n = plants.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int water = capacity;
            while (j < n && water >= plants[j]) {
                water -= plants[j];
                j++;
            }
            dp[j] = Math.max(dp[j], dp[i] + j - i + Math.max(0, j - i - 1) * 2);
        }
        return dp[n];
    }
}