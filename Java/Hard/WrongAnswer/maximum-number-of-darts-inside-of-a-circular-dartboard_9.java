class Solution {
    public int numPoints(int[][] darts, int r) {
        
        int n = darts.length;
        int[][][] c = new int[n][n][2];
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = darts[i][0], y1 = darts[i][1];
                int x2 = darts[j][0], y2 = darts[j][1];
                int dx = x2 - x1, dy = y2 - y1;
                int d2 = dx * dx + dy * dy;
                if (d2 > 4 * r * r) continue;
                double d = Math.sqrt(d2);
                double xm = (x1 + x2) / 2.0, ym = (y1 + y2) / 2.0;
                double k = Math.sqrt(r * r - d * d / 4) / d;
                int x = (int) (xm + dy * k + 0.5);
                int y = (int) (ym - dx * k + 0.5);
                c[i][j] = new int[]{x, y};
                c[j][i] = new int[]{x, y};
                int cnt = 0;
                for (int k1 = 0; k1 < n; k1++) {
                    int xk = darts[k1][0], yk = darts[k1][1];
                    int dxk = xk - x, dyk = yk - y;
                    if (dxk * dxk + dyk * dyk <= r * r) cnt++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}