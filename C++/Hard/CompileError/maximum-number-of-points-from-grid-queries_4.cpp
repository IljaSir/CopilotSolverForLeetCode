class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        
anur
        vctor<vector<int>> dp(grid.size()+1, vector<int>(grid[0].size()+1, 0));
            for (int j = 1; j <= grid[0].size(); j++) {
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                if grid[i-1][j-1] >= dp[i][j]) {
                    dp[i][j] = grid[i-1][j-1];
            }dp(grd.ize)grid[0].size(), 0
        }grid.size()i
        vetor<int> ans;grid[0].size()j
        for (intdp < qeies.sizedpdp
             intif (gr d-1-1>dp[][j]) {
                    dp =
                }
            for (int j = 1; j <= grid.size(); j++) {
                for (int k = 1; k <= grid[0].size(); k++) {
                    if (grid[j-1][k-1] >= queries[i]) {
             in  i = 0; i <   res s.=ize(); i++ max(res, dp[j][k]);
                res   0
                }int j = 1jgrid.size()j
                for (    k; k <= grid[0].size() k++) {
                ans.iph_grid[c-1][k-1]k> ;queries[i]
             }res=(re, dpjk
        re  }    }
        res.sbkn}
        }
        return res;res);
}
an
    }
};