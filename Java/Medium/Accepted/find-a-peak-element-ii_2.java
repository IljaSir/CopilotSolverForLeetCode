class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[2];
        int l = 0;
        int r = m - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int maxIndex = 0;
            for (int i = 0; i < n; i++) {
                if (mat[mid][i] > mat[mid][maxIndex]) {
                    maxIndex = i;
                }
            }
            if (mat[mid][maxIndex] > mat[mid + 1][maxIndex]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (mat[l][i] > mat[l][maxIndex]) {
                maxIndex = i;
            }
        }
        res[0] = l;
        res[1] = maxIndex;
        return res;
    }
}