class Solution {
    public double getMinDistSum(int[][] positions) {
        
        double x = 0, y = 0, step = 100;
        for (int i = 0; i < 100; i++) {
            double[][] sums = {{x - step, y}, {x + step, y}, {x, y - step}, {x, y + step}};
            double min = Double.MAX_VALUE;
            for (double[] sum : sums) {
                double sumDist = 0;
                for (int[] position : positions) {
                    sumDist += getDistance(sum, position);
                }
                if (sumDist < min) {
                    min = sumDist;
                    x = sum[0];
                    y = sum[1];
                }
            }
            step /= 2;
        }
        return min;
    }
}