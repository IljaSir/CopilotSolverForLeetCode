class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        
        vector<vector<int>> result;
        unordered_map<int, int> map;
        for (auto match : matches) {
            map[match[0]]++;
            map[match[1]]--;
        }
        vector<int> winner;
        vector<int> loser;
        for (auto m : map) {
            if (m.second == 0) {
                winner.push_back(m.first);
            } else if (m.second == -1) {
                loser.push_back(m.first);
            }
        }
        result.push_back(winner);
        result.push_back(loser);
        return result;
    }
};