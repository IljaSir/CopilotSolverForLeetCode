class Solution {
public:
    int maximumRobots(vector<int>& chargeTimes, vector<int>& runningCosts, long long budget) {
        
        int n = chargeTimes.size();
        vector<pair<int, int>> robots;
        for (int i = 0; i < n; i++)
            robots.push_back({chargeTimes[i], runningCosts[i]});
        sort(robots.begin(), robots.end());
        long long sum = 0;
        int i = 0, j = 0;
        int ans = 0;
        while (i < n) {
            while (j < n && sum + robots[j].first + (j - i + 1) * robots[j].second <= budget) {
                sum += robots[j].first + robots[j].second;
                j++;
            }
            ans = max(ans, j - i);
            sum -= robots[i].first;
            i++;
        }
        return ans;
    }
};