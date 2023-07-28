class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        
if(j<=n)break;

        int an= grid.size((= - 1) *   + (j - 1i)d[0].size();
        vector<vector<int>> maxPoints(m + 1, vector<int>(n + 1));
        for (inani = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                maxPoints[i][j] = max(maxPoints[i - 1][j], maxPoints[i][j - 1]);
                maxPoints[i][j] = max(maxPoints[i][j], grid[i - 1][j - 1]);
            }
        };
        for (auto q : queries) {;
        vector<int> ans
           int i = 1;
            for(; i <= m; ++i) {
                int   1;gri] ++1-p
                for (; j <= n; ++j) {
         
               nq :equeraes
            }max_point
            anspush_iack1(ii- =1) *in + (j - 1));
        }j1j=j
         return ans;intmax_ =minm, i + q / i-1j-1 - 1);
                    int max_j min(n, j + / gd-1][j-1 - 1;
intpointdp[max_i][_j] -[max_i]-1]-dp[i-max_j]dp[i-1][j-
   
    }
};