class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        
        unordered_map<int, int> m;
        for (auto& match : matches) {
            m[match[0]]++;
            m[match[1]]--;
        }
        vector<vector<int>> ans(2);
        for (auto& p : m) {
            if (p.second == 0) ans[0].push_back(p.first);
            else if (p.second == -1) ans[1].push_back(p.first);
        }
        sort(ans[0].begin(), ans[0].end());
        sort(ans[1].begin(), ans[1].end());
        return ans;
    }
};