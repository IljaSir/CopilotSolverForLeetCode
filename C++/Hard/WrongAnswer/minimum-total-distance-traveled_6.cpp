class Solution {
public:
    long long minimumTotalDistance(vector<int>& robot, vector<vector<int>>& factory) {
        
        int n = robot.size();
        int m = factory.size();
        vector<long long> cnt(m);
        for (int i = 0; i < m; ++i) {
            cnt[i] = factory[i][1];
        }
        sort(robot.begin(), robot.end());
        sort(factory.begin(), factory.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });
        long long ans = 0;
        for (int i = 0, j = 0; i < n; ++i) {
            while (j + 1 < m && abs(robot[i] - factory[j][0]) > abs(robot[i] - factory[j + 1][0])) {
                ++j;
            }
            ans += abs(robot[i] - factory[j][0]);
            --cnt[j];
            if (cnt[j] == 0) {
                ++j;
            }
        }
        return ans;
    }
};