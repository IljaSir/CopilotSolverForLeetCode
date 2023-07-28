class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        
        int n = garbage.length;
        int[] dp = new int[3];
        int[] next = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                next[j] = dp[j] + travel[i];
            }
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    if (garbage[i].indexOf("MGP".charAt(k)) != -1) {
                        next[k] = Math.min(next[k], dp[j]);
                    }
                }
            }
            int[] tmp = dp;
            dp = next;
            next = tmp;
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}