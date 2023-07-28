class Solution {
    public int minStickers(String[] stickers, String target) {
        
        int n = stickers.length;
        int[][] map = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char c: stickers[i].toCharArray()) {
                map[i][c - 'a']++;
            }
        }
        int[] dp = new int[1 << target.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int state = 0; state < (1 << target.length()); state++) {
            if (dp[state] == Integer.MAX_VALUE) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                int now = state;
                for (char c: stickers[i].toCharArray()) {
                    for (int j = 0; j < target.length(); j++) {
                        if (((now >> j) & 1) == 0 && c == target.charAt(j)) {
                            now |= (1 << j);
                            break;
                        }
                    }
                }
                dp[now] = Math.min(dp[now], dp[state] + 1);
            }
        }
        return dp[(1 << target.length()) - 1] == Integer.MAX_VALUE ? -1 : dp[(1 << target.length()) - 1];
    }
}