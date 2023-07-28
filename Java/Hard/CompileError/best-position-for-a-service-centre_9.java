class Solution {
    public double getMinDistSum(int[][] positions) {
        
        double res = 0;
        double x = 50, y = 50;
        double step = 100;
        int n = positions.length;
        while (step > 1e-6) {
            double[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int idx = -1;
            double min = Double.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                double nx = x + dirs[i][0] * step;
                double ny = y + dirs[i][1] * step;
                double sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += getDist(nx, ny, positions[j][0], positions[j][1]);
                }
                if (sum < min) {
                    min = sum;
                    idx = i;
                }
            }
            x += dirs[idx][0] * step;
            y += dirs[idx][1] * step;
            step *= 0.999;
        }
        return min;
    }
}