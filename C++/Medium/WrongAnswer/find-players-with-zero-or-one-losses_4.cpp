class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        
        map<int, int> m;
        for (auto& match : matches) {
            m[match[0]]++;
            m[match[1]]--;
        }
        vector<vector<int>> res(2);
        for (auto& p : m) {
            if (p.second > 0) {
                res[0].push_back(p.first);
            } else if (p.second == 0) {
                res[1].push_back(p.first);
            }
        }
        return res;
    }
};