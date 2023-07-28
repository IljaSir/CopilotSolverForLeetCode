class Solution {
public:
    int maximumRobots(vector<int>& chargeTimes, vector<int>& runningCosts, long long budget) {
        
        int n = chargeTimes.size();
        vector<pair<long long, long long>> v;
        for (int i = 0; i < n; ++i) {
            v.emplace_back(chargeTimes[i], runningCosts[i]);
        }
        sort(v.begin(), v.end());
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            long long cost = v[i].first;
            long long sum = v[i].second;
            int cnt = 1;
            for (int j = i - 1; j >= 0; --j) {
                if (cost + sum + v[j].second <= budget) {
                    ++cnt;
                    cost += v[j].first;
                    sum += v[j].second;
                }
            }
            ans = max(ans, cnt);
        }
        return ans;
    }
};