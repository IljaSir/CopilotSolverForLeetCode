class Solution {
    public double getMinDistSum(int[][] positions) {
        
        double x = 0, y = 0, step = 100;
        for (int i = 0; i < 100; ++i) {
            int[] best = null;
            for (int[] p : positions) {
                if (best == null || dist(x, y, p) < dist(x, y, best))
                    best = p;
            }
            x += step * (best[0] - x);
            y += step * (best[1] - y);
            step *= 0.99;
        }
        return dist(x, y, positions);
    }

    public double dist(double x, double y, int[][] positions) {
        double sum = 0;
        for (int[] p : positions)
            sum += dist(x, y, p);
        return sum;
    }
}