class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
        int n = tiles.length;
        int[][] dp = new int[n][2];
        dp[0][0] = tiles[0][1] - tiles[0][0] + 1;
        dp[0][1] = tiles[0][1] - tiles[0][0] + 1;
        for (int i = 1; i < n; i++) {
            int[] tile = tiles[i];
            int l = tile[0], r = tile[1];
            dp[i][0] = r - l + 1;
            dp[i][1] = r - l + 1;
            int j = Arrays.binarySearch(tiles, new int[]{l - carpetLen, 0}, (a, b) -> a[0] - b[0]);
            if (j >= 0) {
                dp[i][0] = Math.max(dp[i][0], dp[j][0] + r - l + 1);
            } else {
                j = -j - 2;
                if (j >= 0) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + r - l + 1);
                }
            }
            j = Arrays.binarySearch(tiles, new int[]{l - carpetLen + 1, 0}, (a, b) -> a[0] - b[0]);
            if (j >= 0) {
                dp[i][1] = Math.max(dp[i][1], dp[j][0] + r - l + 1);
            } else {
                j = -j - 2;
                if (j >= 0) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + r - l + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i][0]);
            ans = Math.max(ans, dp[i][1]);
        }
        return ans;
    }
}