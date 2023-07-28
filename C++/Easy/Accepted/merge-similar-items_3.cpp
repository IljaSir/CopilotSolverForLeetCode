class Solution {
public:
    vector<vector<int>> mergeSimilarItems(vector<vector<int>>& items1, vector<vector<int>>& items2) {
        
        unordered_map<int, int> map;
        for (auto &item: items1) {
            map[item[0]] += item[1];
        }
        for (auto &item: items2) {
            map[item[0]] += item[1];
        }
        vector<vector<int>> ret;
        for (auto &item: map) {
            ret.push_back({item.first, item.second});
        }
        sort(ret.begin(), ret.end());
        return ret;
    }
};