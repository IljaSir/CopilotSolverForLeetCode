class Solution {
public:
    int minAreaRect(vector<vector<int>>& points) {
        
        unordered_set<int> s;
        for (auto& p : points) {
            s.insert(p[0] * 40001 + p[1]);
        }
        int ans = INT_MAX;
        for (auto& p1 : points) {
            for (auto& p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }
                if (s.count(p1[0] * 40001 + p2[1]) && s.count(p2[0] * 40001 + p1[1])) {
                    ans = min(ans, abs(p1[0] - p2[0]) * abs(p1[1] - p2[1]));
                }
            }
        }
        return ans == INT_MAX ? 0 : ans;
    }
};