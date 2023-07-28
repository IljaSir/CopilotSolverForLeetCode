class Solution {
    public int stoneGameV(int[] stoneValue) {
        
        int[] prefixSum = new int[stoneValue.length];
        prefixSum[0] = stoneValue[0];
        for (int i = 1; i < stoneValue.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + stoneValue[i];
        }
        return dfs(stoneValue, 0, stoneValue.length - 1, prefixSum, new int[500][500]);
    }

    private int dfs(int[] stoneValue, int start, int end, int[] prefixSum, int[][] memo) {
        if (start == end) {
            return 0;
        }
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        int sum = prefixSum[end] - (start == 0 ? 0 : prefixSum[start - 1]);
        int max = 0;
        for (int i = start; i < end; i++) {
            int leftSum = prefixSum[i] - (start == 0 ? 0 : prefixSum[start - 1]);
            int rightSum = sum - leftSum;
            if (leftSum > rightSum) {
                max = Math.max(max, rightSum + dfs(stoneValue, i + 1, end, prefixSum, memo));
            } else if (leftSum < rightSum) {
                max = Math.max(max, leftSum + dfs(stoneValue, start, i, prefixSum, memo));
            } else {
                max = Math.max(max, leftSum + Math.max(dfs(stoneValue, start, i, prefixSum, memo), dfs(stoneValue, i + 1, end, prefixSum, memo)));
            }
        }
        memo[start][end] = max;
        return max;
    }
}