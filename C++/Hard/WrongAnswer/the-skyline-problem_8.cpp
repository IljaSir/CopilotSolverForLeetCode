class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        
        vector<vector<int>> res;
        map<int, int> m;
        int maxH = 0;
        for (auto &b : buildings) {
            m[b[0]] = max(m[b[0]], b[2]);
            m[b[1]] = max(m[b[1]], 0);
        }
        for (auto &p : m) {
            if (p.second >= maxH) {
                res.push_back({p.first, p.second});
            } else if (p.second < maxH) {
                res.push_back({p.first, p.second});
                res.push_back({p.first, maxH});
            }
            maxH = p.second;
        }
        for (int i = 1; i < res.size(); ++i) {
            if (res[i][1] == res[i - 1][1]) {
                res.erase(res.begin() + i--);
            }
        }
        return res;
    }
};