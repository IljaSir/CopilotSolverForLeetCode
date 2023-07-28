class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[2];
        int l = 0;
        int r = m-1;
        while (l < r) {
            int mid = (l + r) / 2;
            int maxCol = 0;
            for (int i = 0; i < n; i++) {
                if (mat[mid][i] > mat[mid][maxCol]) {
                    maxCol = i;
                }
            }
            if (mat[mid][maxCol] < mat[mid+1][maxCol]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            if (mat[l][i] > mat[l][maxCol]) {
                maxCol = i;
            }
        }
        ans[0] = l;
        ans[1] = maxCol;
        return ans;
    }
}