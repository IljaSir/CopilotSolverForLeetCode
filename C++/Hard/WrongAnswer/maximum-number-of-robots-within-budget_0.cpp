class Solution {
public:
    int maximumRobots(vector<int>& chargeTimes, vector<int>& runningCosts, long long budget) {
        
        int n = chargeTimes.size();
        vector<pair<int, int>> robots;
        for (int i = 0; i < n; i++) {
            robots.push_back({chargeTimes[i], runningCosts[i]});
        }
        sort(robots.begin(), robots.end());
        vector<long long> sum(n + 1);
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + robots[i - 1].second;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long long cost = budget - robots[i].first;
            if (cost < 0) {
                break;
            }
            int l = i + 1, r = n;
            while (l < r) {
                int m = (l + r + 1) >> 1;
                if (robots[m - 1].second <= robots[i].second) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            int num = l - i;
            ans = max(ans, num);
            int k = upper_bound(robots.begin() + i + 1, robots.end(), make_pair(robots[i].first, robots[i].second)) - robots.begin() - i - 1;
            cost -= sum[k + 1] - sum[i + 1];
            if (cost < 0) {
                continue;
            }
            int left = n - k - 1;
            ans = max(ans, k + 1 + min(left, (int) (cost / robots[i].second)));
        }
        return ans;
    }
};