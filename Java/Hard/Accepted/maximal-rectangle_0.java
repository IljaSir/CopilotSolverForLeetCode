class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[] heights = new int[n];
        int[] lefts = new int[n];
        int[] rights = new int[n];
        Arrays.fill(rights, n);
        int max = 0;
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                    lefts[j] = Math.max(lefts[j], left);
                } else {
                    heights[j] = 0;
                    lefts[j] = 0;
                    left = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    rights[j] = Math.min(rights[j], right);
                } else {
                    rights[j] = n;
                    right = j;
                }
            }
            for (int j = 0; j < n; j++) {
                max = Math.max(max, (rights[j] - lefts[j]) * heights[j]);
            }
        }
        return max;
    }
}