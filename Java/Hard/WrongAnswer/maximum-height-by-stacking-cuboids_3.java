class Solution {
    public int maxHeight(int[][] cuboids) {
        
        int n = cuboids.length;
        for (int i = 0; i < n; i++) {
            Arrays.sort(cuboids[i]);
        }
        Arrays.sort(cuboids, (a, b) -> a[0] == b[0] ? (a[1] == b[1] ? b[2] - a[2] : b[1] - a[1]) : a[0] - b[0]);
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}