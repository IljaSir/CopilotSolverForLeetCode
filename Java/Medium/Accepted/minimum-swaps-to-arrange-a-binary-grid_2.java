class Solution {
    public int minSwaps(int[][] grid) {
        
        int n = grid.length;
        int[] zeros = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            zeros[i] = count;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (n - i - 1 > zeros[i]) {
                int j = i;
                for (; j < n; j++) {
                    if (n - i - 1 <= zeros[j]) {
                        break;
                    }
                }
                if (j == n) {
                    return -1;
                }
                for (int k = j; k > i; k--) {
                    int temp = zeros[k];
                    zeros[k] = zeros[k - 1];
                    zeros[k - 1] = temp;
                    ans++;
                }
            }
        }
        return ans;
    }
}