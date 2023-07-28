class Solution {
    public int numSubmat(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    dp[i][j] = j > 0 ? dp[i][j-1] + 1 : 1;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int minWidth = Integer.MAX_VALUE;
                for(int k = i; k >= 0; k--){
                    minWidth = Math.min(minWidth, dp[k][j]);
                    res += minWidth;
                }
            }
        }
        return res;
    }
}