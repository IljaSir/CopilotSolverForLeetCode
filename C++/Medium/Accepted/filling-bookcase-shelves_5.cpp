class Solution {
public:
    int minHeightShelves(vector<vector<int>>& books, int shelfWidth) {
        
        int n = books.size();
        vector<int> dp(n + 1, INT_MAX);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0, maxH = 0;
            for (int j = i; j < n; j++) {
                sum += books[j][0];
                maxH = max(maxH, books[j][1]);
                if (sum > shelfWidth) {
                    break;
                }
                dp[j + 1] = min(dp[j + 1], dp[i] + maxH);
            }
        }
        return dp[n];
    }
};