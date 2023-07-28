class Solution {
public:
    vector<int> minDifference(vector<int>& nums, vector<vector<int>>& queries) {
        
        int n = nums.size();
        vector<vector<int>> dp(n+1, vector<int>(101, 0));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                dp[i][j] = dp[i-1][j];
            }
            dp[i][nums[i-1]]++;
        }
        vector<int> ans;
        for (auto q : queries) {
            int l = q[0], r = q[1];
            int last = -1;
            int minDiff = INT_MAX;
            for (int i = 1; i <= 100; i++) {
                if (dp[r+1][i] - dp[l][i] > 0) {
                    if (last != -1) {
                        minDiff = min(minDiff, i-last);
                    }
                    last = i;
                }
            }
            if (minDiff == INT_MAX) {
                minDiff = -1;
            }
            ans.push_back(minDiff);
        }
        return ans;
    }
};