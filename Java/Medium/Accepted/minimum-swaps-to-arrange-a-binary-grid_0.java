class Solution {
    public int minSwaps(int[][] grid) {
        
        int n = grid.length;
        int[] zeros = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    zeros[i]++;
                } else {
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (zeros[i] >= n - i - 1) {
                continue;
            }
            boolean found = false;
            for (int j = i + 1; j < n; j++) {
                if (zeros[j] >= n - i - 1) {
                    ans += j - i;
                    while (j > i) {
                        zeros[j] = zeros[j - 1];
                        j--;
                    }
                    zeros[i] = n - i - 1;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return -1;
            }
        }
        return ans;
    }
}