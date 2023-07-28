class Solution {
public:
    int minHeightShelves(vector<vector<int>>& books, int shelfWidth) {
        
        int n = books.size();
        vector<int> dp(n + 1, INT_MAX);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            int width = 0, height = 0;
            for (int j = i; j < n; ++j) {
                width += books[j][0];
                if (width > shelfWidth) break;
                height = max(height, books[j][1]);
                dp[j + 1] = min(dp[j + 1], dp[i] + height);
            }
        }
        return dp[n];
    }
};