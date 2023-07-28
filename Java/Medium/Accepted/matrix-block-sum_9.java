class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int[][] ans = new int[mat.length][mat[0].length];
        int[][] sum = new int[mat.length][mat[0].length];
        int total = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                total += mat[i][j];
                if(i == 0 && j == 0){
                    sum[i][j] = mat[i][j];
                }else if(i == 0){
                    sum[i][j] = sum[i][j - 1] + mat[i][j];
                }else if(j == 0){
                    sum[i][j] = sum[i - 1][j] + mat[i][j];
                }else{
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i][j];
                }
            }
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                int x1 = Math.max(0, i - k);
                int y1 = Math.max(0, j - k);
                int x2 = Math.min(mat.length - 1, i + k);
                int y2 = Math.min(mat[0].length - 1, j + k);
                int sum1 = 0;
                int sum2 = 0;
                int sum3 = 0;
                if(x1 > 0){
                    sum1 = sum[x1 - 1][y2];
                }
                if(y1 > 0){
                    sum2 = sum[x2][y1 - 1];
                }
                if(x1 > 0 && y1 > 0){
                    sum3 = sum[x1 - 1][y1 - 1];
                }
                ans[i][j] = sum[x2][y2] - sum1 - sum2 + sum3;
            }
        }
        return ans;
    }
}