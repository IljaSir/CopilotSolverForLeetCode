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
            double min = getDistSum(positions, x, y);
            double nx = x, ny = y;
            if (getDistSum(positions, x + step, y) < min) {
                min = getDistSum(positions, nx = x + step, y);
            }
            if (getDistSum(positions, x - step, y) < min) {
                min = getDistSum(positions, nx = x - step, y);
            }
            if (getDistSum(positions, x, y + step) < min) {
                min = getDistSum(positions, x, ny = y + step);
            }
            if (getDistSum(positions, x, y - step) < min) {
                min = getDistSum(positions, x, ny = y - step);
            }
            x = nx;
            y = ny;
            step /= 2;
        }
        return getDistSum(positions, x, y);
    }

    public double getDistSum(int[][] positions, double x, double y) {
        double dist = 0;
        for (int[] p : positions) {
            dist += Math.sqrt((p[0] - x) * (p[0] - x) + (p[1] - y) * (p[1] - y));
        }
        return dist;
    }
}