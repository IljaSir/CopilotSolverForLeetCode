class Solution {
public:
    int maximumRobots(vector<int>& chargeTimes, vector<int>& runningCosts, long long budget) {
        
        int n = chargeTimes.size();
        vector<pair<int, int>> robots;
        for (int i = 0; i < n; i++) {
            robots.push_back({chargeTimes[i], runningCosts[i]});
        }
        sort(robots.begin(), robots.end());
        long long sum = 0;
        int ans = 0;
        for (int i = 0, j = 0; i < n; i++) {
            sum += robots[i].second;
            budget -= robots[i].first;
            while (j <= i && budget < sum) {
                budget += robots[j].first;
                sum -= robots[j].second;
                j++;
            }
            ans = max(ans, i - j + 1);
        }
        return ans;
    }
};