class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        
        long[] preSum = new long[candiesCount.length];
        preSum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            preSum[i] = preSum[i - 1] + candiesCount[i];
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];
            long min = day + 1;
            long max = (long) (day + 1) * cap;
            long minEat = type == 0 ? 1 : preSum[type - 1] + 1;
            long maxEat = preSum[type];
            ans[i] = !(min > maxEat || max < minEat);
        }
        return ans;
    }
}