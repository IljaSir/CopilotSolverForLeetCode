class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        
        int[][] dp = new int[garbage.length][3];
        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = garbage[0].length() - garbage[0].replace("M", "").length();
        dp[0][1] = garbage[0].length() - garbage[0].replace("P", "").length();
        dp[0][2] = garbage[0].length() - garbage[0].replace("G", "").length();
        for (int i = 1; i < garbage.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + travel[i - 1] + garbage[i].length() - garbage[i].replace(garbage[i].substring(j, j + 1), "").length());
                }
            }
        }
        return Math.min(dp[garbage.length - 1][0], Math.min(dp[garbage.length - 1][1], dp[garbage.length - 1][2]));
    }
}