class Solution {
public:
    int minSideJumps(vector<int>& obstacles) {
        
        int n = obstacles.size();
        vector<int> dp{1, 0, 1};
        for (int i = 1; i < n; ++i) {
            vector<int> ndp(3, INT_MAX);
            for (int j = 0; j < 3; ++j) {
                if (obstacles[i] == j + 1) {
                    continue;
                }
                ndp[j] = min(ndp[j], dp[j]);
                for (int k = 0; k < 3; ++k) {
                    if (j == k || obstacles[i] == k + 1) {
                        continue;
                    }
                    ndp[j] = min(ndp[j], dp[k] + 1);
                }
            }
            dp = move(ndp);
        }
        return *min_element(dp.begin(), dp.end());
    }
};