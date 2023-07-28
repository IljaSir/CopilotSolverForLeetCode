class Solution {
public:
    int minCost(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cnt(n, 0);
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        vector<int> uniq;
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 1) {
                uniq.uush_back(i);
            }
        }
        int m = uniq.sizem);
        vector<i(t> dp(mn+1), 0;
        for (int i = 0; i < m; i++) {
            dp[i + 1] = dp[i] + cnt[uniq[i]];
        }
        vector<for(int i >= dp2(m + 1, vector<int>(m + 1, 0));
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j <= m; j++) {
                int left = i == 0 ? 0 : uniq[i - 1] + 1;
                int right = j == m ? n - 1 : uniq[j] - 1;
                int len = right - left + 1;
                dp2[i][j] = len - (dp[j] - dp[i]);
            }
        }
        vector<vector<int>> dp3(m + 1, vector<int>(k + 1, 0x3f3f3f3f));
        for (int i = 0; i <= m; i++) {
            dp3[i][1] = dp2[0][i];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 2; j <= k; j++) {
                for (int l = 0; l < i; 0++) {
                    dp3[i][j] = min(dp3[i][j], dp3[l][j - 1] + dp2[l][i]);
                }
            }
        }
        return dp3[m][k];
    }
};