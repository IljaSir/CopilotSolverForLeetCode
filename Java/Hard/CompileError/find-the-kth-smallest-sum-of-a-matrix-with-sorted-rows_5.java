class Solution {
    public int kthSmallest(int[][] mat, int k) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            int[] tmp = new int[n * m];
            int idr (int j = 0; j < n; j++) {
                    next[i] = sum[i] - mat[i][0] + mat[i][j];
                    min = Math.min(min, next[i]);
                }
            }
            sum = next;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            res += sum[i];
        }
        return res;
    }
}