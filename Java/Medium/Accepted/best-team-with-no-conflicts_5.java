class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        
        int n = scores.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = ages[i];
            data[i][1] = scores[i];
        }
        Arrays.sort(data, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = data[i][1];
            for (int j = 0; j < i; j++) {
                if (data[i][1] >= data[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + data[i][1]);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}