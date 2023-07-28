class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < m; ++i) {
                if (matrix[i][j] == 0) {
                    break;
                }
                ++heights[j];
            }
        }
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            int[] order = new int[n];
            for (int k = 0; k < n; ++k) {
                order[k] = k;
            }
            Arrays.sort(order, (u, v) -> Integer.compare(heights[u], heights[v]));
            int width = 0;
            for (int k = 0; k < n; ++k) {
                int col = order[k];
                ++width;
                if (width * heights[col] <= ans) {
                    break;
                }
                ans = Math.max(ans, width * heights[col]);
            }
        }
        return ans;
    }
}