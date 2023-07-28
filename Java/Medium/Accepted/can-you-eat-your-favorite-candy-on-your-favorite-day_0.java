class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        
        long[] prefixSum = new long[candiesCount.length];
        prefixSum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + candiesCount[i];
        }
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int favoriteType = queries[i][0];
            int favoriteDay = queries[i][1];
            int dailyCap = queries[i][2];
            long minCandies = favoriteDay + 1;
            long maxCandies = (long) (favoriteDay + 1) * dailyCap;
            long minPrefixSum = favoriteType == 0 ? 1 : prefixSum[favoriteType - 1] + 1;
            long maxPrefixSum = prefixSum[favoriteType];
            result[i] = !(minCandies > maxPrefixSum || maxCandies < minPrefixSum);
        }
        return result;
    }
}