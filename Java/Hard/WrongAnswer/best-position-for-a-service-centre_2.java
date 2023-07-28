class Solution {
    public double getMinDistSum(int[][] positions) {
        
        int n = positions.length;
        double x = 0, y = 0;
        for (int[] p : positions) {
            x += p[0];
            y += p[1];
        }
        x /= n;
        y /= n;

        double step = 100;
        double eps = 1e-6;
        while (step > eps) {
            int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] dir : dirs) {
                double nx = x + step * dir[0];
                double ny = y + step * dir[1];
                if (getDistSum(nx, ny, positions) < getDistSum(x, y, positions)) {
                    x = nx;
                    y = ny;
                }
            }
            step /= 2;
        }
        return getDistSum(x, y, positions);
    }

    private double getDistSum(double x, double y, int[][] positions) {
        double sum = 0;
        for (int[] p : positions) {
            sum += Math.sqrt((x - p[0]) * (x - p[0]) + (y - p[1]) * (y - p[1]));
        }
        return sum;
    }
}