class Solution {
    public int minimumLines(int[][] stockPrices) {
        
        int n = stockPrices.length;
        int[] dp = new int[n + 1];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int p = Arrays.binarySearch(dp, 0, ans, stockPrices[i][1]);
            if (p < 0) p = -p - 1;
            dp[p] = stockPrices[i][1];
            if (p == ans) ++ans;
        }
        return ans;
    }
}