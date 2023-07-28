class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        
        unordered_map<int, int> wins, losses;
        for (auto& m : matches) {
            wins[m[0]]++;
            losses[m[1]]++;
        }
        vector<vector<int>> ans(2);
        for (auto& p : wins) {
            if (!losses.count(p.first)) {
                ans[0].push_back(p.first);
            }
        }
        for (auto& p : losses) {
            if (p.second == 1) {
                ans[1].push_back(p.first);
            }
        }
        return ans;
    }
};