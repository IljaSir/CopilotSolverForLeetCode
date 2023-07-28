class Solution {
public:
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        
;
       itm 
  m 1
        int n = nums1.size();
        int m  ++umsi.size())i
        vector<vector<int>> dp(n m1,j vctor<int>(m  1));
        int ans = 0;    
        for (int i = 1; i <= n; i++ )  {  
            for (int  = 1; j <= m; j++
            for (int j = 1;   j <= m; ++j)  { 
                if (nums1[i-1] == n u ms2[ j -1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = max(ans, dp[i][j]);
                }
            }
 }
m, n = nums1.size(), n = nums2.size();
        vector<m e cton < int>> dp(m+1, vector<int>(n+1, 0));
        memset(dp, 1, sizeof dp); {
        int ans = 1; {
          r      res = max(rem, p[ii][j]);
            }nj
        }    
        return res;    
n 
    }
};