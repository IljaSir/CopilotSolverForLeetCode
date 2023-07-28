class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] row: dp)
            Arrays.fill(row, 2);
        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < n; ++i)
            index.put(arr[i], i);

        int ans = 0;
        for (int k = 0; k < n; ++k)
            for (int j = k+1; j < n; ++j) {
                if (arr[j] - arr[k] < arr[k] && index.containsKey(arr[j] - arr[k]))
                    dp[k][j] = dp[index.get(arr[j]-arr[k])][k] + 1;
                ans = Math.max(ans, dp[k][j]);
            }

        return ans >= 3 ? ans : 0;
    }
}