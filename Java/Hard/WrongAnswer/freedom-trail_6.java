class Solution {
    public int findRotateSteps(String ring, String key) {
        
        int[][] dp = new int[key.length() + 1][ring.length()];
        for (int i = 0; i <= key.length(); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= key.length(); i++) {
            for (int j = 0; j < ring.length(); j++) {
                if (ring.charAt(j) == key.charAt(i - 1)) {
                    for (int k = 0; k < ring.length(); k++) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, ring.length() - diff);
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + step);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            res = Math.min(res, dp[key.length()][i]);
        }
        return res + key.length();
    }
}