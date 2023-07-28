class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        
        int n = candiesCount.length;
        long[] prefix = new long[n];
        prefix[0] = candiesCount[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + candiesCount[i];
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];
            long min = day + 1;
            long max = (long) (day + 1) * cap;
            long left = type == 0 ? 1 : prefix[type-1] + 1;
            long right = prefix[type];
            res[i] = !(min > right || max < left);
        }
        return res;
    }
}