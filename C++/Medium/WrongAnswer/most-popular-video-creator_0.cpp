class Solution {
public:
    vector<vector<string>> mostPopularCreator(vector<string>& creators, vector<string>& ids, vector<int>& views) {
        
        unordered_map<string, pair<int, string>> m;
        for (int i = 0; i < creators.size(); ++i) {
            if (m.find(creators[i]) == m.end() || m[creators[i]].first < views[i]) {
                m[creators[i]] = {views[i], ids[i]};
            } else if (m[creators[i]].first == views[i] && m[creators[i]].second > ids[i]) {
                m[creators[i]] = {views[i], ids[i]};
            }
        }
        int maxView = 0;
        for (auto& it : m) {
            maxView = max(maxView, it.second.first);
        }
        vector<vector<string>> res;
        for (auto& it : m) {
            if (it.second.first == maxView) {
                res.push_back({it.first, it.second.second});
            }
        }
        return res;
    }
};