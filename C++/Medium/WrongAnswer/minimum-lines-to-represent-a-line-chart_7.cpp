class Solution {
public:
    int minimumLines(vector<vector<int>>& stockPrices) {
        
        int n = stockPrices.size(), ans = 1;
        vector<int> m(n, 0);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (stockPrices[i][0] > stockPrices[j][0] && stockPrices[i][1] > stockPrices[j][1]) {
                    m[i] = max(m[i], m[j] + 1);
                }
            }
            ans = max(ans, m[i] + 1);
        }
        return ans;
    }
};