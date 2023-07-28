class Solution {
    public int maxHeight(int[][] cuboids) {
        
        int n = cuboids.length;
        int[][] newCuboids = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.sort(cuboids[i]);
            newCuboids[i][0] = cuboids[i][0];
            newCuboids[i][1] = cuboids[i][1];
            newCuboids[i][2] = cuboids[i][2];
        }
        Arrays.sort(newCuboids, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });
        int[] dp = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = newCuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (newCuboids[j][1] <= newCuboids[i][1] && newCuboids[j][2] <= newCuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + newCuboids[i][2]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}