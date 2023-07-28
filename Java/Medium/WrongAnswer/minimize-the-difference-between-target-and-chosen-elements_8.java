class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] dp = new int[71];
        for (int i=0; i<71; i++) {
            dp[i] = 1000;
        }
        for (int i=0; i<n; i++) {
            dp[mat[0][i]] = 0;
        }
        for (int i=1; i<m; i++) {
            int[] newDp = new int[71];
            for (int j=0; j<71; j++) {
                newDp[j] = 1000;
            }
            for (int j=0; j<n; j++) {
                for (int k=0; k<71; k++) {
                    if (dp[k] != 1000) {
                        newDp[Math.abs(k-mat[i][j])] = Math.min(newDp[Math.abs(k-mat[i][j])], dp[k] + Math.abs(k-mat[i][j]));
                    }
                }
            }
            dp = newDp;
        }
        return dp[target];
    }
}