class Solution {
    public double getMinDistSum(int[][] positions) {
        
        double x = 0, y = 0, step = 100;
        for (int i = 0; i < 100; ++i, step /= 2) {
            double min = Double.MAX_VALUE;
            for (int j = 0; j < 4; ++j) {
                double nx = x + (j % 2 == 0 ? step : -step);
                double ny = y + (j / 2 == 0 ? step : -step);
                double sum = 0;
                for (int[] p : positions) {
                    sum += Math.sqrt(Math.pow(nx - p[0], 2) + Math.pow(ny - p[1], 2));
                }
                if (sum < min) {
                    min = sum;
                    x = nx;
                    y = ny;
                }
            }
        }
        return min;
    }
}