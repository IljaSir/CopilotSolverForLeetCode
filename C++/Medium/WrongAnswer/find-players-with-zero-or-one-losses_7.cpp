class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        
        unordered_map<int, int> loss;
        for (auto& match : matches) {
            loss[match[1]]++;
        }
        vector<vector<int>> ans(2);
        for (auto& p : loss) {
            ans[p.second == 0 ? 0 : 1].push_back(p.first);
        }
        for (int i = 0; i < 2; ++i) {
            sort(ans[i].begin(), ans[i].end());
        }
        return ans;
    }
};