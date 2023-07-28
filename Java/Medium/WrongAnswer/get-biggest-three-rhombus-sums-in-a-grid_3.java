class Solution {
    public int[] getBiggestThree(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] prefix = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + grid[i-1][j-1];
            }
        }
        int[] res = new int[m*n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r = 1;
                while (i-r >= 0 && i+r < m && j-r >= 0 && j+r < n) {
                    int sum = prefix[i+r+1][j+r+1] - prefix[i+r+1][j-r] - prefix[i-r][j+r+1] + prefix[i-r][j-r];
                    res[idx++] = sum;
                    r++;
                }
            }
        }
        Arrays.sort(res, 0, idx);
        int[] ans = new int[3];
        int cnt = 0;
        for (int i = idx-1; i >= 0; i--) {
            if (cnt == 0 || res[i] != ans[cnt-1]) {
                ans[cnt++] = res[i];
                if (cnt == 3) break;
            }
        }
        return Arrays.copyOf(ans, cnt);
    }
}