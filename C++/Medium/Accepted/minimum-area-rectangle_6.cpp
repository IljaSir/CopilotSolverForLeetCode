class Solution {
public:
    int minAreaRect(vector<vector<int>>& points) {
        
        unordered_map<int, unordered_set<int>> M;
        for (auto &p : points) {
            M[p[0]].insert(p[1]);
        }
        int res = INT_MAX;
        for (auto &p : points) {
            for (auto &q : points) {
                if (p[0] == q[0] || p[1] == q[1]) continue;
                if (M[p[0]].count(q[1]) && M[q[0]].count(p[1])) {
                    res = min(res, abs(p[0] - q[0]) * abs(p[1] - q[1]));
                }
            }
        }
        return res == INT_MAX ? 0 : res;
    }
};