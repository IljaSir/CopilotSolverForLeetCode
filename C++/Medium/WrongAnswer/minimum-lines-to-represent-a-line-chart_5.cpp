class Solution {
public:
    int minimumLines(vector<vector<int>>& stockPrices) {
        
        int n = stockPrices.size();
        vector<int> dp(n);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int l = 0, r = res;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (dp[m] > stockPrices[i][1]) l = m + 1;
                else r = m;
            }
            dp[l] = stockPrices[i][1];
            if (l == res) ++res;
        }
        return res;
    }
};