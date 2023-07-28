class Solution {
public:
    long long minimumTotalDistance(vector<int>& robot, vector<vector<int>>& factory) {
        
        vector<int> factories;
        for (auto& f : factory) {
            factories.push_back(f[0]);
        }
        sort(factories.begin(), factories.end());
        sort(robot.begin(), robot.end());
        long long ans = 0;
        for (auto r : robot) {
            auto it = lower_bound(factories.begin(), factories.end(), r);
            if (it == factories.begin()) {
                ans += abs(r - *it);
            } else if (it == factories.end()) {
                ans += abs(r - *(it - 1));
            } else {
                ans += min(abs(r - *it), abs(r - *(it - 1)));
            }
        }
        return ans;
    }
};