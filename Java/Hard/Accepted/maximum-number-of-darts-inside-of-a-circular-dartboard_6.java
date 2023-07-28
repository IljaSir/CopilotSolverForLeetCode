class Solution {
    public int numPoints(int[][] darts, int r) {
        
        int n = darts.length, ans = 1;
        double[][] dis = new double[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                dis[i][j] = dis[j][i] = Math.sqrt(Math.pow(darts[i][0] - darts[j][0], 2) + Math.pow(darts[i][1] - darts[j][1], 2));
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (dis[i][j] > 2 * r) continue;
                double x1 = darts[i][0], x2 = darts[j][0], y1 = darts[i][1], y2 = darts[j][1];
                double x0 = (x1 + x2) / 2 + (y1 - y2) * Math.sqrt(4 * r * r - dis[i][j] * dis[i][j]) / (2 * dis[i][j]);
                double y0 = (y1 + y2) / 2 + (x2 - x1) * Math.sqrt(4 * r * r - dis[i][j] * dis[i][j]) / (2 * dis[i][j]);
                int cnt = 0;
                for (int k = 0; k < n; ++k) {
                    if (Math.pow(darts[k][0] - x0, 2) + Math.pow(darts[k][1] - y0, 2) <= r * r + 1e-6) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}