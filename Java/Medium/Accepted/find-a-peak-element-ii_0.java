class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int m = mat.length, n = mat[0].length;
        int lo = 0, hi = m - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int max = 0;
            for (int j = 1; j < n; ++j)
                if (mat[mid][j] > mat[mid][max])
                    max = j;
            if (mat[mid][max] < mat[mid + 1][max])
                lo = mid + 1;
            else
                hi = mid;
        }
        int max = 0;
        for (int j = 1; j < n; ++j)
            if (mat[lo][j] > mat[lo][max])
                max = j;
        return new int[]{lo, max};
    }
}