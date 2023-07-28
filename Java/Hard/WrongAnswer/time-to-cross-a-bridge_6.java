class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        
        int[][] dp = new int[k][n];
        for(int i=0; i<k; i++) {
            dp[i][0] = time[i][0] + time[i][2];
        }
        for(int j=1; j<n; j++) {
            for(int i=0; i<k; i++) {
                dp[i][j] = dp[i][j-1] + time[i][1] + time[i][2] + time[i][3];
                for(int p=0; p<k; p++) {
                    if(i != p) {
                        dp[i][j] = Math.max(dp[i][j], dp[p][j-1] + time[p][1] + time[i][0] + time[i][2] + time[i][3]);
                    }
                }
            }
        }
        int max = 0;
        for(int i=0; i<k; i++) {
            max = Math.max(max, dp[i][n-1]);
        }
        return max;
    }
}