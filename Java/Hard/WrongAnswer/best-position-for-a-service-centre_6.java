class Solution {
    public double getMinDistSum(int[][] positions) {
        
        int n = positions.length;
        double x = 0, y = 0, step = 100;
        for (int i = 0; i < 100; i++) {
            double[] best = new double[] {x, y};
            for (int j = 0; j < 4; j++) {
                double nx = x + step * (j % 2 == 0 ? 1 : -1);
                double ny = y + step * (j < 2 ? 1 : -1);
                if (getDistSum(positions, nx, ny) < getDistSum(positions, best[0], best[1])) {
                    best[0] = nx;
                    best[1] = ny;
                }
            }
            x = best[0];
            y = best[1];
            step /= 2;
        }
        return getDistSum(positions, x, y);
    }

    private double getDistSum(int[][] positions, double x, double y) {
        double sum = 0;
        for (int[] p : positions) {
            sum += Math.sqrt((x - p[0]) * (x - p[0]) + (y - p[1]) * (y - p[1]));
        }
        return sum;
    }
}