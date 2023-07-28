class Solution {
public:
    vector<vector<int>> mergeSimilarItems(vector<vector<int>>& items1, vector<vector<int>>& items2) {
        
        unordered_map<int, int> m1, m2;
        for (auto& item : items1) {
            m1[item[0]] = item[1];
        }
        for (auto& item : items2) {
            m2[item[0]] = item[1];
        }
        vector<vector<int>> ret;
        for (auto& item : m1) {
            if (m2.count(item.first)) {
                ret.push_back({item.first, item.second + m2[item.first]});
            } else {
                ret.push_back({item.first, item.second});
            }
        }
        for (auto& item : m2) {
            if (m1.count(item.first) == 0) {
                ret.push_back({item.first, item.second});
            }
        }
        sort(ret.begin(), ret.end());
        return ret;
    }
};