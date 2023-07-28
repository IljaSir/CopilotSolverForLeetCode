class Solution {
public:
    long long minimumTotalDistance(vector<int>& robot, vector<vector<int>>& factory) {
        
        sort(robot.begin(), robot.end());
        int n = robot.size();
        vector<long long> sum(n);
        sum[0] = robot[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + robot[i];
        }
        long long res = 0;
        for (auto& f : factory) {
            res += f[1] * (upper_bound(robot.begin(), robot.end(), f[0]) - lower_bound(robot.begin(), robot.end(), f[0]));
            if (f[1] < n) {
                int pos = lower_bound(robot.begin(), robot.end(), f[0]) - robot.begin();
                if (pos > 0) {
                    res += f[1] * f[0] - (sum[pos - 1] + f[1] * f[0]);
                }
                if (pos + f[1] < n) {
                    res += sum[pos + f[1] - 1] - sum[pos - 1] - f[1] * f[0];
                }
            }
        }
        return res;
    }
};