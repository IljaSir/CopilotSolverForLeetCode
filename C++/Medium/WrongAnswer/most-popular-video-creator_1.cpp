class Solution {
public:
    vector<vector<string>> mostPopularCreator(vector<string>& creators, vector<string>& ids, vector<int>& views) {
        
        unordered_map<string, pair<string, int>> mp;
        for (int i = 0; i < creators.size(); ++i) {
            mp[creators[i]] = max(mp[creators[i]], {ids[i], views[i]});
        }
        vector<vector<string>> res;
        int max_view = 0;
        for (auto& [creator, p]: mp) {
            if (p.second > max_view) {
                max_view = p.second;
                res = {{creator, p.first}};
            } else if (p.second == max_view) {
                res.push_back({creator, p.first});
            }
        }
        return res;
    }
};