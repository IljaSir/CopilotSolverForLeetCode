class Solution {
    public int numPoints(int[][] darts, int r) {
        
        int n = darts.length;
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = darts[i][0], y1 = darts[i][1], x2 = darts[j][0], y2 = darts[j][1];
                if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) > 4 * r * r) {
                    continue;
                }
                int x0 = (x1 + x2) / 2, y0 = (y1 + y2) / 2;
                double d = Math.sqrt(r * r - ((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0)));
                double x3 = x0 + d * (y1 - y0) / Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
                double y3 = y0 - d * (x1 - x0) / Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
                double x4 = x0 - d * (y1 - y0) / Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
                double y4 = y0 + d * (x1 - x0) / Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    int x = darts[k][0], y = darts[k][1];
                    if ((x - x3) * (x - x3) + (y - y3) * (y - y3) <= r * r) {
                        cnt++;
                    }
                    if ((x - x4) *
    }
}