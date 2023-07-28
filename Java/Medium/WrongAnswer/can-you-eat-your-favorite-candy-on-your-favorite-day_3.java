class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        
        int n = candiesCount.length;
        long[] sum = new long[n];
        sum[0] = candiesCount[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];
            long x1 = day + 1;
            long y1 = (day + 1) * cap;
            long x2 = type == 0 ? 1 : sum[type - 1] + 1;
            long y2 = sum[type];
            res[i] = !(x1 > y2 || y1 < x2);
        }
        return res;
    }
}