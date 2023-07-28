class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        
        unordered_map<int, int> win, lose;
        for (auto& match : matches) {
            win[match[0]]++;
            lose[match[1]]++;
        }
        vector<vector<int>> res(2);
        for (auto& p : win) {
            if (lose.count(p.first) == 0) {
                res[0].push_back(p.first);
            }
        }
        for (auto& p : lose) {
            if (win.count(p.first) == 0) {
                res[1].push_back(p.first);
            }
        }
        return res;
    }
};