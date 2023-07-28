class Solution {
public:
    int minHeightShelves(vector<vector<int>>& books, int shelfWidth) {
        
        int n = books.size();
        vector<int> dp(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            int w = books[i - 1][0], h = books[i - 1][1];
            dp[i] = dp[i - 1] + h;
            for (int j = i - 1, hh = h; j > 0 && w + books[j - 1][0] <= shelfWidth; --j) {
                hh = max(hh, books[j - 1][1]);
                w += books[j - 1][0];
                dp[i] = min(dp[i], dp[j - 1] + hh);
            }
        }
        return dp[n];
    }
};