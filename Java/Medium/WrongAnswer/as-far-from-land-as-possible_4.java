class Solution {
    public int maxDistance(int[][] grid) {
        
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int[] row: dist)
            Arrays.fill(row, n + n);
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == 1)
                    dist[i][j] = 0;

        for (int k = 0; k < n + n; ++k)
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    if (dist[i][j] > k)
                        if (i > 0 && dist[i-1][j] == k) dist[i][j] = k + 1;
                        else if (i+1 < n && dist[i+1][j] == k) dist[i][j] = k + 1;
                        else if (j > 0 && dist[i][j-1] == k) dist[i][j] = k + 1;
                        else if (j+1 < n && dist[i][j+1] == k) dist[i][j] = k + 1;

        int ans = -1;
        for (int[] row: dist)
            for (int v: row)
                if (v < n + n)
                    ans = Math.max(ans, v);
        return ans;
    }
}