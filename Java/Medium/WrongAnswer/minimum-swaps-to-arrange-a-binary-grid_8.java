class Solution {
    public int minSwaps(int[][] grid) {
        
        int n = grid.length;
        int[] lastZero = new int[n];
        for (int i = 0; i < n; i++) {
            int j = n - 1;
            while (j >= 0 && grid[i][j] == 0) {
                j--;
            }
            lastZero[i] = j;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (lastZero[i] >= n - i - 1) {
                continue;
            }
            int j = i + 1;
            while (j < n && lastZero[j] < n - i - 1) {
                j++;
            }
            if (j == n) {
                return -1;
            }
            while (j > i) {
                int temp = lastZero[j];
                lastZero[j] = lastZero[j - 1];
                lastZero[j - 1] = temp;
                j--;
                res++;
            }
        }
        return res;
    }
}