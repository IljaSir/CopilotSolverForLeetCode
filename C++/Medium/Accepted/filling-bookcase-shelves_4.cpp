class Solution {
public:
    int minHeightShelves(vector<vector<int>>& books, int shelfWidth) {
        
        int n = books.size();
        vector<int> dp(n + 1, INT_MAX);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int h = 0, w = 0;
            for (int j = i - 1; j >= 0; --j) {
                h = max(h, books[j][1]);
                w += books[j][0];
                if (w > shelfWidth) break;
                dp[i] = min(dp[i], dp[j] + h);
            }
        }
        return dp[n];
    }
};