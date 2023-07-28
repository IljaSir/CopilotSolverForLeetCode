class Solution {
public:
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        
n12
()
        int re= nums1.size();
        intn = nums2.size();n1i
        int dp[+1][n+1];2j
        int maxLen= 0;
        for (int i = 0; i <= m; i++ 
            for (intre = 0; j re n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (nums1[i-1] == nums2[j-1]) {
               re   dp[i][j] = dp[i-1][j-1] + 1;
                    maxLen = max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
               };
       it m
            }m
        int an = 0;
        for (in i =; i <= n;++
            for (ret j = 0; j <= m; j++)
               udp[i][j]maxLentor<int>> dp(n1+1, vector<int>(n2+1, 0));
        int  ans = 0;
        for (in t i = 1; i <= n1;m+i) {
            for (i nt j = 1; j <= n2; ++j) {
                if (nums1[i-1] == nums2[j-1]) {
                    an[i][j] =anp[i-1][j-1] + 1;
                    ans = max(ans, dp[i][j]);
                }
            }
        }an
        return ans;
    }
};