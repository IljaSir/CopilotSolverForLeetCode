class Solution {
    public int minSwaps(int[][] grid) {
        
        int n = grid.length;
        int[] zeros = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
                count++;
            }
            zeros[i] = count;
        }
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (zeros[i] >= n - i - 1) {
                continue;
            }
            int j = i + 1;
            for (; j < n; j++) {
                if (zeros[j] >= n - i - 1) {
                    break;
                }
            }
            if (j == n) {
                return -1;
            }
            swaps += j - i;
            for (; j > i; j--) {
                zeros[j] = zeros[j - 1];
            }
        }
        return swaps;
    }
}