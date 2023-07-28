class Solution {
    public double getMinDistSum(int[][] positions) {
        
        double x = 0, y = 0;
        for (int[] p : positions) {
            x += p[0];
            y += p[1];
        }
        x /= positions.length;
        y /= positions.length;
        double step = 100, eps = 1e-6;
        while (step > eps) {
            double[] d = new double[4];
            for (int[] p : positions) {
                double dx = p[0] - x, dy = p[1] - y;
                d[0] += dx;
                d[1] += dy;
                d[2] += dx * dx + dy * dy;
            }
            if (d[0] > 0) x += step;
            if (d[0] < 0) x -= step;
            if (d[1] > 0) y += step;
            if (d[1] < 0) y -= step;
            step *= 0.999;
        }
        return Math.sqrt(d[2]);
    }
}