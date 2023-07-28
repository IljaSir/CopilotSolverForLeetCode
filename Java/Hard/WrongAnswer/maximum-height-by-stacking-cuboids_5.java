class Solution {
    public int maxHeight(int[][] cuboids) {
        
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids, (a, b) -> a[0] - b[0]);
        int[] dp = new int[cuboids.length];
        for (int i = 0; i < cuboids.length; i++) {
            dp[i] = cuboids[i][2];
        }
        int max = 0;
        for (int i = 1; i < cuboids.length; i++) {
            for (int j = 0; j < i; j++) {
                if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}