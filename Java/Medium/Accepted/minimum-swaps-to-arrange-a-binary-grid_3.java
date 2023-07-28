class Solution {
    public int minSwaps(int[][] grid) {
        
        int n = grid.length;
        int[] zeros = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            zeros[i] = count;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (zeros[i] >= n - i - 1) continue;
            boolean found = false;
            for (int j = i + 1; j < n; j++) {
                if (zeros[j] >= n - i - 1) {
                    found = true;
                    ans += j - i;
                    for (int k = j; k > i; k--) {
                        zeros[k] = zeros[k - 1];
                    }
                    zeros[i] = n - i - 1;
                    break;
                }
            }
            if (!found) return -1;
        }
        return ans;
    }
}