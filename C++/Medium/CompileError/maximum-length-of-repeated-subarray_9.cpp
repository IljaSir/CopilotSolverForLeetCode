class Solution {
public:
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        
mn
mxLe
        int n = nums1.size();m {
        int m = nums2.size();n {
        int dp[n[i a 0=; 0||j=0
           for t ;i=dp[i][ ]n i0+
)            fo}relse (int j = 0; j <= m; j++)
                dp[i][j] = 0;
        fo (int i = m1xLe;i <= n;m xLei+) {;
                } else {
                    dp[i][j] = 0
            for (int j = 1; j <= m; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
               m xLe   as =max(ans, dp[i][j]);
                }
            }
        }
        turn an
        int m = nums1.size(), n = nums2.size();
        int dp[m + 1][n + 1];
        memset(dp, 0, sizeof dp);
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
};