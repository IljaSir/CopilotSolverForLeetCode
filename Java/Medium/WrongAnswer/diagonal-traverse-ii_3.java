class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        int n = nums.size();
        int m = 0;
        for (List<Integer> list : nums) {
            m = Math.max(m, list.size());
        }
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                grid[i][j] = nums.get(i).get(j);
            }
        }
        int[] ans = new int[n * m];
        int idx = 0;
        for (int i = 0; i < n + m - 1; i++) {
            if (i % 2 == 0) {
                for (int j = Math.min(i, n - 1); j >= 0; j--) {
                    int k = i - j;
                    if (k >= m) {
                        break;
                    }
                    ans[idx++] = grid[j][k];
                }
            } else {
                for (int j = 0; j <= Math.min(i, n - 1); j++) {
                    int k = i - j;
                    if (k >= m) {
                        break;
                    }
                    ans[idx++] = grid[j][k];
                }
            }
        }
        return ans;
    }
}