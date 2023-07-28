class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        
max_point=max(max_point,point);

        int m = grid.size();
        int n = grid[0].simax_point);
        vector<vector<int>> dp(m+1, vector<int>(n+1));
        vector<int> ans;
        for(int i = 0; i < m; i++) {
       
     for(int j = 0; j < n; j++) {
        // find the maximum value in the grid                dp[i+1][j+1] = grid[i][j] + dp[i+1][j] + dp[i][j+1] - dp[i][j];
            }axVal = 0;
        for(int i 0; i < ;++i) {
            for (itj 0; j < i ++j) {
                maxVal = max(maxVal, grid[i][j]);
            }
        }
        // create a prefix sum matrix
        }vector<>prefixSum(grid.ize) + 1, vcto<nt>(grid[0] + 1, 0)
        for(int q : q1eries=)grid.size(){
            int max_point = 0;=grid[i-1].size()
            for(pneftxSumi = 1; i prefixSu<[i-1][j] + prefi Sum[i][j-1] - p efixSum+)-1 {-1+ -1
                for(int j = 1; j <= n; j++) {
                    int max_i = min(m, i + q / grid[i-1][j-1] - 1);
        //     each query, f  d  he max mum value
i a_=(  vector<int> res;
                iqt:pqueries)n{
  [         if (q > maxVal_i][max_j] - dp[max_i][j-1] - dp[i-1][max_j] + dp[i-1][j-1];
                 es.push_b=ckmax(m.sxze()t* , poi0].snze());
              t;continue
                }
            int maxPoints = 0;   }
                ans.push_1ack(m=agoid)
             }for( j = 1;j<gd-1.size() ++j) {
                return anefts;1ightin(i,j)
        eftight
        
    }
};