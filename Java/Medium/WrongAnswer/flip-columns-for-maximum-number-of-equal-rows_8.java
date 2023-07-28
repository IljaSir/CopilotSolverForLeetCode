class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rows = new int[m];
        for (int i = 0; i < m; ++i) {
            int code = 0;
            for (int j = 0; j < n; ++j) {
                code = code * 2 + matrix[i][j];
            }
            rows[i] = code;
        }
        int max = 0;
        for (int i = 0; i < m; ++i) {
            int count = 0;
            for (int j = 0; j < m; ++j) {
                if (rows[i] == rows[j]) {
                    ++count;
                } else if (rows[i] == flip(rows[j])) {
                    ++count;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
    
    public int flip(int x) {
        int res = 0;
        while (x > 0) {
            res = res * 2 + x % 2 ^ 1;
            x /= 2;
        }
        return res;
    }
}