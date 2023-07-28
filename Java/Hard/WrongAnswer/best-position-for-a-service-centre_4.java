class Solution {
    public double getMinDistSum(int[][] positions) {
        
        double res = Double.MAX_VALUE;
        double x = 0, y = 0;
        for (int i = 0; i < positions.length; i++) {
            x += positions[i][0];
            y += positions[i][1];
        }
        x /= positions.length;
        y /= positions.length;
        double step = 100;
        while (step > 1e-6) {
            double min = res;
            for (int i = 0; i < 4; i++) {
                double nx = x + step * (i % 2 == 0 ? 1 : -1);
                double ny = y + step * (i / 2 == 0 ? 1 : -1);
                double nres = 0;
                for (int j = 0; j < positions.length; j++) {
                    nres += Math.sqrt((nx - positions[j][0]) * (nx - positions[j][0]) + (ny - positions[j][1]) * (ny - positions[j][1]));
                }
                if (nres < min) {
                    res = nres;
                    x = nx;
                    y = ny;
                }
            }
            step /= 2;
        }
        return res;
    }
}