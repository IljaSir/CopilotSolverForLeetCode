class Solution {
public:
    int maximumRobots(vector<int>& chargeTimes, vector<int>& runningCosts, long long budget) {
        
        int n = chargeTimes.size();
        auto cmp = [](auto& a, auto& b) { return a[1] > b[1]; };
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> q(cmp);
        for (int i = 0; i < n; ++i) {
            q.push({chargeTimes[i], runningCosts[i]});
        }
        long long sum = 0;
        int ans = 0;
        while (!q.empty()) {
            auto [c, r] = q.top();
            q.pop();
            if (sum + c + r * ans <= budget) {
                sum += r;
                ++ans;
            }
        }
        return ans;
    }
};