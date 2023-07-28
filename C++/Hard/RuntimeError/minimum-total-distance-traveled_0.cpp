class Solution {
public:
    long long minimumTotalDistance(vector<int>& robot, vector<vector<int>>& factory) {
        
        sort(robot.begin(), robot.end());
        sort(factory.begin(), factory.end(), [](const vector<int>& a, const vector<int>& b) { return a[0] < b[0]; });
        int m = robot.size();
        int n = factory.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + factory[i][1];
        }
        vector<long long> dp(n + 1, 0);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < m && robot[j] <= factory[i][0]) {
                j++;
            }
            dp[i + 1] = dp[i] + (long long)j * factory[i][0] - sum[j];
        }
        long long ans = dp[n];
        j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (j >= 0 && robot[j] >= factory[i][0]) {
                j--;
            }
            ans = min(ans, dp[i] + sum[m] - (long long)(m - j - 1) * factory[i][0]);
        }
        return ans;
    }
};