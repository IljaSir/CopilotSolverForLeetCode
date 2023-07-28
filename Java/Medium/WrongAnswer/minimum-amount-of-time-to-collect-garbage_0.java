class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        
        int[] metal = new int[garbage.length];
        int[] paper = new int[garbage.length];
        int[] glass = new int[garbage.length];
        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'M') {
                    metal[i]++;
                } else if (garbage[i].charAt(j) == 'P') {
                    paper[i]++;
                } else {
                    glass[i]++;
                }
            }
        }
        int[][] dp = new int[3][garbage.length];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = metal[0] * 1;
        dp[1][0] = paper[0] * 1;
        dp[2][0] = glass[0] * 1;
        for (int i = 1; i < garbage.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[j][i] = dp[j][i - 1] + travel[i - 1];
            }
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[j][i] = Math.min(dp[j][i], dp[k][i - 1] + travel[i - 1] + metal[i] * 1);
                    dp[j][i] = Math.min(dp[j][i], dp[k][i - 1] + travel[i - 1] + paper[i] * 1);
                    dp[j][i] = Math.min(dp[j][i], dp[k][i - 1] + travel[i - 1] + glass[i] * 1);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, dp[i][garbage.length - 1]);
        }
        return ans;
    }
}