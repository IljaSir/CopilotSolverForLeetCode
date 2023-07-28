class Solution {
    public int matrixScore(int[][] grid) {
        
        int M = grid.length, N = grid[0].length;
        int ans = 0;
        for (int i = 0; i < M; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        for (int j = 0; j < N; j++) {
            int c = 0;
            for (int i = 0; i < M; i++) {
                if (grid[i][j] == 1) {
                    c++;
                }
            }
            ans += Math.max(c, M - c) * (1 << (N - j - 1));
        }
        return ans;
    }
}