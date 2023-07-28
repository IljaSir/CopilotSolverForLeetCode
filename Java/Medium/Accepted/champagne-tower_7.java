class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        double[][] glass = new double[101][101];
        glass[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double flow = (glass[i][j] - 1.0) / 2.0;
                if (flow > 0) {
                    glass[i + 1][j] += flow;
                    glass[i + 1][j + 1] += flow;
                }
            }
        }
        return Math.min(1, glass[query_row][query_glass]);
    }
}