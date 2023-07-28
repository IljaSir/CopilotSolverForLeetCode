class Solution {
public:
    int maxBuilding(int n, vector<vector<int>>& restrictions) {
        
        restrictions.push_back({1, 0});
        sort(restrictions.begin(), restrictions.end());
        for (int i = 1; i < restrictions.size(); ++i) {
            auto& cur = restrictions[i];
            auto& prev = restrictions[i - 1];
            cur[1] = min(cur[1], prev[1] + cur[0] - prev[0]);
        }
        for (int i = restrictions.size() - 2; i >= 0; --i) {
            auto& cur = restrictions[i];
            auto& next = restrictions[i + 1];
            cur[1] = min(cur[1], next[1] + next[0] - cur[0]);
        }
        int res = 0;
        for (int i = 1; i < restrictions.size(); ++i) {
            auto& cur = restrictions[i];
            auto& prev = restrictions[i - 1];
            int d = cur[0] - prev[0];
            int h = abs(cur[1] - prev[1]);
            res = max(res, (d + h) / 2 + max(cur[1], prev[1]));
        }
        return min(res, n - 1);
    }
};