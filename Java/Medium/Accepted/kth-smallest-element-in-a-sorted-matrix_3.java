class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n-1][n-1];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] <= mid) {
                        cnt++;
                    }
                }
            }
            if (cnt < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}