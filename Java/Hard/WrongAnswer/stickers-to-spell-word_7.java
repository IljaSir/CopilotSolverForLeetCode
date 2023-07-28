class Solution {
    public int minStickers(String[] stickers, String target) {
        
        int n = stickers.length;
        int[][] dp = new int[1 << target.length()][target.length()];
        for (int[] d : dp)
            Arrays.fill(d, Integer.MAX_VALUE / 2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < target.length(); j++) {
                if (stickers[i].indexOf(target.charAt(j)) != -1) {
                    dp[1 << j][j] = 1;
                }
            }
        }
        for (int state = 0; state < (1 << target.length()); state++) {
            int[] f = new int[target.length()];
            for (int i = 0; i < target.length(); i++) {
                f[i] = dp[state][i];
                for (int s = state; s != 0; s = (s - 1) & state) {
                    f[i] = Math.min(f[i], dp[s][i] + dp[state - s][i]);
                }
            }
            for (int i = 0; i < target.length(); i++) {
                dp[state][i] = f[i];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < target.length(); i++) {
            ans = Math.min(ans, dp[(1 << target.length()) - 1][i]);
        }
        return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}