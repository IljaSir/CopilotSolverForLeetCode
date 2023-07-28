class Solution {
    public double getMinDistSum(int[][] positions) {
        
        double x = 0, y = 0, step = 100;
        for (int i = 0; i < 100; ++i, step /= 2) {
            double[] d = new double[]{0, 0, 0, 0};
            for (int[] p : positions) {
                double dx = p[0] - x, dy = p[1] - y;
                d[0] += Math.abs(dx);
                d[1] += Math.abs(dy);
                d[2] += Math.abs(dx);
                d[3] += Math.abs(dy);
            }
            int k = 0;
            for (int j = 1; j < 4; ++j) {
                if (d[j] < d[k]) {
                    k = j;
                }
            }
            x += (k == 0 || k == 2) ? step : -step;
            y += (k == 1 || k == 2) ? step : -step;
        }
        double ans = 0;
        for (int[] p : positions) {
            ans += Math.sqrt(Math.pow(p[0] - x, 2) + Math.pow(p[1] - y, 2));
        }
        return ans;
    }
}