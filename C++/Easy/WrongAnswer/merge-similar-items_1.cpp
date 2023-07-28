class Solution {
public:
    vector<vector<int>> mergeSimilarItems(vector<vector<int>>& items1, vector<vector<int>>& items2) {
        
        unordered_map<int, int> m1;
        for (auto& item : items1) {
            m1[item[0]] += item[1];
        }
        unordered_map<int, int> m2;
        for (auto& item : items2) {
            m2[item[0]] += item[1];
        }
        vector<vector<int>> ret;
        for (auto& [k, v] : m1) {
            if (m2.count(k)) {
                ret.push_back({k, v + m2[k]});
            }
        }
        for (auto& [k, v] : m2) {
            if (!m1.count(k)) {
                ret.push_back({k, v});
            }
        }
        sort(ret.begin(), ret.end());
        return ret;
    }
};