class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int width = 0;
            int height = 0;
            for (int j = i; j >= 1; j--) {
                width += books[j - 1][0];
                if (width > shelfWidth) {
                    break;
                }
                height = Math.max(height, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        return dp[n];
    }
}