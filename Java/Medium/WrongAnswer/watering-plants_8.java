class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        
        int n = plants.length;
        int[] dp = new int[n];
        int cur = 0;
        for (int i = 1; i < n; i++) {
            if (cur + plants[i - 1] < plants[i]) {
                int diff = plants[i] - cur - plants[i - 1];
                dp[i] = dp[i - 1] + diff + 2 * i;
                cur = capacity - diff;
            } else {
                dp[i] = dp[i - 1] + 2 * i;
                cur = cur + plants[i - 1] - plants[i];
            }
        }
        return dp[n - 1] + n;
    }
}