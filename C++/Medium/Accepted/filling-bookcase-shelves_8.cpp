class Solution {
public:
    int minHeightShelves(vector<vector<int>>& books, int shelfWidth) {
        
        int n = books.size();
        vector<int> dp(n+1, 0);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            int width = books[i][0];
            int height = books[i][1];
            dp[i+1] = dp[i] + height;
            for (int j = i-1; j >= 0; --j) {
                width += books[j][0];
                height = max(height, books[j][1]);
                if (width > shelfWidth)
                    break;
                dp[i+1] = min(dp[i+1], dp[j] + height);
            }
        }
        return dp[n];
    }
};