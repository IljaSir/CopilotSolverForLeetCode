class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        
        int[] dp = new int[books.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= books.length; i++) {
            int width = 0;
            int height = 0;
            for (int j = i - 1; j >= 0; j--) {
                width += books[j][0];
                if (width > shelfWidth) {
                    break;
                }
                height = Math.max(height, books[j][1]);
                dp[i] = Math.min(dp[i], dp[j] + height);
            }
        }
        return dp[books.length];
    }
}