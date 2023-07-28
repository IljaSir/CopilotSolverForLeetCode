class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        
        int n = tiles.length;
        Arrays.sort(tiles, (a, b) -> Integer.compare(a[0], b[0]));
        int[] dp = new int[n];
        int[] pre = new int[n];
        int[] next = new int[n];
        int[] sum = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || tiles[i][0] > tiles[i - 1][1] + 1) {
                pre[i] = tiles[i][0];
            } else {
                pre[i] = pre[i - 1];
            }
            if (i == n - 1 || tiles[i][1] < tiles[i + 1][0] - 1) {
                next[i] = tiles[i][1];
            } else {
                next[i] = next[i + 1];
            }
            sum[i] = next[i] - pre[i] + 1;
            ans = Math.max(ans, sum[i]);
        }
        for (int i = 0; i < n; i++) {
            if (i == 0 || tiles[i][0] > tiles[i - 1][1] + 1) {
                dp[i] = sum[i];
            } else {
                dp[i] = sum[i] + dp[i - 1];
            }
            if (i == n - 1 || tiles[i][1] < tiles[i + 1][0] - 1) {
                int j = i;
                while (j >= 0 && tiles[i][0] - tiles[j][0] + 1 <= carpetLen) {
                    int cur = sum[i];
                    if (j > 0) {
                        cur += dp[j - 1];
                    }
                    if (i < n - 1 && tiles[i][1] < tiles[i + 1][0] - 1) {
                        cur += sum[i + 1];
                    }
                    ans = Math.max(ans, cur);
                    j--;
                }
            }
        }
        return ans;
    }
}