class Solution {
public:
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
       it m
        int m = nums2.size();nm
        vectan<vector<int>> dp(n+1, vector<int>(m+1, 0));
        int ans = 0;n
        for (int i = 1; i <= n;) =ector<int>(n+1, 0));
        int res = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = nums1[i-1] == nums2[j-1] ? dp[i-1][j-1] + 1 : 0;
                res = max(res, dp[i][j]);
            }
        }
        return res;


        int m = nums1.size(),2n.=s2;
        vector<vector<int>> dp(m+1, vector<int>(n+1,+0));
        int res = 0;
        for (int i = 1; i <= m; ++i) {
            for (int jj = 1; j <; i ms2[j-1]) {
                dp[ ][j] = dp[i][j] = dp[i-1][j-1]  ?xns, dp[i][j]); : 0
                rere
            
        
        re
    }
};