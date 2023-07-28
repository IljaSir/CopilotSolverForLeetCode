class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        
        int n = books.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int width = 0, height = 0;
            for (int j = i; j < n; j++) {
                width += books[j][0];
                if (width > shelfWidth) break;
                height = Math.max(height, books[j][1]);
                dp[j+1] = Math.min(dp[j+1], dp[i] + height);
            }
        }
        return dp[n];
    }
}