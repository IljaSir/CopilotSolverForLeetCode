class Solution {
    public int minSwaps(int[][] grid) {
        
        int n = grid.length;
        int[] rightMostZeros = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    rightMostZeros[i] = j;
                } else {
                    break;
                }
            }
        }
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (rightMostZeros[i] >= n - i - 1) {
                continue;
            }
            boolean found = false;
            for (int j = i + 1; j < n; j++) {
                if (rightMostZeros[j] >= n - i - 1) {
                    found = true;
                    for (int k = j; k > i; k--) {
                        int tmp = rightMostZeros[k];
                        rightMostZeros[k] = rightMostZeros[k - 1];
                        rightMostZeros[k - 1] = tmp;
                        swaps++;
                    }
                    break;
                }
            }
            if (!found) {
                return -1;
            }
        }
        return swaps;
    }
}