class Solution {
public:
    int maximumRobots(vector<int>& chargeTimes, vector<int>& runningCosts, long long budget) {
        
        int n = chargeTimes.size();
        vector<pair<int, int>> robots(n);
        for (int i = 0; i < n; ++i) {
            robots[i].first = chargeTimes[i];
            robots[i].second = runningCosts[i];
        }
        sort(robots.begin(), robots.end());
        
        long long sum = 0, maxCharge = 0;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            sum += robots[i].second;
            maxCharge = max(maxCharge, (long long)robots[i].first);
            if (sum + (i + 1) * maxCharge <= budget) {
                ans = i + 1;
            }
        }
        return ans;
    }
};