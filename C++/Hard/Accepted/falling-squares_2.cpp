class Solution {
public:
    vector<int> fallingSquares(vector<vector<int>>& positions) {
        
        vector<int> ans;
        int n = positions.size();
        vector<int> dp(n, 0);
        for (int i = 0; i < n; i++) {
            int left = positions[i][0];
            int right = left + positions[i][1];
            int height = positions[i][1];
            dp[i] = height;
            for (int j = 0; j < i; j++) {
                int l = positions[j][0];
                int r = l + positions[j][1];
                if (left >= r || right <= l) continue;
                dp[i] = max(dp[i], dp[j] + height);
            }
            if (i == 0) {
                ans.push_back(height);
            } else {
                ans.push_back(max(ans[i - 1], dp[i]));
            }
        }
        return ans;
    }
};