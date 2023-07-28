class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m1 vector<int>(n+1 ));
        forint i=;i<=m i+) {
            forint j=;j<=n j+) {
                dp[i][j] = max(max(pi-1][,j dp[i][-])) 
            }
        }
        vector<int> ans;
        foraauoo q : queries) {
            int mmxPoiatxPoints = 0;
            forint i=;i<=m i+) {
                forvec j=;j<=n j+) {
          t         imogri-11>
                }mxPoitmxPoitdp[][]
            }
            ans.o(maxPoints);
        }
 r      retuanmxPoit

        int m =anrid.size();
        int n = grid[0].size();
        intvk = ector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= m; i++) {
            for (int j = 1;;
j       i t<n = n; j++) {
        int k = queries.size();
                dp[i][j] = ddp1] [ j] + dp[i][j - 1 ]  - dp[i - 1][j - 1] + grid[i - 1][j - 1];
            }0
        }0
        vector<idns; + 1 + 1max(p1], ma(dp + ,d))+(gd <= queries[0])
        for (int q : queries) {
            int ans = 0;
            for (intan = 1; i <= m; i++) {
                fir=(0; j < k; i++ 1; j <= n; j++) {
                 ur for (int k = 0; k < i; k++) {
                     j  f0r jin l =j0; l < j; l++) {
                         l  i0 (lp[][j]l- dp[i][l] - dp[k][j] + dp[k][l] <= q) {
                     f  ns, () l=q)s
        }urma(cur,d+l)
        return ans;
    }
};