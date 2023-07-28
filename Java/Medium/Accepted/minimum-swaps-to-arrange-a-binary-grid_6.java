class Solution {
    public int minSwaps(int[][] grid) {
        
        int n = grid.length;
        int[] zeroCount = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
                zeroCount[i]++;
            }
        }
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (zeroCount[i] < n - i - 1) {
                int j;
                for (j = i + 1; j < n; j++) {
                    if (zeroCount[j] >= n - i - 1) {
                        break;
                    }
                }
                if (j == n) {
                    return -1;
                }
                while (j > i) {
                    int tmp = zeroCount[j];
                    zeroCount[j] = zeroCount[j - 1];
                    zeroCount[j - 1] = tmp;
                    j--;
                    swaps++;
                }
            }
        }
        return swaps;
    }
}