class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[2];
        int l = 0;
        int r = m - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int maxIdx = 0;
            for (int i = 0; i < n; i++) {
                if (mat[mid][i] > mat[mid][maxIdx]) {
                    maxIdx = i;
                }
            }
            if (mid == 0 || mat[mid][maxIdx] > mat[mid - 1][maxIdx]) {
                if (mid == m - 1 || mat[mid][maxIdx] > mat[mid + 1][maxIdx]) {
                    res[0] = mid;
                    res[1] = maxIdx;
                    return res;
                } else {
                    l = mid + 1;
                }
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}