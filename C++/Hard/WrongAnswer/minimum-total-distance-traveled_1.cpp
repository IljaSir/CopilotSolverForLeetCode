class Solution {
public:
    long long minimumTotalDistance(vector<int>& robot, vector<vector<int>>& factory) {
        
        sort(robot.begin(), robot.end());
        sort(factory.begin(), factory.end(), [](auto &a, auto &b) { return a[0] < b[0]; });
        int n = robot.size(), m = factory.size();
        vector<int> cnt(m, 0);
        int i = 0, j = 0;
        long long ans = 0;
        while (i < n && j < m) {
            if (robot[i] <= factory[j][0]) {
                if (cnt[j] < factory[j][1]) {
                    ans += factory[j][0] - robot[i];
                    cnt[j]++;
                }
                i++;
            } else {
                j++;
            }
        }
        i = n - 1, j = m - 1;
        while (i >= 0 && j >= 0) {
            if (robot[i] >= factory[j][0]) {
                if (cnt[j] < factory[j][1]) {
                    ans += robot[i] - factory[j][0];
                    cnt[j]++;
                }
                i--;
            } else {
                j--;
            }
        }
        return ans;
    }
};