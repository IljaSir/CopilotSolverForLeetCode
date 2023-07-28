class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        int[] ans = new int[2];
        int left = 0;
        int right = m - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (mat[i][mid] > mat[max][mid]) {
                    max = i;
                }
            }
            if (mid > 0 && mat[max][mid - 1] > mat[max][mid]) {
                right = mid - 1;
            } else if (mid < m - 1 && mat[max][mid + 1] > mat[max][mid]) {
                left = mid + 1;
            } else {
                ans[0] = max;
                ans[1] = mid;
                break;
            }
        }
        return ans;
    }
}