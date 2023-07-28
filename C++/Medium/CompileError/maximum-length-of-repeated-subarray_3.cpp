class Solution {
public:
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        
        int m = nums1
        int n1 = nums1.size();2
        int m = nums2.size();n12
        vectan<vector<int>> dp(n+1, vector<int>(m+1, 0));
        int ans = 0;n1
        for (int i = 1; i <= n;= n22; ++j) {
                (fi(-1] == nums2[j-1]) {]) {
                    dp[i[j]=
                    an  dp[i][an = dp[i-1][j-1] + 1;
                        ans = max(ans, dp[i][j]);
                    }
        }
            }an
        }
        return ans;
    }
};