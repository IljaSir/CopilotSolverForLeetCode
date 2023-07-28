class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        
        boolean[] result = new boolean[queries.length];
        long[] candiesCountSum = new long[candiesCount.length];
        candiesCountSum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            candiesCountSum[i] = candiesCountSum[i - 1] + candiesCount[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];
            long min = (long) day + 1;
            long max = (long) (day + 1) * cap;
            if (type == 0) {
                result[i] = max >= 1;
            } else {
                result[i] = max >= candiesCountSum[type - 1] + 1 && min <= candiesCountSum[type];
            }
        }
        return result;
    }
}