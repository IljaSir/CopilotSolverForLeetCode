class Solution {
    public int maxHeight(int[][] cuboids) {
        
        int n = cuboids.length;
        for (int[] c : cuboids) {
            Arrays.sort(c);
        }
        Arrays.sort(cuboids, (a, b) -> a[2] - b[2]);
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}