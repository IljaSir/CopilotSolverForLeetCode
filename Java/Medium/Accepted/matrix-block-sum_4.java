class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int sum = 0;
                for (int x = i - k; x <= i + k; x++) {
                    for (int y = j - k; y <= j + k; y++) {
                        if (x >= 0 && x < mat.length && y >= 0 && y < mat[i].length) {
                            sum += mat[x][y];
                        }
                    }
                }
                ans[i][j] = sum;
            }
        }
        return ans;
    }
}