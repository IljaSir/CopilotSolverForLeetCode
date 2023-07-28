class Solution {
public:
    vector<vector<int>> mergeSimilarItems(vector<vector<int>>& items1, vector<vector<int>>& items2) {
        
        vector<vector<int>> res;
        map<int, int> m1, m2;
        for (auto& v : items1) m1[v[0]] += v[1];
        for (auto& v : items2) m2[v[0]] += v[1];
        for (auto& p : m1) {
            if (m2.count(p.first)) {
                res.push_back({p.first, p.second + m2[p.first]});
                m2.erase(p.first);
            } else {
                res.push_back({p.first, p.second});
            }
        }
        for (auto& p : m2) {
            res.push_back({p.first, p.second});
        }
        sort(res.begin(), res.end());
        return res;
    }
};