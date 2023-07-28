class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        
        int n = events.size();
        sort(events.begin(), events.end());
        vector<int> dp(n, 0);
        dp[n-1] = events[n-1][2];
        for (int i = n-2; i >= 0; i--) {
            int j = i+1;
            int k = n-1;
            while (j < k) {
                int mid = j + (k-j)/2;
                if (events[mid][0] >= events[i][1]) {
                    k = mid;
                } else {
                    j = mid+1;
                }
            }
            if (events[j][0] >= events[i][1]) {
                dp[i] = max(dp[i+1], events[i][2] + dp[j]);
            } else {
                dp[i] = max(dp[i+1], events[i][2]);
            }
        }
        return dp[0];
    }
};