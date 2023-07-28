class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        double[] res = new double[100];
        res[0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = i; j >= 0; j--) {
                res[j + 1] += Math.max(0, (res[j] - 1) / 2);
                res[j] = Math.max(0, (res[j] - 1) / 2);
            }
        }
        return Math.min(1, res[query_glass]);
    }
}