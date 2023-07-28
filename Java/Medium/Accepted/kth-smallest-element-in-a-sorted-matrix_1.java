class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int c = count(matrix, mid);
            if (c < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int count(int[][] matrix, int x) {
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        int c = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= x) {
                c += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return c;
    }
}