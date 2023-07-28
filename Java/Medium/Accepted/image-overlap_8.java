class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        
        int n = img1.length;
        int[][] dp = new int[2*n+1][2*n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            if (img2[k][l] == 1) {
                                dp[k-i+n][l-j+n]++;
                            }
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < 2*n+1; i++) {
            for (int j = 0; j < 2*n+1; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}