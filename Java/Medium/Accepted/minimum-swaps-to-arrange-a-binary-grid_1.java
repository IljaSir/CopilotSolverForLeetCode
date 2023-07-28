class Solution {
    public int minSwaps(int[][] grid) {
        
        int n = grid.length;
        int[] zeros = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    break;
                }
                count++;
            }
            zeros[i] = count;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (zeros[i] >= n - i - 1) {
                continue;
            }
            int j = i + 1;
            while (j < n && zeros[j] < n - i - 1) {
                j++;
            }
            if (j == n) {
                return -1;
            }
            res += j - i;
            while (j > i) {
                int tmp = zeros[j];
                zeros[j] = zeros[j - 1];
                zeros[j - 1] = tmp;
                j--;
            }
        }
        return res;
    }
}