class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[2];
        int start = 0;
        int end = m - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            int max = 0;
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (mat[mid][j] > max) {
                    max = mat[mid][j];
                    index = j;
                }
            }
            if (mat[mid][index] > mat[mid - 1][index] && mat[mid][index] > mat[mid + 1][index]) {
                result[0] = mid;
                result[1] = index;
                break;
            } else if (mat[mid][index] < mat[mid - 1][index]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}