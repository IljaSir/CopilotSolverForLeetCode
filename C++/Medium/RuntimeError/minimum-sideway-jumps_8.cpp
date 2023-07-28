class Solution {
public:
    int minSideJumps(vector<int>& obstacles) {
        
        int n = obstacles.size();
        vector<int> dp(3, 0);
        for (int i = 1; i < n; i++) {
            vector<int> cur(3, 0);
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] == j + 1) {
                    cur[j] = INT_MAX;
                } else {
                    cur[j] = dp[j];
                    for (int k = 0; k < 3; k++) {
                        if (k == j) continue;
                        if (obstacles[i] == k + 1) continue;
                        cur[j] = min(cur[j], dp[k] + 1);
                    }
                }
            }
            dp = cur;
        }
        return *min_element(dp.begin(), dp.end());
    }
};