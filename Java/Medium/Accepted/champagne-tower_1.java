class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        double[][] glasses = new double[101][101];
        glasses[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (glasses[i][j] > 1) {
                    double overflow = (glasses[i][j] - 1) / 2;
                    glasses[i + 1][j] += overflow;
                    glasses[i + 1][j + 1] += overflow;
                }
            }
        }
        return Math.min(1, glasses[query_row][query_glass]);
    }
}