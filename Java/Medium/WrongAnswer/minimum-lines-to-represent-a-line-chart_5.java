class Solution {
    public int minimumLines(int[][] stockPrices) {
        
        int n = stockPrices.length;
        int[] dp = new int[n];
        int len = 0;
        for (int[] stock : stockPrices) {
            int i = Arrays.binarySearch(dp, 0, len, stock[1]);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = stock[1];
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}