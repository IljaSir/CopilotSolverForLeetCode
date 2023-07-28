class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        
        int[] dp = new int[books.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < books.length; i++) {
            int width = 0, height = 0;
            for (int j = i; j < books.length; j++) {
                width += books[j][0];
                height = Math.max(height, books[j][1]);
                if (width > shelfWidth) {
                    break;
                }
                dp[j + 1] = Math.min(dp[j + 1], dp[i] + height);
            }
        }
        return dp[books.length];
    }
}