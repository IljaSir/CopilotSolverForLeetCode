class Solution {
public:
    vector<int> restoreArray(vector<vector<int>>& adjacentPairs) {
        
        unordered_map<int, vector<int>> m;
        for (auto &p : adjacentPairs) {
            m[p[0]].push_back(p[1]);
            m[p[1]].push_back(p[0]);
        }
        int start = 0;
        for (auto &[k, v] : m) {
            if (v.size() == 1) {
                start = k;
                break;
            }
        }
        vector<int> res;
        int prev = -1;
        while (start != -1) {
            res.push_back(start);
            int next = m[start][0];
            if (m[start].size() == 2 && m[start][1] != prev) {
                next = m[start][1];
            }
            prev = start;
            start = next;
        }
        return res;
    }
};