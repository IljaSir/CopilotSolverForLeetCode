class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        double[][] tower = new double[101][101];
        tower[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double q = (tower[i][j] - 1) / 2.0;
                if (q > 0) {
                    tower[i + 1][j] += q;
                    tower[i + 1][j + 1] += q;
                }
            }
        }
        return Math.min(1, tower[query_row][query_glass]);
    }
}