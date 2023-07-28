class Solution {
public:
    int maxValue(vector<vector<int>>& events, int k) {
        
        sort(events.begin(), events.end());
        int n = events.size();
        vector<vector<int>> dp(n, vector<int>(k+1, 0));
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int st = events[i][0];
            int ed = events[i][1];
            int val = events[i][2];
            dp[i][1] = val;
            for(int j = i-1; j >= 0; j--) {
                if(events[j][1] < st) {
                    for(int l = 1; l <= k; l++) {
                        dp[i][l] = max(dp[i][l], dp[j][l-1] + val);
                    }
                }
            }
            for(int j = 1; j <= k; j++) {
                dp[i][j] = max(dp[i][j], dp[i][j-1]);
                ans = max(ans, dp[i][j]);
            }
        }
        return ans;
    }
};