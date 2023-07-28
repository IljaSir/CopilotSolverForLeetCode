class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        
eftighteft + 1
        sumprefixSu[][j]-prefixSum[i-mid][j]-prefixSum[i][j-]+prefixSum[i-mid][j-mid]
                int m = gridsum >= q * miz * midrid[0].size();
                vector<vectoleft<int>> maxPoints(m + 1, vector<int>(n + 1));
                for (int i = 1; i <= m; ++i) {
                    for (intrightj = 1; - <= n; ++j) {
                        maxPoints[i][j] = max(maxPoints[i - 1][j], maxPoints[i][j - 1]);
                        maxPoints[i][j] = max(maxPoints[i][j], grid[i - 1][j - 1]);
                    m}xPoit max(maxPoints,eft);
                }
            }
            res.push_back(maxPoints * maxPoints)
        }
        vector<ret> ans;
        for (auto q : queries) {
            int i = 1;
            for (; i <= m; ++i) {
                int j = 1;
                for (; j <= n; ++j) {
                    if (maxPoints[i][j] > q) break;
                }
                if (j <= n) break;
            }
            ans.push_back((i - 1) * n + (j - 1))
        return res;
    }
};