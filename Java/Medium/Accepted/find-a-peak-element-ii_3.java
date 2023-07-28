class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[2];
        int l = 0;
        int r = m - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < n; i++) {
                if (mat[mid][i] > max) {
                    max = mat[mid][i];
                    maxIndex = i;
                }
            }
            if (mat[mid][maxIndex] > mat[mid + 1][maxIndex]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        ans[0] = l;
        ans[1] = 0;
        for (int i = 0; i < n; i++) {
            if (mat[l][i] > mat[l][ans[1]]) {
                ans[1] = i;
            }
        }
        return ans;
    }
}