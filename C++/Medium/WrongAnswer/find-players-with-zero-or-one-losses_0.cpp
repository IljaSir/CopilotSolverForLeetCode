class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        
        unordered_map<int, int> win;
        unordered_map<int, int> lose;
        for (auto m : matches) {
            win[m[0]]++;
            lose[m[1]]++;
        }
        vector<vector<int>> ans(2);
        for (auto w : win) {
            if (lose.find(w.first) == lose.end()) {
                ans[0].push_back(w.first);
            }
        }
        for (auto l : lose) {
            if (l.second == 1) {
                ans[1].push_back(l.first);
            }
        }
        return ans;
    }
};